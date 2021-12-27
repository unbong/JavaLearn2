package com.example.week8.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.week8.dao.OrderDao;
import com.example.week8.entity.OrderEntity;
import com.example.week8.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.dromara.hmily.annotation.Hmily;
import org.dromara.hmily.core.bootstrap.HmilyTransactionBootstrap;
import org.dromara.hmily.core.concurrent.threadlocal.HmilyTransactionContextLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("orderService")
@Slf4j
public class OrderServiceImpl extends ServiceImpl<OrderDao, OrderEntity> implements OrderService {


    @Autowired
    OrderDao orderDao;

    @Override
    @Transactional
    @Hmily(confirmMethod = "commit", cancelMethod = "cancel")
    public void update_(OrderEntity order) {
        // 获取全局事务
        String transId = HmilyTransactionContextLocal.getInstance().get().getTransId();


        // 幂等判断 如果事务已经存在不继续执行
        if(orderDao.isExist(transId) > 0)
        {
            log.info("try 已经执行。");
            return;
        }


        // try 悬挂处理
        if(orderDao.isExistConfirm(transId) > 0 ||orderDao.isExistCancel(transId) > 0 )
        {
            log.info("try 悬挂处理， cancel或confirm已经执行，不允许执行try XID{}", transId);
            return ;
        }

        orderDao.update_(order.getOrderId(), order.getAmount() + 1);

        orderDao.update_(order.getOrderId()+1, order.getAmount() - 1);


        orderDao.addTry(transId);
//        List<OrderEntity> list = this.list(new QueryWrapper<>());
//
//
//
//        list.forEach(item->{
//            item.setAmount(-1L);
//            this.update(item);
//        });




        //this.update(order);
    }


    //confirm方法
    @Transactional
    public void commit(OrderEntity order){
        //获取全局事务id
        String transId = HmilyTransactionContextLocal.getInstance().get().getTransId();
        log.info(" 开始执行...xid:{},accountNo:{},amount:{}",transId,order.getOrderId(),order.getAmount());
    }

    /** cancel方法
     * 	cancel幂等校验
     * 	cancel空回滚处理
     * 	增加可用余额
     * @param accountNo
     * @param amount
     */
    @Transactional
    public void rollback(String accountNo, Long amount){
        //获取全局事务id
        String transId = HmilyTransactionContextLocal.getInstance().get().getTransId();
        log.info(" cancel begin 开始执行...xid:{}",transId);
        //	cancel幂等校验
        if(orderDao.isExistCancel(transId) > 0){
            log.info(" cancel 已经执行，无需重复执行,xid:{}",transId);
            return ;
        }

        //cancel空回滚处理，如果try没有执行，cancel不允许执行
        if(orderDao.isExist(transId)<=0){
            log.info(" 空回滚处理，try没有执行，不允许cancel执行,xid:{}",transId);
            return ;
        }


//        orderDao.addAccountBalance(accountNo,amount);
        //插入一条cancel的执行记录
        orderDao.addCancel(transId);
        log.info(" cancel end 结束执行...xid:{}",transId);
    }


//    @Override
//    public PageUtils queryPage(Map<String, Object> params) {
//        IPage<Order1Entity> page = this.page(
//                new Query<Order1Entity>().getPage(params),
//                new QueryWrapper<Order1Entity>()
//        );
//
//        return new PageUtils(page);
//    }

}