package com.springbank.beans;

import java.sql.Date;

// import java.util.Date;

public class Account{
    String firstName;  
    String lastName; 
    Date dob;
    Date initDate;  
    int accId;
    String type;
       
     

    public Account(String firstname, String lastname, Date dateofbirth, Date initdate, int accountId, String type){   
        this.firstName = firstname;  
        this.lastName = lastname;
        this.dob = dateofbirth;  
        this.type = type;
        
        this.initDate = initdate;
        this.accId = accountId;
        
    }  
    public void info(){
         System.out.println("Account: "+accId+" Firstname: "+firstName);
    }  
        
    // public static void main(String args[]){  
    //  Account obj1 = new Account("Jassandip","Shina",21413,"jassandips");  
    //  obj1.info();  

    // }  
}