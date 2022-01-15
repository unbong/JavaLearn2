package com.example.week11.service;

import com.baomidou.mybatisplus.extension.service.IService;
//import com.example.common.utils.PageUtils;
import com.example.week11.entity.OrderEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author unbong
 * @email unbong@gmail.com
 * @date 2022-01-12 21:57:44
 */
public interface OrderService extends IService<OrderEntity> {

    List<OrderEntity> queryPage(Map<String, Object> params);

    boolean addOrderWithPubSub(OrderEntity entity);
}

