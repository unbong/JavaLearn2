package com.example.week8.entity;



import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;


/**
 * 
 * 
 * @author unbong
 * @email unbong@gmail.com
 * @date 2021-12-25 17:26:50
 */
@Data
@TableName(value = "order")
public class OrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 订单号
	 */
	@TableId(value="order_id" , type = IdType.ID_WORKER)
	private Long orderId;
	/**
	 * 用户ID
	 */
	private Integer userId;
	/**
	 * 产品ID
	 */
	private Integer productId;
	/**
	 * 总金额
	 */
	private Long amount;
	/**
	 * 优惠券
	 */
	private String coupon;
	/**
	 * 数量
	 */
	private Integer quantity;
	/**
	 * 创建时间
	 */
	private String createTimestamp;
	/**
	 * 更新时间
	 */
	private String updateTimestamp;

}
