package com.bankapp.onlinebanking.controller;

import com.bankapp.onlinebanking.entity.Account;
import com.bankapp.onlinebanking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/register")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        if (account.getAccountHolderName() == null || account.getAccountHolderName().isEmpty()) {
            return ResponseEntity.status(400).body(null);
        }
        if (accountService.accountExists(account.getAccountHolderName())) {
            return ResponseEntity.status(409).body(null);
        }
        Account saveAccount = accountService.createAccount(account);
        return new ResponseEntity<>(saveAccount, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = accountService.getAllAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id) {
        Account account = accountService.getAccountById(id);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @PostMapping("/{id}/deposit")
    public ResponseEntity<Account> depositAmount(@PathVariable Long id, @RequestBody Map<String, Object> payload) {
        // double amount = (double) payload.get("amount");
        double amount = Double.parseDouble(payload.get("amount").toString());
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than zero");
        }
        Account updatedAccount = accountService.depositAmount(id, amount);
        return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
    }

    @PostMapping("/{id}/withdraw")
    public ResponseEntity<Account> withdrawAmount(@PathVariable Long id,
            @RequestBody Map<String, Object> payload) {
        // double amount = (double) payload.get("amount");
        double amount = Double.parseDouble(payload.get("amount").toString());
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdraw amount must be greater than zero");
        }
        Account updatedAccount = accountService.withdrawAmount(id, amount);
        return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
    }

}