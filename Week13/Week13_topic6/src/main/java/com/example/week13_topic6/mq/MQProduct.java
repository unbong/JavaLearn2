package com.example.week13_topic6.mq;

import com.example.week13_topic6.mq.impl.MemoryMessageQueue;

public class MQProduct {
    private  String topic;
    private MessageQueue queue;
    public MQProduct(String topic, MessageQueue memoryMessageQueue) {
        this.topic = topic;
        this.queue = memoryMessageQueue;
    }

    public void send(Message message)
    {
        queue.add(message);
    }
}
