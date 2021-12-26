package com.example.week8.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.week8.dao.OrderDao;
import com.example.week8.entity.OrderEntity;
import com.example.week8.service.OrderService;
import org.springframework.stereotype.Service;


@Service("orderService")
public class OrderServiceImpl extends ServiceImpl<OrderDao, OrderEntity> implements OrderService {
    @Override
    @HmilyTCC(confirmMethod = "confirmNested", cancelMethod = "cancelNested")
    public void update(OrderEntity order) {

        this.update(order);
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean cancelNested(AccountNestedDTO accountNestedDTO) {
        LOGGER.info("============cancelNested 执行取消付款接口===============");
        return accountMapper.cancel(buildAccountDTO(accountNestedDTO)) > 0;
    }


    @Transactional(rollbackFor = Exception.class)
    public boolean confirmNested(AccountNestedDTO accountNestedDTO) {
        LOGGER.info("============confirmNested确认付款接口===============");
        return accountMapper.confirm(buildAccountDTO(accountNestedDTO)) > 0;
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