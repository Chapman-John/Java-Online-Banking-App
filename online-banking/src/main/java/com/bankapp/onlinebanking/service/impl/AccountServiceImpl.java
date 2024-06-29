package com.bankapp.onlinebanking.service.impl;

import com.bankapp.onlinebanking.service.AccountService;
import com.bankapp.onlinebanking.dto.AccountDto;
import com.bankapp.onlinebanking.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        return null;
    }

}
