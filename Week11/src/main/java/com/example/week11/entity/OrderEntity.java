package com.example.week11.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author unbong
 * @email unbong@gmail.com
 * @date 2022-01-12 21:57:44
 */
@Data
@TableName(value = "order", schema = "shop")
public class OrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 订单号
	 */
	@TableId
	private Integer orderId;
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
