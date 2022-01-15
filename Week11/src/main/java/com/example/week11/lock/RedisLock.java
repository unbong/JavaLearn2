package com.example.week11.lock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class RedisLock {

    @Autowired
    RedisTemplate<Object, Object> redisTemplate ;

    private  long timeout = 30000;
    private  String lockKey = "dlock";

    private String unlockScript = " if redis.call( 'get' ,KEYS[1] ) == ARGV[1] then "+
            " return redis.call( 'del', KEYS[1]) "+
            " else "+
            " return 0 "+
            " end ";

    private String lockValue = "";

    /**
     * 加锁
     * @param second
     * @return
     */
    public boolean lock(long second)
    {
        long start = System.currentTimeMillis();
        if (second > 0)
        {
            //Object result =redisTemplate.execute(new DefaultRedisScript<>(lockScript),Arrays.asList("dlock"), millisecond);
            lockValue = UUID.randomUUID().toString();
            Boolean result = redisTemplate.opsForValue().setIfAbsent(lockKey, lockValue , 30, TimeUnit.SECONDS);
            log.info("is locked: {}", result);
            if (result == true)
            {
                return result;
            }else{
                while (true)
                {

                    long uTime = System.currentTimeMillis() - start;
                    if (uTime > timeout){

                        log.info("get lock time out {}", lockKey, lockValue);
                        return false;
                    }

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    result = redisTemplate.opsForValue().setIfAbsent(lockKey, lockValue , second, TimeUnit.SECONDS);
                    if (result == true)
                        return result;
                }
            }

        }else{
            return false;
        }


    }

    /**
     * 释放锁
     *
     * @return
     */
    public boolean unlock()
    {
        Long res = redisTemplate.execute(new DefaultRedisScript<>(unlockScript,Long.class ),
                Arrays.asList(lockKey), lockValue);
        log.info("unlock: {}",res);


        return true;
    }
}
