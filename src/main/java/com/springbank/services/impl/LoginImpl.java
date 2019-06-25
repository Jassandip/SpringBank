package com.springbank.services.impl;

import com.springbank.services.LoginServices;

import org.springframework.web.bind.annotation.SessionAttributes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.springbank.beans.Account;
import com.springbank.beans.Client;
import com.springbank.beans.Employee;
import com.springbank.dao.impl.MySqlDao;

@SessionAttributes("test")
public class LoginImpl implements LoginServices {

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

    public static Account authorize(String[] idAndPass) throws SQLException {
        System.out.println("Entered asimpl login");
        Connection conn = null;
        Account user;
        try {
            conn = MySqlDao.getConnection();
            PreparedStatement ps;
            ps = conn.prepareStatement("Select * from loggin where id = ? and password = ?;");
            ps.setString(1, idAndPass[0]);
            ps.setString(2, idAndPass[1]);
            ResultSet rs = ps.executeQuery();
            rs.next();
            String type = rs.getString("type");
            conn.close();
            if (type.equals("employee")) {
                user = employeeLoader(idAndPass[0]);
            } else {
                user = clientLoader(idAndPass[0]);
            }
            return user;
        }

        // worked up to this part
        catch (SQLException e) {
            System.err.println(e);
            user = dummy();
            return user;
        }
    }

    public static Employee employeeLoader(String id) throws SQLException {
        System.out.println("Entered asimpl login");
        Connection conn = null;
        Employee user;
        try {
            conn = MySqlDao.getConnection();
            PreparedStatement ps;
            ps = conn.prepareStatement("Select * from employee where id = ?;");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            user = new Employee(rs.getString("id"), rs.getString("firstname"), rs.getString("lastname"),
                    rs.getDate("dob"), rs.getTimestamp("accinitdate"), "employee");
            conn.close();
            return user;

        }
        // worked up to this part
        catch (SQLException e) {
            System.err.println(e);
            // dummy user incase loggin fails
            user = new Employee("id", "firstname", "lastname", new Date(01 / 01 / 2001),
                    new Timestamp(System.currentTimeMillis()), "employee");
            return user;
        }

    }

    public static Client clientLoader(String id) throws SQLException {
        System.out.println("Entered asimpl clientloader");
        Connection conn = null;
        Client user;
        try {
            conn = MySqlDao.getConnection();
            PreparedStatement ps;
            ps = conn.prepareStatement("Select * from clients where id = ?;");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            user = new Client(rs.getString("id"), rs.getString("firstname"), rs.getString("lastname"),
                    rs.getDate("dob"), rs.getTimestamp("accinitdate"), "client");
            conn.close();
            return user;

        }
        catch (SQLException e) {
            System.err.println(e);
            // dummy user incase loggin fails
            user = new Client("id", "firstname", "lastname", new Date(01 / 01 / 2001),
                    new Timestamp(System.currentTimeMillis()), "client");
            return user;
        }

    }
    public static Account dummy(){
        Account user = new Client("id", "firstname", "lastname", new Date(01 / 01 / 2001),
                    new Timestamp(System.currentTimeMillis()), "client");
        return user;
    }

}