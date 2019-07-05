package com.springbank.beans;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

import com.springbank.beans.Account;

@Entity
@Table(name="employees")
public class Employee extends Account {
    
    Timestamp accinitdate;
    @GeneratedValue(strategy=GenerationType.AUTO)
    Integer intid;

    public Employee() {}

    public Employee(String id, String firstname, String lastname, Date dob, Timestamp accinitdate, Integer intid) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.id = id;
        this.accinitdate = accinitdate;
        this.intid = intid;
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

}