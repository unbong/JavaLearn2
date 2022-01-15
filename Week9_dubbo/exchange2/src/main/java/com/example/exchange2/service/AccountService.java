package com.example.exchange2.service;

//import com.baomidou.mybatisplus.extension.service.IService;
//import com.example.common.utils.PageUtils;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.exchange2.entity.AccountEntity;

import java.util.Map;

/**
 * 
 *
 * @author unbong
 * @email unbong@gmail.com
 * @date 2022-01-10 10:34:48
 */
public interface AccountService extends IService<AccountEntity> {

    void queryPage(Map<String, Object> params);
}

