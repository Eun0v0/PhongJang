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
public class ReviewDAO {
    private DBConnectionPool connPool;
    private static final String RETRIEVE_STMT = "SELECT * FROM Review where CaseID = ?";
    private static final String GET_STMT = "SELECT * FROM Review where ReplyNum = ?";
    
    private static final String GETID_STMT = "SELECT COUNT(ReplyNum) FROM Review";
    //private static final String UPDATE_STMT = "UPDATE Review SET Title = ?, CaseType = ?, PhoneType = ?, Color = ? ,Content = ?, Image = ? WHERE MyCaseNum = ?";
    private static final String ADD_STMT = "INSERT INTO Review VALUES(?,?,?,?,?,?)";
    private static final String DELETE_STMT = "DELETE FROM Review WHERE userID = ? AND ReplyNum = ? AND CaseID = ?";
    
    //해당 케이스에 대한 리뷰를 가져온다
    ArrayList<Review> reviewRetrieve(int caseID) throws SQLException{
        ArrayList<Review> reviews = new ArrayList<Review>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        
        try{
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(RETRIEVE_STMT);
            stmt.setInt(1,caseID);
            rset = stmt.executeQuery();
            while(rset.next()){
                int replyNum = rset.getInt(1);
                int CaseID = rset.getInt(2);
                String userID = rset.getString(3);
                String content = rset.getString(4);
                String grade = rset.getString(5);
                String writeDate = rset.getString(6);
               
                reviews.add(new Review(replyNum, CaseID, userID, content, grade,writeDate));
            }
            return reviews;
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
    void addMyCase(int caseID, String userID, String content, String grade, String writeDate){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try{
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(GETID_STMT);
            rset = stmt.executeQuery();
            int ID = -1;
            rset.next();
            ID = rset.getInt("COUNT(ReplyNum)");
            ID++;
            
            stmt = conn.prepareStatement(ADD_STMT);
            stmt.setInt(1, ID);
            stmt.setInt(2, caseID);
            stmt.setString(3, userID);
            stmt.setString(4, content);
            stmt.setString(5, grade);
            stmt.setString(6, writeDate);
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
    void deleteMyCase(String userID, int replyNum, int caseID){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        //String DELETE_STMT = "DELETE FROM Review WHERE userID = ? AND ReplyNum = ? AND CaseID = ?";
    
        try{
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(DELETE_STMT);
            stmt.setString(1, userID);
            stmt.setInt(2, replyNum);
            stmt.setInt(3, caseID);
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
