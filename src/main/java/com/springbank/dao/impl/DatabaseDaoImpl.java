package com.springbank.dao.impl;

import com.springbank.dao.AccountDao;
import java.sql.*;
public class DatabaseDaoImpl implements AccountDao {

private static final String USERNAME = "root";
private static final String PASSWORD = "jassan69";
private static final String CONN_STRING = "jdbc:mysql://localhost:3306/Bank?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public static void databasedao(String[] args) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            System.out.println("Connected");
        }catch (SQLException e){
        System.err.println(e);
        } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
}

    public static Boolean authenticate(String[] args){
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            PreparedStatement ps = conn.prepareStatement("Select password from emp_li where id = ?;");
            ps.setString(1,args[0]);
            ResultSet rs = ps.executeQuery();
            rs.next();
            String pass = rs.getString("password");
            System.out.println(pass);
            if (pass.equals(args[1])){
                return true;
            }
            else {
            return false;
            }
        }catch (SQLException e){
        System.err.println(e);
        return false;
        } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return false;
            }
    }
}


// Statement st = con.createStatement();
// 			ResultSet rs = st.executeQuery("select * from employee where employeeId = "+1);
// 			while(rs.next()) {
// 				String empName = rs.getString("empname");
// 				String empId = rs.getString("empId");
// 			}
// 			PreparedStatement ps = con.prepareStatement("Select * from employee where employeeid = ? and salary = ?");
// 			ps.setString(0, "1");
// 			ps.setString(1, "1000");
// 			ps.executeQuery();
// 			ps.executeUpdate();
// 			st.executeUpdate("");
// 		} catch(SQLException ex) {
// 			ex.printStackTrace();
// 		}catch (ClassNotFoundException e) {
// 			// TODO Auto-generated catch block
// 			e.printStackTrace();
// 		}