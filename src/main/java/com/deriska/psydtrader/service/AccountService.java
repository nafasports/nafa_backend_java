package com.deriska.psydtrader.service;

import com.deriska.psydtrader.entity.Account;
import com.deriska.psydtrader.entity.StandardResponse;
import com.deriska.psydtrader.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepo;

    public ResponseEntity<StandardResponse> createNewAccount(Account account) {
        try {

            Account accountSaved = accountRepo.save(account);
            System.out.println("I got here");
            return StandardResponse.sendHttpResponse(true, "Operation was successful", accountSaved, "200");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return StandardResponse.sendHttpResponse(false, "Operation was not successful");
        }
    }
}
