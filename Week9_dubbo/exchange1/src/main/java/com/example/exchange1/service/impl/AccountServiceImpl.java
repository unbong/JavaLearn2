package com.example.exchange1.service.impl;

import com.example.exchange.service.RmbAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import com.example.common.utils.PageUtils;
//import com.example.common.utils.Query;

import com.example.exchange1.dao.AccountDao;
import com.example.exchange.entity.AccountEntity;
import com.example.exchange.service.DollarAccountService;


@com.alibaba.dubbo.config.annotation.Service // 暴露服务
@Service("accountService")
public class AccountServiceImpl extends ServiceImpl<AccountDao, AccountEntity> implements DollarAccountService {

//    @Autowired
//
//    RmbAccountService rmbAccountService;

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
    public AccountEntity transDollar(Integer fromId, Integer toId, Double dollarAmount) {

        boolean bol =  baseMapper.transDollar(fromId, dollarAmount);


        return null;

    }

    @Override
    public AccountEntity exceptDollar(Integer id, Double amount) {
        return null;
    }

}