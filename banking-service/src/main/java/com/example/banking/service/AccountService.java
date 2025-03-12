package com.example.banking.service;

import com.example.banking.model.Account;
import com.example.banking.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account) {
        log.info("Creating account for {}", account.getAccountHolderName());
        return accountRepository.save(account);
    }

    public Account getAccountByNumber(String accountNumber) {
        log.info("Fetching account for account number {}", accountNumber);
        return accountRepository.findByAccountNumber(accountNumber);
    }

    public Account deposit(String accountNumber, double amount) {
        log.info("Depositing {} to account {}", amount, accountNumber);
        Account acc = getAccountByNumber(accountNumber);
        acc.setBalance(acc.getBalance() + amount);
        return accountRepository.save(acc);
    }

    public Account withdraw(String accountNumber, double amount) {
        log.info("Withdrawing {} from account {}", amount, accountNumber);
        Account acc = getAccountByNumber(accountNumber);
        if (acc.getBalance() >= amount) {
            acc.setBalance(acc.getBalance() - amount);
            return accountRepository.save(acc);
        } else {
            log.error("Insufficient balance for withdrawal from account {}", accountNumber);
            throw new RuntimeException("Insufficient balance");
        }
    }
}
