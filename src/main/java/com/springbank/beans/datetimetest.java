package com.springbank.beans;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class datetimetest {

    public static void main(String[] args) {
        
    
        // long millis=System.currentTimeMillis();
        // Date date = new Date();
        // SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
        // String currentDateTime = format.format(date);
        // System.out.println("The time is "+currentDateTime);

        Timestamp date = new Timestamp(System.currentTimeMillis());
        System.out.println("The time is " + date);

    }
}