/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

<<<<<<< HEAD
/**
 *
 * @author user
 */
public class QnaDAO {
    
=======
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DBConnectionPool;

public class QnaDAO {

    private DBConnectionPool connPool;
    private static final String ALLRETRIEVE_STMT
            = "SELECT * FROM boardQna";
    private static final String INSERT_STMT = "INSERT INTO boardQna VALUES(?,?,?,?,?,?,?)";
    private static final String UPDATE_STMT = "UPDATE shoppingProduct SET CaseName = ?, CaseType = ?, Explanation = ?, Price = ? WHERE CaseID = ?";
    private static final String GETNUM_STMT = "SELECT COUNT(QnaNum) FROM boardQna";
    private static final String DELETE_STMT = "DELETE FROM boardQna WHERE QnaNum = ?";

    //모든 데이터를 가져온다
    ArrayList<Qna> allQnaRetrieve() throws SQLException {
        ArrayList<Qna> qna = new ArrayList<Qna>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try {
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(ALLRETRIEVE_STMT);
            rset = stmt.executeQuery();
            while (rset.next()) {
                int QnaNum = rset.getInt(1);
                String UserName = rset.getString(2);
                int PassWord = rset.getInt(3);
                String QnaTitle = rset.getString(4);
                String QnaContent = rset.getString(5);
                String QnaTime = rset.getString(6);
                int QnaHits = rset.getInt(7);
                qna.add(new Qna(QnaNum, UserName, PassWord, QnaTitle, QnaContent, QnaTime, QnaHits));
            }
            return qna;
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
    void qnaInsert(String userName, int passWord, String qnaTitle, String qnaContent, String qnaTime, int qnaHits) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try {
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(GETNUM_STMT);
            rset = stmt.executeQuery();
            int Num = -1;
            rset.next();
            Num = rset.getInt("COUNT(QnaNum)");
            Num++;
            stmt = conn.prepareStatement(INSERT_STMT);
            stmt.setInt(1, Num);
            stmt.setString(2, userName);
            stmt.setInt(3, passWord);
            stmt.setString(4, qnaTitle);
            stmt.setString(5, qnaContent);
            stmt.setString(6, qnaTime);
            stmt.setInt(7, qnaHits);
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

>>>>>>> b1a42c8de5d04552ef6508021fa1a8c26be2d0df
}
