package com.example.rpcfx.provicer.service;

import com.unbong.api.Order;
import com.unbong.api.OrderService;

public class OrderServiceImpl implements OrderService {
    @Override
    public Order findById(long orderId) {
        Order order = new Order();
        order.setOrderId(1L);
//        order.setAmount(100);
        return order;
    }
}
