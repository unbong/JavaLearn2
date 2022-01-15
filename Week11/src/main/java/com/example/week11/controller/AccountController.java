package com.example.week11.controller;

//import org.apache.shiro.authz.annotation.RequiresPermissions;

import com.example.week11.entity.AccountEntity;
import com.example.week11.service.AccountService;
import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//import com.example.common.utils.PageUtils;
//import com.example.common.utils.R;


/**
 * 
 *
 * @author unbong
 * @email unbong@gmail.com
 * @date 2022-01-10 10:34:48
 */
@Slf4j
@RestController
@RequestMapping("exchange2/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/getAll")
    public List<AccountEntity> getList(){
        return accountService.getList();
    }

    @GetMapping("/get/{id}")
    public AccountEntity getById(@PathVariable("id") Integer id)
    {
        return accountService.getAccountById(id);
    }


    @GetMapping("/get/semaphore")
    public boolean  getSemaphore(@RequestParam("create")   Boolean isCreate)
    {
        if (isCreate) {
            boolean  result =accountService.createSemephore(100);
            if(result == false)
            {
                log.info("create semaphore failed.");
                return false;
            }
        }

        return accountService.getSemephore();
    }

}
