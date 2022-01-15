package com.example.exchange.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.exchange.entity.FrozenAccountEntity;

import java.util.Map;

/**
 * 
 *
 * @author unbong
 * @email unbong@gmail.com
 * @date 2022-01-10 10:34:48
 */
public interface FrozenAccountService extends IService<FrozenAccountEntity> {

    void queryPage(Map<String, Object> params);
}

