package com.deriska.psydtrader.controller;

import com.deriska.psydtrader.entity.Account;
import com.deriska.psydtrader.entity.StandardResponse;
import com.deriska.psydtrader.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/createaccount")
    public ResponseEntity<StandardResponse> createAccount(@RequestBody Account account){
        return accountService.createNewAccount(account);
    }
}
