package com.app.mybaetown.model;

import lombok.Data;

@Data
public class BankDetails {
    private String accountNumber;
   // private String bankName;
    private String ifscCode;
    private String accountHolderName;
}