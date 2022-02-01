package com.example.week13_topic6.mq;

public interface MessageQueue {

    public void add(Message data);

    public Message poll();
}
