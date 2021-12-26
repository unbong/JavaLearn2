package com.example.week8.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import com.example.common.utils.PageUtils;
//import com.example.common.utils.Query;

import com.example.week8.dao.ProductDao;
import com.example.week8.entity.ProductEntity;
import com.example.week8.service.ProductService;


@Service("productService")
public class ProductServiceImpl extends ServiceImpl<ProductDao, ProductEntity> implements ProductService {

//    @Override
//    public PageUtils queryPage(Map<String, Object> params) {
//        IPage<ProductEntity> page = this.page(
//                new Query<ProductEntity>().getPage(params),
//                new QueryWrapper<ProductEntity>()
//        );
//
//        return new PageUtils(page);
//    }

}