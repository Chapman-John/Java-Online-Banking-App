package com.bankapp.onlinebanking.service.impl;

import com.bankapp.onlinebanking.service.AccountService;
import com.bankapp.onlinebanking.dto.AccountDto;
import com.bankapp.onlinebanking.mapper.AccountMapper;
import com.bankapp.onlinebanking.repository.AccountRepository;
import org.springframework.stereotype.Service;
import com.bankapp.onlinebanking.entity.Account;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Component;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account saveAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(saveAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
        accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
        // return AccountMapper.mapToAccountDto(account);
        return null;

}
