package com.example.week11.config;

import com.example.week11.pub.MessagePublisher;
import com.example.week11.pub.impl.RedisMessagePublisher;
import com.example.week11.sub.RedisMessageSubscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnection;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import java.util.Arrays;

@Configuration
public class PubSubConfig {

    @Autowired
    RedisTemplate<Object, Object> redisTemplate;


    @Autowired
    RedisMessageSubscriber subscriber;


    /**
     * 监听适配器，包含了监听器的实现
     *
     * @return
     */
    @Bean
    public MessageListenerAdapter messageListner()
    {
        return new MessageListenerAdapter(subscriber);
    }

    @Bean
    public LettuceConnectionFactory connectionFactory()
    {
        return  new LettuceConnectionFactory(
                new RedisStandaloneConfiguration("192.168.56.10", 6379));
    }



    /**
     * 处理低级别的细节, 关联监听器与主题.
     *
     * @return
     */
    @Bean
    public RedisMessageListenerContainer redisContainer()
    {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory());
        container.addMessageListener(messageListner(), topic());

        return container;
    }

    @Bean
    public MessagePublisher redisPublisher()
    {
        return new RedisMessagePublisher(redisTemplate, topic());
    }

    @Bean
    public ChannelTopic topic() {

        return new ChannelTopic("orderMessage");
    }
}
