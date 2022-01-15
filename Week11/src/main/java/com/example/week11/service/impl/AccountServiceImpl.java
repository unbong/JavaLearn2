package com.example.week11.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.week11.entity.AccountEntity;
import com.example.week11.lock.RedisLock;
import com.example.week11.lock.RedisSemaphore;
import com.example.week11.service.AccountService;
import com.example.week11.dao.AccountDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Slf4j
@Service("accountService")
public class AccountServiceImpl extends ServiceImpl<AccountDao, AccountEntity> implements AccountService {

    @Autowired
    RedisLock redisLock;

    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    @Autowired
    RedisSemaphore redisSemaphore;

    String KeyAccountList = "Account.AllList";

    String KeyAccoutById = "Account.id:";

    @Override
    public void queryPage(Map<String, Object> params) {
//        IPage<AccountEntity> page = this.page(
//                new Query<AccountEntity>().getPage(params),
//                new QueryWrapper<AccountEntity>()
//        );
//
//        return new PageUtils(page);
    }

    @Override
    public List<AccountEntity> getList() {

        // 加锁
        if (redisLock.lock(30) == false)
        {
            log.info("get lock failed.");
            return null;
        }
        // 缓存中获取数据

        ListOperations<Object ,Object> opt = redisTemplate.opsForList();
        List<Object> list = opt.range(KeyAccountList,0, -1);

        log.info("list-object， {}",list.toString());

        if (list != null && list.size() > 0)
        {
            return (List<AccountEntity>) list.get(list.size()-1);
        }

        // 数据库中获取数据
        List<AccountEntity > result  = baseMapper.selectList(new QueryWrapper<>());

        // 将数据设置到缓存中
        redisTemplate.opsForList().leftPush(KeyAccountList,result);
        redisTemplate.opsForList().getOperations().expire(KeyAccountList, 30, TimeUnit.MINUTES);

//        try {
//            Thread.sleep(100000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        redisLock.unlock();
        return result;
    }

    @Override
    public AccountEntity getAccountById(Integer id) {

        redisLock.lock(30);
//        redisLock.lock(100);


        AccountEntity entity = (AccountEntity)redisTemplate.opsForValue().get(KeyAccoutById + id.toString());

        if (entity != null)
        {
            return entity;
        }
        entity =baseMapper.selectById(id);

        redisTemplate.opsForValue().set(KeyAccoutById + id.toString(), entity);

        redisLock.unlock();
        return entity;
    }

    @Override
    public AccountEntity addNew(AccountEntity accountEntity) {


        return null;
    }

    @Override
    public boolean createSemephore(int amount) {

        return redisSemaphore.createSemaphore("wareAmount.order", amount,300);

    }


    @Override
    public boolean getSemephore() {

        return redisSemaphore.getSemaphore();

    }


}