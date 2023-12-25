package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Account;
import com.example.repository.AccountRepository;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    
    public Account create(Account account) {
    	account.setAmount(0);
    	return this.accountRepository.save(account);
    }
    
    public Account findById(Integer id) {
    	Optional<Account> optionalAccount = this.accountRepository.findById(id);
    	Account account = optionalAccount.get();
    	return account;
    }
    
    public Account update(Integer id, Integer deposit) {
    	Account account = this.findById(id);
    	account.setAmount(account.getAmount() + deposit);
    	return this.accountRepository.save(account);
    }
}