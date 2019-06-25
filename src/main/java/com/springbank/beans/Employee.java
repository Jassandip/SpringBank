package com.springbank.beans;

import java.sql.Date;
import java.sql.Timestamp;

import com.springbank.beans.Account;

public class Employee extends Account {
    Timestamp accInitDate;
    public Employee(String id, String firstName, String lastName, Date dob, Timestamp accInitDate, String type) {
        super(id, firstName, lastName, dob, type);
        this.accInitDate = accInitDate;
        // TODO Auto-generated constructor stub
    }
    public Timestamp getAccInitdate() {
        return accInitDate;
    }

    public void setAccInitdate(Timestamp accinitdate) {
        this.accInitDate = accinitdate;
    }
    
}