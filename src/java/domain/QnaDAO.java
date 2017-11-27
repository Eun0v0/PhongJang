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

public class QnaDAO {

    private DBConnectionPool connPool;
    private static final String ALLRETRIEVE_STMT = "SELECT * FROM boardQna";
    private static final String INSERT_STMT = "INSERT INTO boardQna VALUES(?,?,?,?,?,?)";
    private static final String UPDATE_STMT = "UPDATE boardQna SET QnaTitle = ?, UserName = ?, PassWord = ?, QnaContent = ? WHERE QnaNum = ?";
    private static final String GETNUM_STMT = "SELECT COUNT(QnaNum) FROM boardQna";
    private static final String DELETE_STMT = "DELETE FROM boardQna WHERE QnaNum = ?";
    private static final String RETRIEVE_STMT
            = "SELECT * FROM boardQna WHERE QnaNum = ?";
    private static final String SELECT_STMT = "SELECT * FROM boardQna WHERE qnaNum=?";

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
                String PassWord = rset.getString(3);
                String QnaTitle = rset.getString(4);
                String QnaContent = rset.getString(5);
                String QnaTime = rset.getString(6);
                qna.add(new Qna(QnaNum, UserName, PassWord, QnaTitle, QnaContent, QnaTime));
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
    void qnaInsert(String userName, String passWord, String qnaTitle, String qnaContent, String s_date) {
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
            stmt.setString(3, passWord);
            stmt.setString(4, qnaTitle);
            stmt.setString(5, qnaContent);
            stmt.setString(6, s_date);
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

    void qnaDelete(int qnaNum) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;

        try {
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(DELETE_STMT);
            stmt.setInt(1, qnaNum);
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

    ArrayList<Qna> qnaRetrieve(int qnaNum) throws SQLException {
        ArrayList<Qna> qnas = new ArrayList<Qna>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try {
            //String RETRIEVE_STMT= "SELECT * FROM shoppingPayment WHERE UserID = ?";
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(RETRIEVE_STMT);
            stmt.setInt(1, qnaNum);
            rset = stmt.executeQuery();
            while (rset.next()) {
                int QnaNum = rset.getInt(1);
                String UserName = rset.getString(2);
                String PassWord = rset.getString(3);
                String QnaTitle = rset.getString(4);
                String QnaContent = rset.getString(5);
                String QnaTime = rset.getString(6);
                qnas.add(new Qna(QnaNum, UserName, PassWord, QnaTitle, QnaContent, QnaTime));
            }
            return qnas;
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

    void qnaUpdate(int qnaNum, String userName, String passWord, String qnaTitle, String qnaContent) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        //UPDATE boardQna SET QnaTitle = ?, UserName = ?, PassWord = ?, QnaContent = ? WHERE QnaNum = ?
        try {
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(UPDATE_STMT);
            stmt.setString(1, qnaTitle);
            stmt.setString(2, userName);
            stmt.setString(3, passWord);
            stmt.setString(4, qnaContent);
            stmt.setInt(5, qnaNum);
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

    Qna getQnaInfo(int qnaNum) throws SQLException {
        Qna qna = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        int rows = 0;
        try {
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(SELECT_STMT);
            stmt.setInt(1, qnaNum);
            rset = stmt.executeQuery();

            //데이터 베이스에서 유저 데이터 가져오기
            while (rset.next()) {
                int QnaNum = rset.getInt("QnaNum");
                String UserName = rset.getString("UserName");
                String PassWord = rset.getString("PassWord");
                String QnaTitle = rset.getString("QnaTitle");
                String QnaContent = rset.getString("QnaContent");
                String QnaTime = rset.getString("QnaTime");
                rows++;
                if (rows > 1) {
                    throw new SQLException("Too many rows were returned.");
                }
                qna = new Qna(QnaNum, UserName, PassWord, QnaTitle, QnaContent, QnaTime);
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
}
