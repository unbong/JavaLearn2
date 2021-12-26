package com.example.week8.service.impl;

import com.baomidou.mybatisplus.core.assist.ISqlRunner;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import com.example.common.utils.PageUtils;
//import com.example.common.utils.Query;

import com.example.week8.dao.OrderDao;
import com.example.week8.entity.OrderEntity;
import com.example.week8.service.OrderService;


@Service("orderService")
public class OrderServiceImpl extends ServiceImpl<OrderDao, OrderEntity> implements OrderService {
    @Override
    public void update(OrderEntity order) {


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