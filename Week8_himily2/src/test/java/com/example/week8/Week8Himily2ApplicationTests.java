package com.example.week8;

import com.example.week8.entity.OrderEntity;
import com.example.week8.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Week8Himily2ApplicationTests {

    @Autowired
    OrderService orderService;

    @Test
    void contextLoads() {

        OrderEntity order =  new OrderEntity();
        order.setOrderId(1L);
        order.setAmount(12L);
        orderService.update_(order);
    }

}
