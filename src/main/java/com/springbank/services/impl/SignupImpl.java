package com.springbank.services.impl;

import com.springbank.services.Signup;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.springbank.dao.impl.MySqlDao;
import com.springbank.beans.Account;
import com.springbank.beans.Login;

public class SignupImpl implements Signup {

    public boolean Account(Account account) {
        System.out.println("made it to imple account");
        boolean status = false;
        Connection conn = MySqlDao.getConnection();
        PreparedStatement ps;
        try{
        if (account.getType().equals("Employee")){
            ps = conn.prepareStatement("Insert into employees (firstname,lastname,dob,accinitdate) Values (?,?,?,?);");
        }
        else {
            ps = conn.prepareStatement("Insert into clients (firstname,lastname,dob,accinitdate) Values (?,?,?,?);");
        }
        ps.setString(1,account.getFirstName());
        ps.setString(2,account.getLastName());
        ps.setDate(3,account.getDob());
        ps.setTimestamp(4,new Timestamp(System.currentTimeMillis()));
        if(!ps.execute()){
            status = true;}
        ps.close();
        
        }
        catch (SQLException e) {
			e.printStackTrace();
        }
        return status;

    
}
public boolean Login(Login login) {
    System.out.println("made it to impl login");
    boolean status = false;
    Connection conn = MySqlDao.getConnection();
    PreparedStatement ps;
    try{
    ps = conn.prepareStatement(
        "Insert into loggin (id,password,type) Values (?,?,?);");
    ps.setString(1,login.getId());
    ps.setString(2,login.getPassword());
    ps.setString(3,login.getType());
    if(!ps.execute()){
    status = true;}
    ps.close();
    }
    catch (SQLException e) {
        e.printStackTrace();
    }
    return status;

}
}
