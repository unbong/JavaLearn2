package com.example.exchange.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.exchange.entity.AccountEntity;

import java.util.Map;

public interface RmbAccountService  extends IService<AccountEntity> {

    public void queryPage(Map<String, Object> params) ;




    public AccountEntity transRmb(Integer fromId, Integer toId, Double rmbAmouint);


    public AccountEntity exceptRmb(Integer id, Double amount);

}
