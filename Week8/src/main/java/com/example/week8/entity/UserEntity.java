package com.example.week8.entity;

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
 * @date 2021-12-25 17:26:50
 */
@Data
@TableName("user")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 */
	@TableId
	private Integer userId;
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
