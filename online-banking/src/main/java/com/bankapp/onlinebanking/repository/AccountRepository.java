package com.bankapp.onlinebanking.repository;
// package net.javaguides.banking.repository;

// import org.springframework.stereotype.Repository;
import com.bankapp.onlinebanking.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}

// import org.springframework.data.repository.CrudRepository;

// import com.example.accessingdatamysql.User;

// // This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// // CRUD refers Create, Read, Update, Delete

// public interface UserRepository extends CrudRepository<User, Integer> {

// }