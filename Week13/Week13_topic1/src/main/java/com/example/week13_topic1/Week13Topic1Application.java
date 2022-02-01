package com.example.week13_topic1;

import com.example.week13_topic1.entity.Order;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class Week13Topic1Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Week13Topic1Application.class, args);
        KafkaTemplate kafkaTemplate = context.getBean(KafkaTemplate.class);


        Order order =new Order();
        order.setOrderId(1);
        order.setCoupon("10");
        order.setAmount(10L);
        kafkaTemplate.send("order",order.toString());
    }

    @KafkaListener(topics = "topic")
    public void receive(String message) {
        System.out.println("message:" + message);
    }

}
