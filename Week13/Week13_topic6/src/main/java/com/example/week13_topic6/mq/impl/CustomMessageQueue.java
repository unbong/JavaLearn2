package com.example.week13_topic6.mq.impl;

import com.example.week13_topic6.mq.Message;
import com.example.week13_topic6.mq.MessageQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomMessageQueue implements MessageQueue {

    private String topic;
    private AtomicInteger createIndex = new AtomicInteger(0);
    private AtomicInteger consumeIndex = new AtomicInteger(0);
    private List<Message> queue = new ArrayList<>();

    public CustomMessageQueue(String topic)
    {
        this.topic = topic;
    }

    @Override
    public void add(Message data) {
        queue.add(data);
        createIndex.incrementAndGet();
    }

    @Override
    public Message poll() {
        if(consumeIndex.get()>= createIndex.get())
            return null;
        else
            return queue.get(consumeIndex.getAndIncrement());
    }
}
