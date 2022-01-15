package com.example.exchange1.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.exchange1.entity.AccountEntity;
import com.example.exchange1.service.AccountService;
//import com.example.common.utils.PageUtils;
//import com.example.common.utils.R;



/**
 * 
 *
 * @author unbong
 * @email unbong@gmail.com
 * @date 2022-01-10 10:34:08
 */
@RestController
@RequestMapping("exchange1/account")
public class AccountController {
    @Autowired
    private AccountService accountService;



//    /**
//     * 列表
//     */
//    @RequestMapping("/list")
//
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
//    @RequiresPermissions("exchange1:account:info")
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
//    @RequiresPermissions("exchange1:account:save")
//    public R save(@RequestBody AccountEntity account){
//		accountService.save(account);
//
//        return R.ok();
//    }
//
//    /**
//     * 修改
//     */
    @RequestMapping("/transDollar")
//    @RequiresPermissions("exchange1:account:update")
    public String transDollar(@RequestParam Integer  toId, @RequestParam Integer fromId, @RequestParam Double dollarAmount){
		AccountEntity accountEntity  = accountService.transDollar(fromId, toId ,dollarAmount);

        return "";
    }
//
//    /**
//     * 删除
//     */
//    @RequestMapping("/delete")
//    @RequiresPermissions("exchange1:account:delete")
//    public R delete(@RequestBody Integer[] ids){
//		accountService.removeByIds(Arrays.asList(ids));
//
//        return R.ok();
//    }

}
