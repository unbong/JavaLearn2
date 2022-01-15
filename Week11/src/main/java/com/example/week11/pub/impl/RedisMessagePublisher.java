package com.example.week11.pub.impl;

import com.example.week11.pub.MessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;


/**
 * 信息发布的实现类
 *
 */
public class RedisMessagePublisher implements MessagePublisher {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Autowired
    ChannelTopic topic;

    public RedisMessagePublisher()
    {

    }

    public RedisMessagePublisher(RedisTemplate<Object, Object> redisTemplate, ChannelTopic topic)
    {
        this.redisTemplate = redisTemplate;
        this.topic = topic;
    }

    /**
     *
     * pub 发送信息
     * @param message
     */
    @Override
    public void publish(Object message) {
        redisTemplate.convertAndSend(topic.getTopic(), message);
    }
}
