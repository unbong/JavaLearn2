package com.example.week8.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.week8.dao.ProductDao;
import com.example.week8.entity.ProductEntity;
import com.example.week8.service.ProductService;
import org.springframework.stereotype.Service;


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