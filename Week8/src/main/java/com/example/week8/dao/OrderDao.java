package com.example.week8.dao;

import com.example.week8.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author unbong
 * @email unbong@gmail.com
 * @date 2021-12-25 17:26:50
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
