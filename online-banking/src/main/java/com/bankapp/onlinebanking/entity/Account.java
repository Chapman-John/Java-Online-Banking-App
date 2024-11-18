package com.bankapp.onlinebanking.entity;

import jakarta.persistence.*;
// import lombok.Getter;
// import lombok.Setter;
// import lombok.AllArgsConstructor;
// import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;

// @Getter
// @Setter
// @AllArgsConstructor
// @NoArgsConstructor
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // @Getter
    // @Setter
    private Long id;

    // @Column(name = "account_holder_name", nullable = false, length = 100)
    // @Getter
    // @Setter
    @NotBlank
    private String accountHolderName;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    // @Column(nullable = false)
    // @Getter
    // @Setter
    private double balance = 0.0;

    public Account() {
    }

    public Account(String accountHolderName, double balance) {
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountHolderName() {
        return this.accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}
