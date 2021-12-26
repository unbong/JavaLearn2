package com.example.week8;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.week8.entity.OrderEntity;
import com.example.week8.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
class Week8ApplicationTests {

    @Test
    void contextLoads() {
    }


    @Autowired
    OrderService orderService;

    @Test
    public void AddOrder() {
        OrderEntity order = new OrderEntity();
        order.setAmount(100L);
//        order.setOrderId("2");
//        order.setOrderId(1L);
        order.setAmount(1000L);
        order.setCoupon("1");
        order.setQuantity(100000);
        order.setProductId(1);
        order.setUserId(2);
        order.setCreateTimestamp("" +System.currentTimeMillis());
        order.setUpdateTimestamp("" +System.currentTimeMillis());

        orderService.save(order);
    }

    @Test
    public void getAllOrder()
    {
        List list =orderService.list(new QueryWrapper<>());

        list.stream().forEach(item->{
            System.out.println(item.toString());
        });
    }

    public void updateOrder()
    {
        OrderEntity order = orderService.getById(1475066592185327617L);
        order.setAmount(2000L);
        if (orderService.save(order) )
        {
            System.out.println("update success.");
        }
        else
        {
            System.out.println("update failed.");
        }
//        orderService.update();
    }
}
