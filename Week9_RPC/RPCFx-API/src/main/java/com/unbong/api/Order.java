package com.unbong.api;

import lombok.Data;

@Data
public class Order {

    private long orderId;
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
