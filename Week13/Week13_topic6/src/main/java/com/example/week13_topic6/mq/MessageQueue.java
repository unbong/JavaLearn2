package com.example.week13_topic6.mq;

import lombok.Data;
import lombok.SneakyThrows;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;


public class MessageQueue<T> {

    private String topic;
    private int capacity;
    private LinkedBlockingQueue<T> queue;

    public MessageQueue(String topic, int capacity)
    {
        topic = topic;
        capacity = capacity;
        queue = new LinkedBlockingQueue<T>(capacity);
    }

    public void add(T data)
    {
        queue.add(data);
    }

    @SneakyThrows
    public T poll(long timeout)
    {
        return queue.poll( timeout, TimeUnit.MILLISECONDS );
    }




}
