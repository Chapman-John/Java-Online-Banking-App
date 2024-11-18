package com.bankapp.onlinebanking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
// import lombok.AllArgsConstructor;
// import lombok.NoArgsConstructor;

// @Getter
// @Setter
// @AllArgsConstructor
// @NoArgsConstructor
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;

    // @Column(name = "account_holder_name", nullable = false, length = 100)
    @Getter
    @Setter
    private String accountHolderName;

    // @Column(nullable = false)
    // @Getter
    // @Setter
    private double balance = 0.0;
    // private double balance;

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}
