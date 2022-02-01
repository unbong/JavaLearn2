package com.example.week13_topic6.mq.impl;

import com.example.week13_topic6.mq.Message;
import com.example.week13_topic6.mq.MessageQueue;
import lombok.Data;
import lombok.SneakyThrows;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;


public class MemoryMessageQueue implements MessageQueue {

    private String topic;
    private int capacity;
    private LinkedBlockingQueue<Message> queue;

    public MemoryMessageQueue(String topic, int capacity)
    {
        this.topic = topic;
        this.capacity = capacity;
        this.queue = new LinkedBlockingQueue<>(capacity);
    }

    public void add(Message data)
    {
        queue.add(data);
    }

    @Override
    public Message poll() {
        return poll(10000);
    }

    @SneakyThrows
    public Message poll(long timeout)
    {
        return queue.poll( timeout, TimeUnit.MILLISECONDS );
    }




}
