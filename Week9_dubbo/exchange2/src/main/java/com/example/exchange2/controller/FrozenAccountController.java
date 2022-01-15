package com.example.exchange2.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.exchange2.entity.FrozenAccountEntity;
import com.example.exchange2.service.FrozenAccountService;
//import com.example.common.utils.PageUtils;
//import com.example.common.utils.R;



/**
 * 
 *
 * @author unbong
 * @email unbong@gmail.com
 * @date 2022-01-10 10:34:48
 */
@RestController
@RequestMapping("exchange2/frozenaccount")
public class FrozenAccountController {
    @Autowired
    private FrozenAccountService frozenAccountService;

//    /**
//     * 列表
//     */
//    @RequestMapping("/list")
//    @RequiresPermissions("exchange2:frozenaccount:list")
//    public R list(@RequestParam Map<String, Object> params){
//        PageUtils page = frozenAccountService.queryPage(params);
//
//        return R.ok().put("page", page);
//    }
//
//
//    /**
//     * 信息
//     */
//    @RequestMapping("/info/{id}")
//    @RequiresPermissions("exchange2:frozenaccount:info")
//    public R info(@PathVariable("id") Integer id){
//		FrozenAccountEntity frozenAccount = frozenAccountService.getById(id);
//
//        return R.ok().put("frozenAccount", frozenAccount);
//    }
//
//    /**
//     * 保存
//     */
//    @RequestMapping("/save")
//    @RequiresPermissions("exchange2:frozenaccount:save")
//    public R save(@RequestBody FrozenAccountEntity frozenAccount){
//		frozenAccountService.save(frozenAccount);
//
//        return R.ok();
//    }
//
//    /**
//     * 修改
//     */
//    @RequestMapping("/update")
//    @RequiresPermissions("exchange2:frozenaccount:update")
//    public R update(@RequestBody FrozenAccountEntity frozenAccount){
//		frozenAccountService.updateById(frozenAccount);
//
//        return R.ok();
//    }
//
//    /**
//     * 删除
//     */
//    @RequestMapping("/delete")
//    @RequiresPermissions("exchange2:frozenaccount:delete")
//    public R delete(@RequestBody Integer[] ids){
//		frozenAccountService.removeByIds(Arrays.asList(ids));
//
//        return R.ok();
//    }

}
