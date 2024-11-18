package com.bankapp.onlinebanking.service;

import com.bankapp.onlinebanking.entity.Account;
import com.bankapp.onlinebanking.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class AccountService {

    @Autowired
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(Account account) {
        if (accountRepository.findByUsername(account.getUsername()) != null) {
            throw new RuntimeException("Username already exists");
        }
        return accountRepository.save(account);
    }

    public Account login(String username, String password) {
        Account account = accountRepository.findByUsername(username);
        if (account == null || !account.getPassword().equals(password)) {
            throw new RuntimeException("Invalid username or password");
        }
        return account;
    }

    public Boolean accountExists(String account) {
        return accountRepository.findByAccountHolderName(account) != null;
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    public Account getBalance(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    public Account depositAmount(Long id, double amount) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        account.setBalance(account.getBalance() + amount);
        return accountRepository.save(account);
    }

    public Account withdrawAmount(Long id, double amount) {
        Account account = getAccountById(id);
        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient funds in account with ID: " + id);
        }
        account.setBalance(account.getBalance() - amount);
        return accountRepository.save(account);
    }

}
