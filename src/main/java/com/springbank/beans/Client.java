package com.springbank.beans;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.springbank.beans.Account;

@Entity
@Table(name="clients")
public class Client extends Account {
    Timestamp accinitdate;
    BigDecimal balance;
    @GeneratedValue(strategy=GenerationType.AUTO)
    Integer intid;

    public Client() {}

    public Client(String id, String firstname, String lastname, Date dob, Timestamp accinitdate, Integer intid, BigDecimal balance) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.id = id;
        this.accinitdate = accinitdate;
        this.intid = intid;
        this.balance = balance;
        // TODO Auto-generated constructor stub
    }

    public Timestamp getAccInitDate() {
        return accinitdate;
    }

    public void setAccInitDate(Timestamp accInitDate) {
        this.accinitdate = accInitDate;
    }

    public Integer getIntId() {
        return intid;
    }

    public void setIntId(Integer intId) {
        this.intid = intId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

}