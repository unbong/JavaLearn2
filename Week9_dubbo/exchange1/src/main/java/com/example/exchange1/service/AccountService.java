package com.example.exchange1.service;

import com.baomidou.mybatisplus.extension.service.IService;
//import com.example.common.utils.PageUtils;
import com.example.exchange1.entity.AccountEntity;

import java.util.Map;

/**
 * 
 *
 * @author unbong
 * @email unbong@gmail.com
 * @date 2022-01-10 10:34:08
 */
public interface AccountService extends IService<AccountEntity> {

    void queryPage(Map<String, Object> params);

    AccountEntity transDollar(Integer fromId, Integer toId, Double dollarAmount);
}

