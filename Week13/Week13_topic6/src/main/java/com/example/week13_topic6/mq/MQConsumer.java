package com.example.week13_topic6.mq;

import com.example.week13_topic6.mq.impl.MemoryMessageQueue;

public class MQConsumer {
    private  String topic;
    private MessageQueue queue;
    private long timeout_millisecond = 10000;

    public MQConsumer(String topic, MessageQueue queue)
    {
        this.topic = topic;
        this.queue = queue;
    }


    public Message consume()
    {
//        return queue.poll(timeout_millisecond);
        return queue.poll();
    }

}
