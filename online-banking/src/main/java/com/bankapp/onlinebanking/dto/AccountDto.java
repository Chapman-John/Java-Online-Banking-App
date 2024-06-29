package com.bankapp.onlinebanking.dto;

// import lombok.AllArgsConstructor;
// import lombok.Getter;
import lombok.Data;

@Data
public class AccountDto {
    private Long id;
    private String accountHolderName;
    private double balance;
}
