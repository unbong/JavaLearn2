package com.example.week13_topic6.mq;

import com.example.week13_topic6.mq.impl.CustomMessageQueue;
import com.example.week13_topic6.mq.impl.MemoryMessageQueue;

import java.util.HashMap;
import java.util.Map;

public class Broker {

    private final int SIZE = 64;
    private final int CAPACITY = 10000;
    private Map<String, MessageQueue> map = new HashMap<>(SIZE);



    public MQProduct createProduct (String topic)
    {
        if(map.containsKey(topic))
        {
            return new MQProduct(topic, map.get(topic));
        }
        else
        {
            //MessageQueue queue = new MemoryMessageQueue(topic , CAPACITY);
            MessageQueue queue = new CustomMessageQueue(topic);
            map.put(topic, queue);
            return new MQProduct(topic, queue);
        }

    }

    public MQConsumer createConsumer(String    topic)
    {
        return new MQConsumer(topic, map.get(topic));
    }



}
