package com.bankapp.onlinebanking.repository;

import com.bankapp.onlinebanking.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    // Account findByAccountNumber(String accountNumber);
    // Account findByAccountHolderName(String accountHolderName);

}

// import org.springframework.data.repository.CrudRepository;

// import com.example.accessingdatamysql.User;

// // This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// // CRUD refers Create, Read, Update, Delete

// public interface UserRepository extends CrudRepository<User, Integer> {

// }