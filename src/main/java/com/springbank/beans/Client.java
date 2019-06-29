package com.springbank.beans;

import java.sql.Date;
import java.sql.Timestamp;

import com.springbank.beans.Account;

public class Client extends Account {
    Timestamp accInitDate;
    public Client(String id, String firstName, String lastName, Date dob, Timestamp accInitDate, String type) {
        super(id, firstName, lastName, dob, type);
        this.accInitDate = accInitDate;
    }
    
    public Timestamp getAccInitdate() {
        return accInitDate;
    }

    public void setAccInitdate(Timestamp accinitdate) {
        this.accInitDate = accinitdate;
    }
    
}