package com.bankapp.onlinebanking.repository;
// package net.javaguides.banking.repository;

// import org.springframework.stereotype.Repository;
import com.bankapp.onlinebanking.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
