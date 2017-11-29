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
public class ReplyMyCaseDAO {
    private DBConnectionPool connPool;
    //private static final String RETRIEVE_STMT = "SELECT * FROM ReplyMyCase where UserID = ?";
    private static final String GET_STMT = "SELECT * FROM ReplyMyCase where MyCaseNum = ?";
    private static final String GETALL_STMT = "SELECT * FROM ReplyMyCase";
    
    private static final String GETID_STMT = "SELECT MAX(MyCaseNum) FROM ReplyMyCase";
    private static final String UPDATE_STMT = "UPDATE ReplyMyCase SET status = ? WHERE MyCaseNum = ?";
    private static final String ADD_STMT = "INSERT INTO ReplyMyCase VALUES(?,?,?,?,?,?,?)";
    //private static final String DELETE_STMT = "DELETE FROM ReplyMyCase WHERE MyCaseNum = ?";
    
    //전체 마이케이스 문의 내역을 가져온다
    ArrayList<ReplyMyCase> myCaseReplyRetrieve() throws SQLException{
        ArrayList<ReplyMyCase> replyMyCases = new ArrayList<ReplyMyCase>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        
        try{
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(GETALL_STMT);
            rset = stmt.executeQuery();
            while(rset.next()){
                int myCaseNum = rset.getInt(1);
                String account = rset.getString(2);
                String image = rset.getString(3);
                String dueDate = rset.getString(4);
                String content = rset.getString(5);
                String status = rset.getString(6);
                int price = rset.getInt(7);
                replyMyCases.add(new ReplyMyCase(myCaseNum, account, image, dueDate, content, status, price));
            }
            return replyMyCases;
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
    
    ReplyMyCase getMyCase(int myCaseNum) throws SQLException{
        ReplyMyCase replyMyCase = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        //String GET_STMT = "SELECT * FROM MyCase where MyCaseNum = ?";
        try{
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(GET_STMT);
            stmt.setInt(1,myCaseNum);
            rset = stmt.executeQuery();
            while(rset.next()){
                int MyCaseNum = rset.getInt(1);
                String account = rset.getString(2);
                String image = rset.getString(3);
                String dueDate = rset.getString(4);
                String content = rset.getString(5);
                String status = rset.getString(6);
                int price = rset.getInt(7);
                replyMyCase = new ReplyMyCase(myCaseNum, account, image, dueDate, content, status, price);
            }
            return replyMyCase;
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
    void addMyCaseReply(int myCaseNum, String account, String image, String dueDate, String content, String status, int price){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try{
            conn = connPool.getPoolConnection();
            
            stmt = conn.prepareStatement(ADD_STMT);
            stmt.setInt(1, myCaseNum);
            stmt.setString(2, account);
            stmt.setString(3, image);
            stmt.setString(4, dueDate);
            stmt.setString(5, content);
            stmt.setString(6, status);
            stmt.setInt(7, price);
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
    //상품 데이터를 수정한다.
    void myCaseReplyUpdate(int myCaseNum, String status){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        //UPDATE_STMT = "UPDATE ReplyMyCase SET status = ? WHERE MyCaseNum = ?";
        try {
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(UPDATE_STMT);
            stmt.setInt(1, myCaseNum);
            stmt.setString(2, status);
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
    //장바구니에서 상품을 삭제한다
    /*void deleteMyCase(String userID, int myCaseNum){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        //String DELETE_STMT = "DELETE FROM MyCase WHERE userID = ? AND MyCaseNum = ?";
    
        try{
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(DELETE_STMT);
            stmt.setString(1, userID);
            stmt.setInt(2, myCaseNum);
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
    }*/
}
