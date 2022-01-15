package com.example.week11.sub;

import com.alibaba.fastjson.JSON;
import com.example.week11.entity.OrderEntity;
import com.example.week11.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.SerializationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;



/**
 * 获取信息后处理的类
 */

@Slf4j
@Component
public class RedisMessageSubscriber implements MessageListener {

    @Autowired
    OrderService orderService;

    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    @Override
    public void onMessage(Message message, byte[] pattern) {

        log.info( "onMessage {}",message.toString()) ;
//        OrderEntity  entity =JSON.parseObject(message.getBody(), OrderEntity.class);
//        OrderEntity  entity  = (OrderEntity) SerializationUtils.deserialize(message.getBody());

        OrderEntity entity = (OrderEntity)redisTemplate.getValueSerializer().deserialize(message.getBody());


        orderService.save(entity);

        log.info("bytr: {}", message.getBody());
    }
}
