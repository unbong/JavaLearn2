package com.example.exchange1.service;

import com.baomidou.mybatisplus.extension.service.IService;
//import com.example.common.utils.PageUtils;
import com.example.exchange1.entity.FrozenAccountEntity;

import java.util.Map;

/**
 * 
 *
 * @author unbong
 * @email unbong@gmail.com
 * @date 2022-01-10 10:34:08
 */
public interface FrozenAccountService extends IService<FrozenAccountEntity> {

    void queryPage(Map<String, Object> params);
}

