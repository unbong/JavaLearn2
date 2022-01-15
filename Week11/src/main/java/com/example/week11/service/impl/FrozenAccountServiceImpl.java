package com.example.week11.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.week11.dao.FrozenAccountDao;
import com.example.week11.entity.FrozenAccountEntity;
import com.example.week11.service.FrozenAccountService;
import org.springframework.stereotype.Service;

import java.util.Map;


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