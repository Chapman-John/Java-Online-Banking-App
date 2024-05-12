package com.bankapp.onlinebanking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "accounts")
@Entity
public class Account {

    @Id
    private Long id;
    private String accountHolderName;
    private String balance;
}
