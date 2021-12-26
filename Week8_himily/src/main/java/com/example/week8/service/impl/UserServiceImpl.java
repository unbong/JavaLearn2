package com.example.week8.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.week8.dao.UserDao;
import com.example.week8.entity.UserEntity;
import com.example.week8.service.UserService;
import org.springframework.stereotype.Service;


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