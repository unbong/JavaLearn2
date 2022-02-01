package com.example.week13_topic6.mq;

import java.util.HashMap;
import java.util.Map;

public class Broker {

    private final int SIZE = 64;
    private final int CAPACITY = 10000;
    private Map<String, MessageQueue<> > map = new HashMap<>(SIZE);



    public MQProduct createProduct (String topic)
    {
        return new MQProduct(topic, map.get(topic));

    }

    public MQConsumer createConsumer(String    topic)
    {
        return new MQConsumer(topic, map.get(topic));
    }



}
