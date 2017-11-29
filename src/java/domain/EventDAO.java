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
public class EventDAO {
    private DBConnectionPool connPool;
    private static final String RETRIEVE_STMT = "SELECT * FROM Event";
    private static final String GET_STMT = "SELECT * FROM Event WHERE EventID=?";
    
    private static final String GETID_STMT = "SELECT MAX(EventID) FROM Event";
    private static final String UPDATE_STMT = "UPDATE event SET Title = ?, Image = ?, WriteDate = ?, Content = ? WHERE EventID = ?";
    private static final String ADD_STMT = "INSERT INTO Event VALUES(?,?,?,?,?)";
    private static final String DELETE_STMT = "DELETE FROM Event WHERE EventID = ?";
    
    //전체 마이케이스 문의 내역을 가져온다
    ArrayList<Event> eventRetrieve() throws SQLException{
        ArrayList<Event> events = new ArrayList<Event>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        
        try{
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(RETRIEVE_STMT);
            rset = stmt.executeQuery();
            while(rset.next()){
                int eventID = rset.getInt(1);
                String title = rset.getString(2);
                String image = rset.getString(3);
                String writeDate = rset.getString(4);
                String content = rset.getString(5);
                events.add(new Event(eventID, title, image, writeDate, content));
            }
            return events;
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
    
    Event getEvent(int eventID) throws SQLException{
        Event event = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        //String GET_STMT = "SELECT * FROM MyCase where MyCaseNum = ?";
        try{
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(GET_STMT);
            stmt.setInt(1,eventID);
            rset = stmt.executeQuery();
            while(rset.next()){
                int EventID = rset.getInt(1);
                String title = rset.getString(2);
                String image = rset.getString(3);
                String writeDate = rset.getString(4);
                String content = rset.getString(5);
               
                event = new Event(EventID, title, image, writeDate, content);
            }
            return event;
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
    void addEvent(String title, String image, String writeDate, String content){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try{
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(GETID_STMT);
            rset = stmt.executeQuery();
            int ID = -1;
            rset.next();
            ID = rset.getInt("MAX(EventID)");
            ID++;
            if(ID == 100)
                ID=1;
            
            stmt = conn.prepareStatement(ADD_STMT);
            stmt.setInt(1, ID);
            stmt.setString(2, title);
            stmt.setString(3, image);
            stmt.setString(4, writeDate);
            stmt.setString(5, content);
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
    void updateEvent(int eventID, String title, String image, String writeDate, String content){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        //UPDATE_STMT = "UPDATE event SET Title = ?, Image = ?, WriteDate = ?, Content = ? WHERE EventID = ?";
    
        try {
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(UPDATE_STMT);
            stmt.setString(1, title);
            stmt.setString(2, image);
            stmt.setString(3, writeDate);
            stmt.setString(4, content);
            stmt.setInt(5, eventID);
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
    void deleteEvent(int eventID){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        //String DELETE_STMT = "DELETE FROM MyCase WHERE userID = ? AND MyCaseNum = ?";
    
        try{
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(DELETE_STMT);
            stmt.setInt(1, eventID);
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
