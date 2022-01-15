package com.example.week11.dao;

import com.example.week11.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author unbong
 * @email unbong@gmail.com
 * @date 2022-01-12 21:57:44
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
