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
import java.util.ArrayList;

import util.DBConnectionPool;

public class UserDAO {

    private DBConnectionPool connPool;
    private static final String CREATE_STMT = "INSERT INTO shoppingUser VALUES(?,?,?,?,?,?)";

    private static final String RETRIEVE_STMT
            = "SELECT * FROM shoppingUser WHERE UserType=? AND UserID=? AND Password =?";
    private static final String GETID_STMT = "SELECT COUNT(UserID) FROM shoppinguser";
    private static final String ALLRETRIEVE_STMT = "SELECT * FROM shoppingUser WHERE UserType=?";
    private static final String UPDATE_STMT = "UPDATE shoppingUser SET UserName = ?, PhoneNum = ?, Address = ? WHERE UserID = ?";
    private static final String SELECT_STMT = "SELECT * FROM shoppingUser WHERE UserID=?";
    private static final String SEARCHID_STMT =  "SELECT * FROM shoppingUser WHERE UserName=? AND PhoneNum=?";
    private static final String SEARCHPWD_STMT =  "SELECT * FROM shoppingUser WHERE UserID=? AND PhoneNum=?";
    
    //모든 데이터를 가져온다
    ArrayList<User> allUserRetrieve() throws SQLException {
        ArrayList<User> users = new ArrayList<User>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try {
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(ALLRETRIEVE_STMT);
            rset = stmt.executeQuery();
            while (rset.next()) {
                String UserID = rset.getString(1);
                String UserType = rset.getString(2);
                String UserName = rset.getString(3);
                String Password = rset.getString(4);
                String PhoneNum = rset.getString(5);
                String Address = rset.getString(6);
                users.add(new User(UserID, UserType, UserName, Password, PhoneNum, Address));
            }
            return users;
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
    //유저의 데이터를 가져온다
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
    //유저의 데이터를 가져온다
    User getUserInfo(String userID) throws SQLException {
        User user = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        int rows = 0;
        try {
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(SELECT_STMT);
            stmt.setString(1, userID);
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
    //새로운 고객의 정보를 DB에 추가
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
    //상품 데이터를 수정한다.
    void userUpdate(String userID, String username, String phoneNum, String address) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        //UPDATE_STMT = "UPDATE shoppingUser SET UserName = ?, PhoneNum = ?, Address = ? WHERE UserID = ?";
    
        try {
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(UPDATE_STMT);
            stmt.setString(1, username);
            stmt.setString(2, phoneNum);
            stmt.setString(3, address);
            stmt.setString(4, userID);
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
    //ID검색
    User searchUserID(String userName, String PhoneNum) throws SQLException {
        User user=null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try {
            //String SEARCHID_STMT =  "SELECT UserID FROM shoppingUser WHERE UserName=? AND PhoneNum=?";
    
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(SEARCHID_STMT);
            stmt.setString(1, userName);
            stmt.setString(2, PhoneNum);
            rset = stmt.executeQuery();
            while (rset.next()) {
                String UserID = rset.getString("UserID");
                String UserType = rset.getString("UserType");
                String UserName = rset.getString("UserName");
                String Password = rset.getString("Password");
                String UserPhoneNum = rset.getString("PhoneNum");
                String Address = rset.getString("Address");
                
                /*String UserID = rset.getString(1);
                String UserType= rset.getString(2);
                String UserName = rset.getString(3);
                String Password = rset.getString(4);
                String UserPhoneNum = rset.getString(5);
                String Address = rset.getString(6);*/
                user=new User(UserID,UserType,UserName,Password,UserPhoneNum,Address);
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
    
    //비밀번호 검색
    User searchUserPwd(String userID, String PhoneNum) throws SQLException {
        User user=null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try {
            //String SEARCHID_STMT =  "SELECT UserID FROM shoppingUser WHERE UserName=? AND PhoneNum=?";
    
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(SEARCHPWD_STMT);
            stmt.setString(1, userID);
            stmt.setString(2, PhoneNum);
            rset = stmt.executeQuery();
            while (rset.next()) {
                String UserID = rset.getString("UserID");
                String UserType = rset.getString("UserType");
                String UserName = rset.getString("UserName");
                String Password = rset.getString("Password");
                String UserPhoneNum = rset.getString("PhoneNum");
                String Address = rset.getString("Address");
                
                /*String UserID = rset.getString(1);
                String UserType= rset.getString(2);
                String UserName = rset.getString(3);
                String Password = rset.getString(4);
                String UserPhoneNum = rset.getString(5);
                String Address = rset.getString(6);*/
                user=new User(UserID,UserType,UserName,Password,UserPhoneNum,Address);
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
}
