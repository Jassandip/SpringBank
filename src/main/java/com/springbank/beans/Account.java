package com.springbank.beans;

import java.sql.Date;

// import java.util.Date;

public class Account{
    String id;
    String firstName;  
    String lastName; 
    Date dob;
    String type;
    
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public Account(String id, String firstName, String lastName, Date dob, String type) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.type = type;
        this.id = id;
    }


	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}