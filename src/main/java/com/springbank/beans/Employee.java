package com.springbank.beans;

import java.sql.Date;

import com.springbank.beans.Account;

public class Employee extends Account {

    public Employee(String firstname, String lastname, Date dateofbirth, Date initdate, int accountId, String type) {
        super(firstname, lastname, dateofbirth, initdate, accountId, type);

    }

    
}