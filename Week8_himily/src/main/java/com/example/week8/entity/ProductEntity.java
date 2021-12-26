package com.example.week8.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author unbong
 * @email unbong@gmail.com
 * @date 2021-12-25 17:26:50
 */
@Data
@TableName("product")
public class ProductEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 商品ID
	 */
	@TableId
	private Integer productId;
	/**
	 * 商品名
	 */
	private String productName;
	/**
	 * 商品图片路径
	 */
	private String productImgPath;
	/**
	 * 商品信息
	 */
	private String productInformation;
	/**
	 * 商品单位
	 */
	private String productUnitName;
	/**
	 * 品牌名称，
	 */
	private String productBrandName;
	/**
	 * 创建时间
	 */
	private Date createTimestamp;
	/**
	 * 更新时间
	 */
	private Date updateTimestamp;

}
