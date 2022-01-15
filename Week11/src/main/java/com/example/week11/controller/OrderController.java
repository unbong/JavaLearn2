package com.example.week11.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.week11.entity.OrderEntity;
import com.example.week11.service.OrderService;
//import com.example.common.utils.PageUtils;
//import com.example.common.utils.R;



/**
 * 
 *
 * @author unbong
 * @email unbong@gmail.com
 * @date 2022-01-12 21:57:44
 */
@RestController
@RequestMapping("week11/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
//
//    /**
//     * 列表
//     */
    @RequestMapping("/list")
    public List<OrderEntity> list(@RequestParam Map<String, Object> params){


        return orderService.queryPage(params);
    }
//
//
//    /**
//     * 信息
//     */
//    @RequestMapping("/info/{orderId}")
//    @RequiresPermissions("week11:order:info")
//    public R info(@PathVariable("orderId") Integer orderId){
//		OrderEntity order = orderService.getById(orderId);
//
//        return R.ok().put("order", order);
//    }
//
    /**
     * 保存
     */
    @RequestMapping("/save")

    public boolean save(@RequestBody OrderEntity order){

		orderService.addOrderWithPubSub(order);

        return true;
    }
//
//    /**
//     * 修改
//     */
//    @RequestMapping("/update")
//    @RequiresPermissions("week11:order:update")
//    public R update(@RequestBody OrderEntity order){
//		orderService.updateById(order);
//
//        return R.ok();
//    }
//
//    /**
//     * 删除
//     */
//    @RequestMapping("/delete")
//    @RequiresPermissions("week11:order:delete")
//    public R delete(@RequestBody Integer[] orderIds){
//		orderService.removeByIds(Arrays.asList(orderIds));
//
//        return R.ok();
//    }

}
