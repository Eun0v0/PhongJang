/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.DBConnectionPool;

/**
 *
 * @author yukih
 */
public class PhoneTypeDAO {
    private DBConnectionPool connPool;
    private static final String SELECT_STMT
            = "SELECT * FROM PhoneType WHERE CaseName=?";
    private static final String INSERT_STMT = "INSERT INTO PhoneType VALUES(?,?)";
    private static final String DELETE_STMT = "DELETE FROM PhoneType WHERE CaseName = ?";
    
     //검색된 단어를 포함하는 데이터를 가져온다.
    ArrayList<PhoneType> phoneTypeRetrieve(String caseName) throws SQLException {
        ArrayList<PhoneType> phoneTypes = new ArrayList<PhoneType>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try {
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(SELECT_STMT);
            stmt.setString(1, caseName);
            rset = stmt.executeQuery();
            while (rset.next()) {
                String CaseName = rset.getString(1);
                String phoneType = rset.getString(2);
                phoneTypes.add(new PhoneType(CaseName, phoneType));
            }
            return phoneTypes;
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
    
    //새로운 상품 데이터를 입력한다.
    void phoneTypeInsert(String caseName, String phoneType) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try {
            //INSERT_STMT = "INSERT INTO CasePhoneType VALUES(?,?)
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(INSERT_STMT);
            stmt.setString(1, caseName);
            stmt.setString(2, phoneType);
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
    //상품 데이터를 삭제한다.
    void phoneTypeDelete(String caseName) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        //DELETE_STMT = "DELETE FROM PhoneType WHERE CaseName = ?";
        try {
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(DELETE_STMT);
            stmt.setString(1, caseName);
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
