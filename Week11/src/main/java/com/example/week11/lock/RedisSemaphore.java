package com.example.week11.lock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisSemaphore {

    @Autowired
    StringRedisTemplate redisTemplate;


    private String keyName;

    public boolean createSemaphore( String keyName, int amount, long timeOutSecond){
        this.keyName = keyName;
        long start = System.currentTimeMillis();

        boolean result = redisTemplate.opsForValue().setIfAbsent(keyName, Integer.valueOf(amount).toString(), timeOutSecond, TimeUnit.SECONDS);

        if(result == true)
        {
            return  true;
        }

        while(true)
        {
            long duration = System.currentTimeMillis() - start;
            if( duration > timeOutSecond * 1000)
            {
                return false;
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            result = redisTemplate.opsForValue().setIfAbsent(keyName, Integer.valueOf(amount).toString(), timeOutSecond, TimeUnit.SECONDS);

            if (result == true)
                return result;

        }
    }



    public boolean getSemaphore()
    {
        Long amount =redisTemplate.opsForValue().decrement(this.keyName);
        if (amount <= 0)
        {
            return false;

        }

        return true;
    }
}


