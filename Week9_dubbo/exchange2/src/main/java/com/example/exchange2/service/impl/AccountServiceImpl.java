package com.example.exchange2.service.impl;

import com.example.exchange.service.RmbAccountService;
import org.springframework.stereotype.Service;
import java.util.Map;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import com.example.common.utils.PageUtils;
//import com.example.common.utils.Query;

import com.example.exchange2.dao.AccountDao;
import com.example.exchange.entity.AccountEntity;



@Service("accountService")
public class AccountServiceImpl extends ServiceImpl<AccountDao, AccountEntity> implements RmbAccountService {

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
    public AccountEntity transRmb(Integer fromId, Integer toId, Double rmbAmouint) {
        return null;
    }

    @Override
    public AccountEntity exceptRmb(Integer id, Double amount) {
        return null;
    }

}