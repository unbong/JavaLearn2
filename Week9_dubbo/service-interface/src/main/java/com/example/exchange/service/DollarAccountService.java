package com.example.exchange.service;

//import com.baomidou.mybatisplus.extension.service.IService;
//import com.example.common.utils.PageUtils;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.exchange.entity.AccountEntity;

import java.util.Map;

/**
 * 
 *
 * @author unbong
 * @email unbong@gmail.com
 * @date 2022-01-10 10:34:48
 */
public interface DollarAccountService extends IService<AccountEntity> {

    void queryPage(Map<String, Object> params);

    AccountEntity transDollar(Integer fromId, Integer toId, Double dollarAmount);

    AccountEntity exceptDollar(Integer id, Double amount);
}

