package com.example.week8.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import com.example.common.utils.PageUtils;
//import com.example.common.utils.Query;

import com.example.week8.dao.UserDao;
import com.example.week8.entity.UserEntity;
import com.example.week8.service.UserService;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

//    @Override
//    public PageUtils queryPage(Map<String, Object> params) {
//        IPage<UserEntity> page = this.page(
//                new Query<UserEntity>().getPage(params),
//                new QueryWrapper<UserEntity>()
//        );
//
//        return new PageUtils(page);
//    }

}