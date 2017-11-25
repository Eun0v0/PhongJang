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
public class MyCaseDAO {
    private DBConnectionPool connPool;
    private static final String RETRIEVE_STMT = "SELECT * FROM MyCase where UserID = ?";
    private static final String GET_STMT = "SELECT * FROM MyCase where MyCaseNum = ?";
    
    private static final String GETID_STMT = "SELECT COUNT(MyCaseNum) FROM MyCase";
    private static final String UPDATE_STMT = "UPDATE MyCase SET Title = ?, CaseType = ?, PhoneType = ?, Color = ? ,Content = ?, Image = ? WHERE MyCaseNum = ?";
    private static final String ADD_STMT = "INSERT INTO MyCase VALUES(?,?,?,?,?,?,?,?,?)";
    private static final String DELETE_STMT = "DELETE FROM MyCase WHERE userID = ? AND MyCaseNum = ?";
    
    //내가 작성한 마이케이스 문의 내역을 가져온다
    ArrayList<MyCase> myCaseRetrieve(String userID) throws SQLException{
        ArrayList<MyCase> myCases = new ArrayList<MyCase>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        
        try{
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(RETRIEVE_STMT);
            stmt.setString(1,userID);
            rset = stmt.executeQuery();
            while(rset.next()){
                int myCaseNum = rset.getInt(1);
                String UserID = rset.getString(2);
                String title = rset.getString(3);
                String caseType = rset.getString(4);
                String phoneType = rset.getString(5);
                String color = rset.getString(6);
                String content = rset.getString(7);
                String image = rset.getString(8);
                String writeDate = rset.getString(9);
                myCases.add(new MyCase(myCaseNum, UserID, title, caseType, phoneType,
                        color, content, image, writeDate));
            }
            return myCases;
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
    MyCase getMyCase(int myCaseNum) throws SQLException{
        MyCase myCase = null;
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
                String UserID = rset.getString(2);
                String title = rset.getString(3);
                String caseType = rset.getString(4);
                String phoneType = rset.getString(5);
                String color = rset.getString(6);
                String content = rset.getString(7);
                String image = rset.getString(8);
                String writeDate = rset.getString(9);
                myCase = new MyCase(MyCaseNum, UserID, title, caseType, phoneType,
                        color, content, image, writeDate);
            }
            return myCase;
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
    void addMyCase(String userID, String title, String caseType, String phoneType,
            String color, String content, String image, String writeDate){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try{
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(GETID_STMT);
            rset = stmt.executeQuery();
            int ID = -1;
            rset.next();
            ID = rset.getInt("COUNT(MyCaseNum)");
            ID++;
            
            stmt = conn.prepareStatement(ADD_STMT);
            stmt.setInt(1, ID);
            stmt.setString(2, userID);
            stmt.setString(3, title);
            stmt.setString(4, caseType);
            stmt.setString(5, phoneType);
            stmt.setString(6, color);
            stmt.setString(7, content);
            stmt.setString(8, image);
            stmt.setString(9, writeDate);
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
    void myCaseUpdate(int myCaseNum, String title, String caseType, String phoneType,
            String color, String content, String image){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        //UPDATE shoppingUser SET Title = ?, CaseType = ?, PhoneType = ?, Color = ? ,Content = ?, Image = ? WHERE MyCaseNum = ?"
        try {
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(UPDATE_STMT);
            stmt.setString(1, title);
            stmt.setString(2, caseType);
            stmt.setString(3, phoneType);
            stmt.setString(4, color);
            stmt.setString(5, content);
            stmt.setString(6, image);
            stmt.setInt(7, myCaseNum);
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
    void deleteMyCase(String userID, int myCaseNum){
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
    }
}
