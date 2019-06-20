package com.springbank.beans;

import java.sql.Date;

import com.springbank.beans.Account;

public class Client extends Account {
    float balance;
    public Client(String firstname, String lastname, Date dateofbirth, Date initdate, int accountId, String type, int balance) {
        super(firstname, lastname, dateofbirth, initdate, accountId, type);
        this.balance = balance;
    }

    
}