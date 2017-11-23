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
public class CaseColorDAO {
    private DBConnectionPool connPool;
    private static final String SELECT_STMT
            = "SELECT * FROM CaseColor WHERE CaseName=?";
    private static final String INSERT_STMT = "INSERT INTO CaseColor VALUES(?,?)";
    
     //검색된 단어를 포함하는 데이터를 가져온다.
    ArrayList<CaseColor> caseColorRetrieve(String caseName) throws SQLException {
        ArrayList<CaseColor> caseColors = new ArrayList<CaseColor>();
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
                String caseColor = rset.getString(2);
                caseColors.add(new CaseColor(CaseName, caseColor));
            }
            return caseColors;
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
    void caseColorInsert(String caseName, String caseColor) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try {
            //INSERT_STMT = "INSERT INTO CasePhoneType VALUES(?,?)
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(INSERT_STMT);
            stmt.setString(1, caseName);
            stmt.setString(2, caseColor);
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
