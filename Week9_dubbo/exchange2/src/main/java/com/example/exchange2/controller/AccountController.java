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

import com.example.exchange2.entity.AccountEntity;
import com.example.exchange2.service.AccountService;
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
@RequestMapping("exchange2/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

//    /**
//     * 列表
//     */
//    @RequestMapping("/list")
//    @RequiresPermissions("exchange2:account:list")
//    public R list(@RequestParam Map<String, Object> params){
//        PageUtils page = accountService.queryPage(params);
//
//        return R.ok().put("page", page);
//    }
//
//
//    /**
//     * 信息
//     */
//    @RequestMapping("/info/{id}")
//    @RequiresPermissions("exchange2:account:info")
//    public R info(@PathVariable("id") Integer id){
//		AccountEntity account = accountService.getById(id);
//
//        return R.ok().put("account", account);
//    }
//
//    /**
//     * 保存
//     */
//    @RequestMapping("/save")
//    @RequiresPermissions("exchange2:account:save")
//    public R save(@RequestBody AccountEntity account){
//		accountService.save(account);
//
//        return R.ok();
//    }
//
//    /**
//     * 修改
//     */
//    @RequestMapping("/update")
//    @RequiresPermissions("exchange2:account:update")
//    public R update(@RequestBody AccountEntity account){
//		accountService.updateById(account);
//
//        return R.ok();
//    }
//
//    /**
//     * 删除
//     */
//    @RequestMapping("/delete")
//    @RequiresPermissions("exchange2:account:delete")
//    public R delete(@RequestBody Integer[] ids){
//		accountService.removeByIds(Arrays.asList(ids));
//
//        return R.ok();
//    }

}
