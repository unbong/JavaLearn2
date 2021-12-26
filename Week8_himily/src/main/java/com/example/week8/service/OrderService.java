package com.example.week8.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.week8.entity.OrderEntity;

/**
 * 
 *
 * @author unbong
 * @email unbong@gmail.com
 * @date 2021-12-25 17:26:50
 */
public interface OrderService extends IService<OrderEntity> {
//    ISqlRunner getBaseMapper();

//    PageUtils queryPage(Map<String, Object> params);


   // void add(OrderEntity order);


    void update(OrderEntity order);

}

