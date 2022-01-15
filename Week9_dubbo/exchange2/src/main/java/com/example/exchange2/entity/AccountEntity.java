package com.example.exchange2.entity;

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
 * @date 2022-01-10 10:34:48
 */
@Data
@TableName("account")
public class AccountEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private Double dollarAmount;
	/**
	 * 
	 */
	private Double rmbAmount;

}
