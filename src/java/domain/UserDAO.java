/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBConnectionPool;

public class UserDAO {

    private DBConnectionPool connPool;
    private static final String RETRIEVE_STMT
            = "SELECT * FROM shoppingUser WHERE UserType=? AND UserID=? AND Password =?";
    private static final String GETID_STMT = "SELECT COUNT(UserID) FROM shoppinguser";
    private static final String CREATE_STMT = "INSERT INTO shoppingUser VALUES(?,?,?,?,?,?)";

    User userRetrieve(String usertype, String userID, String password) throws SQLException {
        User user = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        int rows = 0;
        try {
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(RETRIEVE_STMT);
            stmt.setString(1, usertype);
            stmt.setString(2, userID);
            stmt.setString(3, password);
            rset = stmt.executeQuery();
            
            //데이터 베이스에서 유저 데이터 가져오기
            while (rset.next()) {
                String UserID = rset.getString("UserID");
                String UserType = rset.getString("UserType");
                String UserName = rset.getString("UserName");
                String Password = rset.getString("Password");
                String PhoneNum = rset.getString("PhoneNum");
                String Address = rset.getString("Address");
                rows++;
                if (rows > 1) {
                    throw new SQLException("Too many rows were returned.");
                }
                user = new User(UserID, UserType, UserName, Password, PhoneNum, Address);
            }
            return user;
        } catch (SQLException se) {
            throw new RuntimeException(
                    "A database error occurred. " + se.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Exception: " + e.getMessage());
        } finally {
            if (rset != null) {
                try {
                    rset.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        }
    }
 
    void userCreate(String userID, String usertype, String username, String password, String phoneNum, String address) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try {
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(GETID_STMT);
            rset = stmt.executeQuery();
            rset.next();
            stmt = conn.prepareStatement(CREATE_STMT);
            stmt.setString(1, userID);
            stmt.setString(2, usertype);
            stmt.setString(3, username);
            stmt.setString(4, password);
            stmt.setString(5, phoneNum);
            stmt.setString(6, address);
            stmt.executeQuery();
        } catch (SQLException se) {
            throw new RuntimeException(
                    "A database error occurred. " + se.getMessage());
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        }
    }
}
