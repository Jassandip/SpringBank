// package com.springbank.services.impl;

// import com.springbank.services.CreateAccount;
// import java.sql.Connection;
// import java.sql.Date;
// import java.sql.PreparedStatement;

// import com.springbank.dao.impl.MySqlDao;;

// public class CreateAccountImpl implements CreateAccount{

    
//     public static boolean CreateAccount(String[] args, Date dob){
//         Connection conn = MySqlDao.getConnection();
//         PreparedStatement ps;
//         if (args[3].equals("Employee")){
//             ps = conn.prepareStatement("Insert into employees (firstname,lastname,dob,type) Values (?,?,?,?);");
//         }
//         else {
//             ps = conn.prepareStatement("Insert into customers (firstname,lastname,dob,type) Values (?,?,?,?);");
//         }
//         // this.logginId = logginid; 5
//         // this.logginPass = logginpass; 6
//         ps.setString(1,args[0]);
//         ps.setString(2,args[1]);
//         ps.setDate(3,dob);
//         ps.setString(1,args[3]);
//         ps.executeQuery();

//         // this.accId = accountId;
//         // this.initDate = initdate;
    
// }
// public static void logginUpdate(){

// }
// }
