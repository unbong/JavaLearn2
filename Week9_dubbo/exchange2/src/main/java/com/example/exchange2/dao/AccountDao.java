package com.example.exchange2.dao;

import com.example.exchange.entity.AccountEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author unbong
 * @email unbong@gmail.com
 * @date 2022-01-10 10:34:48
 */
@Mapper
public interface AccountDao extends BaseMapper<AccountEntity> {
	
}
