package com.example.exchange1.dao;

import com.example.exchange.entity.AccountEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * 
 * @author unbong
 * @email unbong@gmail.com
 * @date 2022-01-10 10:34:08
 */
@Mapper
public interface AccountDao extends BaseMapper<AccountEntity> {

    boolean transDollar(@Param("id") Integer id, @Param("dollarAmount") Double dollarAmount);
}
