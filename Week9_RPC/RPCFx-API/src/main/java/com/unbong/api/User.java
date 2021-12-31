package com.unbong.api;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private int userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 邮箱
     */
    private String mail;
    /**
     * 手机号
     */
    private String phoneNumber;
    /**
     * 用户地址
     */
    private String userAddress;
    /**
     * 创建时间
     */
    private Date createTimestamp;
    /**
     * 更新时间
     */
    private Date updateTimestamp;
}
