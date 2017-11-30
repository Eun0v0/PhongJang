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

/**
 *
 * @author yukih
 */
public class QnaReplyDAO {
    private DBConnectionPool connPool;
    private static final String RETRIEVE_STMT = "SELECT * FROM QnaReply where QnaNum = ?";
    private static final String GET_STMT = "SELECT * FROM QnaReply where QnaNum = ?";
    private static final String ADD_STMT = "INSERT INTO QnaReply VALUES(?,?,?,?)";
    private static final String DELETE_STMT = "DELETE FROM QnaReply WHERE qnaNum = ?";
    
    public ArrayList<QnaReply> getAllReply(int qnaNum) throws SQLException{
        ArrayList<QnaReply> qnaReplys = new ArrayList<QnaReply>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        //String GET_STMT = "SELECT * FROM MyCase where MyCaseNum = ?";
        try{
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(GET_STMT);
            stmt.setInt(1,qnaNum);
            rset = stmt.executeQuery();
            while(rset.next()){
                int QnaNum = rset.getInt(1);
                String userID = rset.getString(2);
                String content = rset.getString(3);
                String writeDate = rset.getString(4);
                qnaReplys.add(new QnaReply(QnaNum, userID, content, writeDate));
            }
            return qnaReplys;
        }catch(SQLException se){
            throw new RuntimeException("A database error occured"+se.getMessage());
        } catch(Exception e) {
            throw new RuntimeException("Exception: "+ e.getMessage());
        } finally {
            if(rset != null){
                try{
                    rset.close();
                } catch (SQLException se){
                    se.printStackTrace(System.err);
                }
            }
            if(stmt != null){
                try{
                    stmt.close();
                } catch (SQLException se){
                    se.printStackTrace(System.err);
                }
            }
            if(conn != null){
                try{
                    conn.close();
                } catch(Exception e){
                    e.printStackTrace(System.err);
                }
            }
        }
    }
    public QnaReply getReply(int qnaNum) throws SQLException{
        QnaReply qnaReply = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        //String GET_STMT = "SELECT * FROM MyCase where MyCaseNum = ?";
        try{
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(GET_STMT);
            stmt.setInt(1,qnaNum);
            rset = stmt.executeQuery();
            while(rset.next()){
                int QnaNum = rset.getInt(1);
                String userID = rset.getString(2);
                String content = rset.getString(3);
                String writeDate = rset.getString(4);
                qnaReply = new QnaReply(QnaNum, userID, content, writeDate);
            }
            return qnaReply;
        }catch(SQLException se){
            throw new RuntimeException("A database error occured"+se.getMessage());
        } catch(Exception e) {
            throw new RuntimeException("Exception: "+ e.getMessage());
        } finally {
            if(rset != null){
                try{
                    rset.close();
                } catch (SQLException se){
                    se.printStackTrace(System.err);
                }
            }
            if(stmt != null){
                try{
                    stmt.close();
                } catch (SQLException se){
                    se.printStackTrace(System.err);
                }
            }
            if(conn != null){
                try{
                    conn.close();
                } catch(Exception e){
                    e.printStackTrace(System.err);
                }
            }
        }
    }
    // 마이 케이스 문의 글을 추가한다
    public void addQnaReply(int qnaNum, String userID, String content, String writeDate){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try{
            conn = connPool.getPoolConnection();
            
            stmt = conn.prepareStatement(ADD_STMT);
            stmt.setInt(1, qnaNum);
            stmt.setString(2, userID);
            stmt.setString(3, content);
            stmt.setString(4, writeDate);
            stmt.executeQuery();
        } catch(SQLException se){
            throw new RuntimeException("A database eroor occured." + se.getMessage());
        }finally {
            if(stmt != null){
                try{
                    stmt.close();
                } catch (SQLException se){
                    se.printStackTrace(System.err);
                }
            }
            if(conn != null){
                try{
                    conn.close();
                } catch(Exception e){
                    e.printStackTrace(System.err);
                }
            }
        }
    }
    
    //장바구니에서 상품을 삭제한다
    public void deleteQnaReply(String userID, int qnaNum){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        //"DELETE FROM QnaReply WHERE qnaNum = ?";
        try{
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(DELETE_STMT);
            stmt.setInt(1, qnaNum);
            stmt.executeQuery();
        } catch(SQLException se){
            throw new RuntimeException("A database eroor occured." + se.getMessage());
        }finally {
            if(stmt != null){
                try{
                    stmt.close();
                } catch (SQLException se){
                    se.printStackTrace(System.err);
                }
            }
            if(conn != null){
                try{
                    conn.close();
                } catch(Exception e){
                    e.printStackTrace(System.err);
                }
            }
        }
    }
}
