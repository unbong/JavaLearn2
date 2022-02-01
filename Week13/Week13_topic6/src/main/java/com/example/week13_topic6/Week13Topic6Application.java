package com.example.week13_topic6;

import com.example.week13_topic6.mq.Broker;
import com.example.week13_topic6.mq.MQConsumer;
import com.example.week13_topic6.mq.MQProduct;
import com.example.week13_topic6.mq.Message;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Week13Topic6Application {

    public static void main(String[] args) {
        SpringApplication.run(Week13Topic6Application.class, args);


        Broker b = new Broker();
        MQProduct p = b.createProduct("test");
        HashMap<String ,Object> header = new HashMap<>();
        Message body = new Message<String>(header, "test message");
        p.send(body);

        MQConsumer consumer = b.createConsumer("test");
        Message message =consumer.consume();
        System.out.println(message.getBody().toString());

    }

}
