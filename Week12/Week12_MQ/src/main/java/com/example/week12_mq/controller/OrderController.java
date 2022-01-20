package com.example.week12_mq.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.week12_mq.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.jms.*;

@Slf4j
@RestController()
@RequestMapping("order")
public class OrderController {

    @Autowired
    Session session;

    @PostMapping("/product")
    public String product(@RequestBody Order order)
    {
        try {
            Destination destination = session.createQueue("product.order");
            MessageProducer producer  = session.createProducer(destination);

            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

            String data =  JSONObject.toJSONString(order);
            log.info("requested data {}", data);

            TextMessage  message  =session.createTextMessage(data);
            producer.send(message);

        } catch (JMSException e) {
            e.printStackTrace();
            return "failed";
        }
        return "success";
    }


    @GetMapping("/comsume")
    public String consumeQueue()
    {

        try {
            Destination  destination = session.createQueue("product.order");
            MessageConsumer consumer = session.createConsumer(destination);

//
//
//            consumer.setMessageListener(message -> {
//                message.
//            });

            Message  message = consumer.receive(1000);

            return message.toString();

        } catch (JMSException e) {
            e.printStackTrace();

            return  "failed";
        }
    }
}
