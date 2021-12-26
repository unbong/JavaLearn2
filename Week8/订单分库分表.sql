
drop schema shop_1;
drop schema shop_0;
create schema shop_1;
create schema shop_0;


use shop_1;


CREATE TABLE `product` (
                           `product_id` INT NOT NULL comment '商品ID',
                           `product_name` VARCHAR(100) NULL comment '商品名',
                           `product_img_path` VARCHAR(100) NULL comment '商品图片路径',
                           `product_information` VARCHAR(1000) NULL comment '商品信息',
                           `product_unit_name` VARCHAR(45) NULL comment '商品单位',
                           `product_brand_name` VARCHAR(45) NULL comment '品牌名称，',
                           `create_timestamp` DATETIME NULL comment '创建时间',
                           `update_timestamp` DATETIME NULL comment '更新时间',
                           PRIMARY KEY (`product_id`))
    engine = InnoDB default CHARSET= utf8mb4;



CREATE TABLE `user` (
                        `user_id` INT NOT NULL              comment '用户ID',
                        `user_name` VARCHAR(45) NULL        comment '用户名',
                        `password` VARCHAR(45) NULL         comment '密码',
                        `mail` VARCHAR(45) NULL             comment '邮箱',
                        `phone_number` VARCHAR(45) NULL     comment '手机号',
                        `user_address` VARCHAR(45) NULL     comment '用户地址',
                        `create_timestamp` DATETIME NULL   comment '创建时间',
                        `update_timestamp` DATETIME NULL    comment '更新时间',
                        PRIMARY KEY (`user_id`))
    engine = InnoDB default CHARSET= utf8mb4;



CREATE TABLE `order_0` (
                           `order_id`   BIGINT(20)NOT NULL       comment '订单号',
                           `user_id` INT NULL            comment '用户ID',
                           `product_id` INT NULL         comment '产品ID',
                           `amount` BIGINT(10) NULL      comment '总金额',
                           `coupon` CHAR(10) NULL        comment '优惠券',
                           `quantity` INT NULL           comment '数量',
                           `create_timestamp` long NULL  comment '创建时间',
                           `update_timestamp` long NULL  comment '更新时间',
                           PRIMARY KEY (`order_id`))
    engine = InnoDB default CHARSET= utf8mb4;


CREATE TABLE `order_1` (
                           `order_id`   BIGINT(20)NOT NULL       comment '订单号',
                           `user_id` INT NULL            comment '用户ID',
                           `product_id` INT NULL         comment '产品ID',
                           `amount` BIGINT(10) NULL      comment '总金额',
                           `coupon` CHAR(10) NULL        comment '优惠券',
                           `quantity` INT NULL           comment '数量',
                           `create_timestamp` long NULL  comment '创建时间',
                           `update_timestamp` long NULL  comment '更新时间',
                           PRIMARY KEY (`order_id`))
    engine = InnoDB default CHARSET= utf8mb4;

CREATE TABLE `order_2` (
                           `order_id`   BIGINT(20)NOT NULL       comment '订单号',
                           `user_id` INT NULL            comment '用户ID',
                           `product_id` INT NULL         comment '产品ID',
                           `amount` BIGINT(10) NULL      comment '总金额',
                           `coupon` CHAR(10) NULL        comment '优惠券',
                           `quantity` INT NULL           comment '数量',
                           `create_timestamp` long NULL  comment '创建时间',
                           `update_timestamp` long NULL  comment '更新时间',
                           PRIMARY KEY (`order_id`))
    engine = InnoDB default CHARSET= utf8mb4;


CREATE TABLE `order_3` (
                           `order_id`   BIGINT(20)NOT NULL       comment '订单号',
                           `user_id` INT NULL            comment '用户ID',
                           `product_id` INT NULL         comment '产品ID',
                           `amount` BIGINT(10) NULL      comment '总金额',
                           `coupon` CHAR(10) NULL        comment '优惠券',
                           `quantity` INT NULL           comment '数量',
                           `create_timestamp` long NULL  comment '创建时间',
                           `update_timestamp` long NULL  comment '更新时间',
                           PRIMARY KEY (`order_id`))
    engine = InnoDB default CHARSET= utf8mb4;

CREATE TABLE `order_4` (
                           `order_id`   BIGINT(20)NOT NULL       comment '订单号',
                           `user_id` INT NULL            comment '用户ID',
                           `product_id` INT NULL         comment '产品ID',
                           `amount` BIGINT(10) NULL      comment '总金额',
                           `coupon` CHAR(10) NULL        comment '优惠券',
                           `quantity` INT NULL           comment '数量',
                           `create_timestamp` long NULL  comment '创建时间',
                           `update_timestamp` long NULL  comment '更新时间',
                           PRIMARY KEY (`order_id`))
    engine = InnoDB default CHARSET= utf8mb4;

CREATE TABLE `order_5` (
                           `order_id`   BIGINT(20)NOT NULL       comment '订单号',
                           `user_id` INT NULL            comment '用户ID',
                           `product_id` INT NULL         comment '产品ID',
                           `amount` BIGINT(10) NULL      comment '总金额',
                           `coupon` CHAR(10) NULL        comment '优惠券',
                           `quantity` INT NULL           comment '数量',
                           `create_timestamp` long NULL  comment '创建时间',
                           `update_timestamp` long NULL  comment '更新时间',
                           PRIMARY KEY (`order_id`))
    engine = InnoDB default CHARSET= utf8mb4;

CREATE TABLE `order_6` (
                           `order_id`   BIGINT(20)NOT NULL       comment '订单号',
                           `user_id` INT NULL            comment '用户ID',
                           `product_id` INT NULL         comment '产品ID',
                           `amount` BIGINT(10) NULL      comment '总金额',
                           `coupon` CHAR(10) NULL        comment '优惠券',
                           `quantity` INT NULL           comment '数量',
                           `create_timestamp` long NULL  comment '创建时间',
                           `update_timestamp` long NULL  comment '更新时间',
                           PRIMARY KEY (`order_id`))
    engine = InnoDB default CHARSET= utf8mb4;


CREATE TABLE `order_7` (
                           `order_id`   BIGINT(20)NOT NULL       comment '订单号',
                           `user_id` INT NULL            comment '用户ID',
                           `product_id` INT NULL         comment '产品ID',
                           `amount` BIGINT(10) NULL      comment '总金额',
                           `coupon` CHAR(10) NULL        comment '优惠券',
                           `quantity` INT NULL           comment '数量',
                           `create_timestamp` long NULL  comment '创建时间',
                           `update_timestamp` long NULL  comment '更新时间',
                           PRIMARY KEY (`order_id`))
    engine = InnoDB default CHARSET= utf8mb4;

CREATE TABLE `order_8` (
                           `order_id`   BIGINT(20)NOT NULL       comment '订单号',
                           `user_id` INT NULL            comment '用户ID',
                           `product_id` INT NULL         comment '产品ID',
                           `amount` BIGINT(10) NULL      comment '总金额',
                           `coupon` CHAR(10) NULL        comment '优惠券',
                           `quantity` INT NULL           comment '数量',
                           `create_timestamp` long NULL  comment '创建时间',
                           `update_timestamp` long NULL  comment '更新时间',
                           PRIMARY KEY (`order_id`))
    engine = InnoDB default CHARSET= utf8mb4;

CREATE TABLE `order_9` (
                           `order_id`   BIGINT(20)NOT NULL       comment '订单号',
                           `user_id` INT NULL            comment '用户ID',
                           `product_id` INT NULL         comment '产品ID',
                           `amount` BIGINT(10) NULL      comment '总金额',
                           `coupon` CHAR(10) NULL        comment '优惠券',
                           `quantity` INT NULL           comment '数量',
                           `create_timestamp` long NULL  comment '创建时间',
                           `update_timestamp` long NULL  comment '更新时间',
                           PRIMARY KEY (`order_id`))
    engine = InnoDB default CHARSET= utf8mb4;

CREATE TABLE `order_10` (
                            `order_id`   BIGINT(20)NOT NULL       comment '订单号',
                            `user_id` INT NULL            comment '用户ID',
                            `product_id` INT NULL         comment '产品ID',
                            `amount` BIGINT(10) NULL      comment '总金额',
                            `coupon` CHAR(10) NULL        comment '优惠券',
                            `quantity` INT NULL           comment '数量',
                            `create_timestamp` long NULL  comment '创建时间',
                            `update_timestamp` long NULL  comment '更新时间',
                            PRIMARY KEY (`order_id`))
    engine = InnoDB default CHARSET= utf8mb4;

CREATE TABLE `order_11` (
                            `order_id`   BIGINT(20)NOT NULL       comment '订单号',
                            `user_id` INT NULL            comment '用户ID',
                            `product_id` INT NULL         comment '产品ID',
                            `amount` BIGINT(10) NULL      comment '总金额',
                            `coupon` CHAR(10) NULL        comment '优惠券',
                            `quantity` INT NULL           comment '数量',
                            `create_timestamp` long NULL  comment '创建时间',
                            `update_timestamp` long NULL  comment '更新时间',
                            PRIMARY KEY (`order_id`))
    engine = InnoDB default CHARSET= utf8mb4;

CREATE TABLE `order_12` (
                            `order_id`   BIGINT(20)NOT NULL       comment '订单号',
                            `user_id` INT NULL            comment '用户ID',
                            `product_id` INT NULL         comment '产品ID',
                            `amount` BIGINT(10) NULL      comment '总金额',
                            `coupon` CHAR(10) NULL        comment '优惠券',
                            `quantity` INT NULL           comment '数量',
                            `create_timestamp` long NULL  comment '创建时间',
                            `update_timestamp` long NULL  comment '更新时间',
                            PRIMARY KEY (`order_id`))
    engine = InnoDB default CHARSET= utf8mb4;

CREATE TABLE `order_13` (
                            `order_id`   BIGINT(20)NOT NULL       comment '订单号',
                            `user_id` INT NULL            comment '用户ID',
                            `product_id` INT NULL         comment '产品ID',
                            `amount` BIGINT(10) NULL      comment '总金额',
                            `coupon` CHAR(10) NULL        comment '优惠券',
                            `quantity` INT NULL           comment '数量',
                            `create_timestamp` long NULL  comment '创建时间',
                            `update_timestamp` long NULL  comment '更新时间',
                            PRIMARY KEY (`order_id`))
    engine = InnoDB default CHARSET= utf8mb4;

CREATE TABLE `order_14` (
                            `order_id`   BIGINT(20)NOT NULL       comment '订单号',
                            `user_id` INT NULL            comment '用户ID',
                            `product_id` INT NULL         comment '产品ID',
                            `amount` BIGINT(10) NULL      comment '总金额',
                            `coupon` CHAR(10) NULL        comment '优惠券',
                            `quantity` INT NULL           comment '数量',
                            `create_timestamp` long NULL  comment '创建时间',
                            `update_timestamp` long NULL  comment '更新时间',
                            PRIMARY KEY (`order_id`))
    engine = InnoDB default CHARSET= utf8mb4;

CREATE TABLE `order_15` (
                            `order_id`   BIGINT(20)NOT NULL       comment '订单号',
                            `user_id` INT NULL            comment '用户ID',
                            `product_id` INT NULL         comment '产品ID',
                            `amount` BIGINT(10) NULL      comment '总金额',
                            `coupon` CHAR(10) NULL        comment '优惠券',
                            `quantity` INT NULL           comment '数量',
                            `create_timestamp` long NULL  comment '创建时间',
                            `update_timestamp` long NULL  comment '更新时间',
                            PRIMARY KEY (`order_id`))
    engine = InnoDB default CHARSET= utf8mb4;







