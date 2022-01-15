package com.example.exchange1.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import com.example.common.utils.PageUtils;
//import com.example.common.utils.Query;

import com.example.exchange1.dao.FrozenAccountDao;
import com.example.exchange1.entity.FrozenAccountEntity;
import com.example.exchange1.service.FrozenAccountService;


@Service("frozenAccountService")
public class FrozenAccountServiceImpl extends ServiceImpl<FrozenAccountDao, FrozenAccountEntity> implements FrozenAccountService {

    @Override
    public void queryPage(Map<String, Object> params) {
//        IPage<FrozenAccountEntity> page = this.page(
//                new Query<FrozenAccountEntity>().getPage(params),
//                new QueryWrapper<FrozenAccountEntity>()
//        );
//
//        return new PageUtils(page);
    }

}