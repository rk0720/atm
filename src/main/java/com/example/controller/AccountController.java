package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Account;
import com.example.resource.ResponseAmount;
import com.example.service.AccountService;

@RestController
@RequestMapping(value = "/bankTrading", produces="application/json;charset=UTF-8")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    
    @PostMapping("open")
    public Account open() {
    	Account account = new Account();
    	return this.accountService.create(account);
    }
    
    @GetMapping("{account_id}")
    public ResponseAmount getAmount(@PathVariable("account_id") Integer accountId) {
    	Account account = this.accountService.findById(accountId);
    	ResponseAmount responseAmount = new ResponseAmount();
    	responseAmount.setAmount(account.getAmount());
    	return responseAmount;
    }
}