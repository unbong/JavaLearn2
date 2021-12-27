package com.example.week8.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.week8.entity.OrderEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * 
 * @author unbong
 * @email unbong@gmail.com
 * @date 2021-12-25 17:26:50
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
    
    
    
    /**
     * 查询分支事务try是否已执行
     * @param localTradeNo 本地事务编号
     * @return
     */
    int isExist(@Param("txNo") String localTradeNo);

    /**
     * 查询分支事务confirm是否已执行
     * @param localTradeNo 本地事务编号
     * @return
     */
    int isExistConfirm(@Param("txNo") String localTradeNo);

    /**
     * 查询分支事务cancel是否已执行
     * @param localTradeNo 本地事务编号
     * @return
     */
    int isExistCancel(@Param("txNo") String localTradeNo);

//    void update_(OrderEntity order);

    void update_(@Param("orderId")Long orderId, @Param("amount") Long amount);

    void addTry(@Param("txNo") String transId);

    void addCancel(@Param("txNo")String transId);
}
