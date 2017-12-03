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
    private static final String ALLRETRIEVE_STMT = "SELECT * FROM boardQna ORDER BY QnaNum desc";
    private static final String INSERT_STMT = "INSERT INTO boardQna VALUES(?,?,?,?,?,?)";
    private static final String UPDATE_STMT = "UPDATE boardQna SET QnaTitle = ?, UserName = ?, QnaContent = ? WHERE QnaNum = ?";
    private static final String GETNUM_STMT = "SELECT MAX(QnaNum) FROM boardQna";
    private static final String DELETE_STMT = "DELETE FROM boardQna WHERE QnaNum = ? AND Password = ?";
    private static final String RETRIEVE_STMT
            = "SELECT * FROM boardQna WHERE QnaNum = ?";
    private static final String SELECT_STMT = "SELECT * FROM boardQna WHERE qnaNum=?";
    private static final String GETMY_STMT
            = "SELECT * FROM boardQna WHERE UserName = ?";
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

    //새로운 질문에 대한 데이터를 입력한다.
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
            Num = rset.getInt("MAX(QnaNum)");
            Num++;
            if(Num == 1000)
                Num=1;
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
    //질문을 삭제한다
    void qnaDelete(int qnaNum, String password) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;

        try {
            //DELETE FROM boardQna WHERE QnaNum = ? AND Password = ?
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(DELETE_STMT);
            stmt.setInt(1, qnaNum);
            stmt.setString(2, password);
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
    //모든 질문 내역을 가져온다
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
    
    //특정 고객이 작성한 질문 내역을 모두 가져온다
    ArrayList<Qna> myQna(String userName) throws SQLException {
        ArrayList<Qna> qnas = new ArrayList<Qna>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try {
            //String RETRIEVE_STMT= "SELECT * FROM shoppingPayment WHERE UserID = ?";
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement("SELECT * FROM boardQna WHERE UserName like '%" + userName + "%'");
            //stmt.setString(1, userName);
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
    //질문 내용을 수정한다
    void qnaUpdate(int qnaNum, String userName, String qnaTitle, String qnaContent) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        //UPDATE boardQna SET QnaTitle = ?, UserName = ?, QnaContent = ? WHERE QnaNum = ?
        try {
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(UPDATE_STMT);
            stmt.setString(1, qnaTitle);
            stmt.setString(2, userName);
            stmt.setString(3, qnaContent);
            stmt.setInt(4, qnaNum);
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
    //클릭하여 내용을 보고자 하는 질문의 데이터를 가져온다
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
