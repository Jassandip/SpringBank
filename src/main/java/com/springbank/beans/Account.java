package com.springbank.beans;

import java.sql.Date;


import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Account{
    
    @Id
    String id;
    String firstname;  
    String lastname; 
    Date dob;
    String type;
    
    
    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstName) {
        this.firstname = firstName;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastName) {
        this.lastname = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Account() {} // no parameter constructor so child classes can implement their own contructors
    public Account(String id, String firstName, String lastName, Date dob, String type) {
        this.firstname = firstName;
        this.lastname = lastName;
        this.dob = dob;
        this.type = type;
        this.id = id;
    }

	

}