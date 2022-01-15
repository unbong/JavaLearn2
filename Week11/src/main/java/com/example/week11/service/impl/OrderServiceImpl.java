package com.example.week11.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.week11.pub.MessagePublisher;
import com.example.week11.pub.impl.RedisMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import com.example.common.utils.PageUtils;
//import com.example.common.utils.Query;

import com.example.week11.dao.OrderDao;
import com.example.week11.entity.OrderEntity;
import com.example.week11.service.OrderService;


@Service("orderService")
public class OrderServiceImpl extends ServiceImpl<OrderDao, OrderEntity> implements OrderService {

    @Autowired
    MessagePublisher publisher;
    @Override
    public List<OrderEntity> queryPage(Map<String, Object> params) {


        return baseMapper.selectList(new QueryWrapper<>());
    }

    @Override
    public boolean addOrderWithPubSub(OrderEntity entity) {

        publisher.publish(entity);

        return true;
    }


}