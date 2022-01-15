package com.example.week11.service;

//import com.baomidou.mybatisplus.extension.service.IService;
//import com.example.common.utils.PageUtils;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.week11.entity.AccountEntity;

import java.util.List;
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

    List<AccountEntity> getList();

    AccountEntity getAccountById(Integer id);

    AccountEntity addNew(AccountEntity accountEntity);

    boolean createSemephore(int amount);

    boolean getSemephore();

}

