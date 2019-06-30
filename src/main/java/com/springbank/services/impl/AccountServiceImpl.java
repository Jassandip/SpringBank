package com.springbank.services.impl;

import com.springbank.services.AccountServices;

import org.springframework.web.bind.annotation.SessionAttributes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.springbank.dao.impl.MySqlDao;
@SessionAttributes("test")
public class AccountServiceImpl implements AccountServices {

    public static boolean authenticate(String[] idAndPass) throws SQLException {
        System.out.println("Entered asimpl");
        boolean authenticate = false;
        Connection conn = null;
        try {
            conn = MySqlDao.getConnection();
            PreparedStatement ps;
            ps = conn.prepareStatement("Select * from loggin where id = ? and password = ?;");
            ps.setString(1, idAndPass[0]);
            ps.setString(2, idAndPass[1]);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println(rs.getString("type"));   
                authenticate = true;
            }
            // worked up to this part
        } catch (SQLException e) {
            System.err.println(e);
            authenticate = false;
        } 
            conn.close();
            return authenticate;
        
    }
    
    // public static Object login(String[] idAndPass) throws SQLException {
    //     System.out.println("Entered asimpl login");
    //     Connection conn = null;
    //     try {
    //         conn = MySqlDao.getConnection();
    //         PreparedStatement ps;
    //         ps = conn.prepareStatement("Select * from loggin where id = ? and password = ?;");
    //         ps.setString(1, idAndPass[0]);
    //         ps.setString(2, idAndPass[1]);
    //         ResultSet rs = ps.executeQuery();
    //         if (rs.next()) {
    //             System.out.println(rs.getString("type"));   
    //             authenticate = true;
    //         }
    //         // worked up to this part
    //     } catch (SQLException e) {
    //         System.err.println(e);
    //         authenticate = false;
    //     } 
    //         conn.close();
    //         return authenticate;
        
    // }


}