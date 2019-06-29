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

public class LoginImpl implements LoginServices {

    public static String authenticate(String[] idAndPass) throws SQLException {
        System.out.println("Entered asimpl");
        Connection conn = null;
        String type = null;
        try {
            conn = MySqlDao.getConnection();
            PreparedStatement ps;
            ps = conn.prepareStatement("Select * from loggin where id = ? and password = ?;");
            ps.setString(1, idAndPass[0]);
            ps.setString(2, idAndPass[1]);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                type = rs.getString("type");
            }
            // worked up to this part
        } catch (SQLException e) {
            System.err.println(e);
        }
        conn.close();
        return type;

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

// package com.loanapp.dao.impl;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.jdbc.core.JdbcTemplate;
// import org.springframework.stereotype.Service;

// import com.loanapp.beans.LoginBean;
// import com.loanapp.dao.LoginDao;

// @Service
// public class LoginDaoImpl implements LoginDao{
	
// 	@Autowired
// 	JdbcTemplate jdbcTemplate;	

// 	@Override
// 	public boolean authenticateUser(LoginBean loginBean) {
// 		try {
// 		int result = jdbcTemplate.queryForObject(
// 			    "SELECT COUNT(*) FROM loan_app_users where user_login ='"+loginBean.getUsername()+"' and user_pass = '"+loginBean.getPassword()+"'", Integer.class);
// 		if(result > 0)
// 			return true;
// 		else
// 			return false;
// 		}catch(Exception ex) {
// 			ex.printStackTrace();
// 		}
// 		return false;
// 	}

// 	@Override
// 	public String authorize(LoginBean bean) {
// 		String result = "";
// 		try {
// 		result = jdbcTemplate.queryForObject(
// 			    "select user_role from loan_app_users where user_login='"+bean.getUsername()+"'", String.class);

// 		}catch(Exception ex) {
// 			ex.printStackTrace();
// 		}
// 		return result;
// 	}
	

// }
