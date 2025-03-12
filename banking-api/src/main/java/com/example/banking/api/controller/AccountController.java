package com.example.banking.api.controller;

import com.example.banking.model.Account;
import com.example.banking.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
@Slf4j
public class AccountController {
    private final AccountService accountService;

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        log.info("API call: Create Account");
        return accountService.createAccount(account);
    }

    @GetMapping("/{accountNumber}")
    public Account getAccount(@PathVariable String accountNumber) {
        log.info("API call: Get Account Details for {}", accountNumber);
        return accountService.getAccountByNumber(accountNumber);
    }

    @PostMapping("/{accountNumber}/deposit")
    public Account deposit(@PathVariable String accountNumber, @RequestParam double amount) {
        log.info("API call: Deposit {} to {}", amount, accountNumber);
        return accountService.deposit(accountNumber, amount);
    }

    @PostMapping("/{accountNumber}/withdraw")
    public Account withdraw(@PathVariable String accountNumber, @RequestParam double amount) {
        log.info("API call: Withdraw {} from {}", amount, accountNumber);
        return accountService.withdraw(accountNumber, amount);
    }
}
