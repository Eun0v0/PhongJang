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

public class PhoneCaseDAO {

    private DBConnectionPool connPool;
    private static final String ALLRETRIEVE_STMT
            = "SELECT * FROM shoppingproduct";
    private static final String INSERT_STMT = "INSERT INTO shoppingproduct VALUES(?,?,?,?,?)";
    private static final String UPDATE_STMT = "UPDATE shoppingproduct SET CaseName = ? CaseType = ? Explanation = ? Price = ? WHERE CaseID = ?";
    private static final String GETID_STMT = "SELECT COUNT(CaseID) FROM shoppingproduct";

    //모든 데이터를 가져온다
    ArrayList<PhoneCase> allPhoneCaseRetrieve() throws SQLException {
        ArrayList<PhoneCase> phoneCase = new ArrayList<PhoneCase>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try {
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(ALLRETRIEVE_STMT);
            rset = stmt.executeQuery();
            while (rset.next()) {
                int CaseID = rset.getInt(1);
                String CaseName = rset.getString(2);
                String CaseType = rset.getString(3);
                String Explanation = rset.getString(4);
                int Price = rset.getInt(5);
                phoneCase.add(new PhoneCase(CaseID, CaseName, CaseType, Explanation, Price));
            }
            return phoneCase;
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

    //검색된 단어를 포함하는 데이터를 가져온다.
    ArrayList<PhoneCase> phoneCaseRetrieve(String caseName) throws SQLException {
        ArrayList<PhoneCase> phoneCase = new ArrayList<PhoneCase>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try {
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement("SELECT * FROM shoppingproduct WHERE CaseName like '%" + caseName + "%'");
            rset = stmt.executeQuery();
            while (rset.next()) {
                int CaseID = rset.getInt(1);
                String CaseName = rset.getString(2);
                String CaseType = rset.getString(3);
                String Explanation = rset.getString(4);
                int Price = rset.getInt(5);
                phoneCase.add(new PhoneCase(CaseID, CaseName, CaseType, Explanation, Price));
            }
            return phoneCase;
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
    void productInsert(String caseType, String caseName, String explanation, int price) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try {
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(GETID_STMT);
            rset = stmt.executeQuery();
            int ID = -1;
            rset.next();
            ID = rset.getInt("COUNT(CaseID)");
            ID++;
            stmt = conn.prepareStatement(INSERT_STMT);
            stmt.setInt(1, ID);
            stmt.setString(2, caseName);
            stmt.setString(3, caseType);
            stmt.setString(4, explanation);
            stmt.setInt(5, price);
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
    void productUpdate(int caseID, String caseType, String caseName, String explanation, int price) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try {
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(UPDATE_STMT);
            stmt.setString(1, caseName);
            stmt.setString(2, caseType);
            stmt.setString(3, explanation);
            stmt.setInt(4, price);
            stmt.setInt(5, caseID);
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