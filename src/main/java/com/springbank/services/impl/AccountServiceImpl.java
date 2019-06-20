package com.springbank.services.impl;

import com.springbank.services.AccountService;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.springbank.dao.impl.MySqlDao;

public class AccountServiceImpl implements AccountService {

    public static Boolean authenticate(String[] idAndPass) throws SQLException {
        System.out.println("Entered asimpl");
        Boolean authenticate = null;
        Connection conn = null;
        try {
        conn = MySqlDao.getConnection();
        PreparedStatement ps;
        ps = conn.prepareStatement("Select password from Bank.loggin where id = 'jashan';");
        // ps.setString(1,idAndPass[0]);
        ResultSet rs = ps.executeQuery();
        rs.next();
        System.out.println(rs.getString("password"));
        authenticate = true;
        }
        catch (SQLException e){
            System.err.println(e);
            authenticate = false;
        }
        finally {
            conn.close();
            return authenticate;
        }


    
}}