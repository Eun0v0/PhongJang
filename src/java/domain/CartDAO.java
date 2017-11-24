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
public class CartDAO {
    private DBConnectionPool connPool;
    private static final String RETRIEVE_STMT = "SELECT * FROM shoppingCart2 where UserID = ?";
    private static final String GETID_STMT = "SELECT COUNT(CartID) FROM shoppingCart2";
    private static final String ADD_STMT = "INSERT INTO shoppingCart2 VALUES(?,?,?,?,?,?,?,?)";
    private static final String DELETE_STMT = "DELETE FROM shoppingCart2 WHERE userID = ? AND CartID = ?";
    private static final String CLEAN_STMT = "DELETE FROM shoppingCart2 WHERE userID = ? AND CartID = ?";
    
    //장바구니의 모든 정보를 가져온다
    ArrayList<Cart> cartRetrieve(String userID) throws SQLException{
        ArrayList<Cart> carts = new ArrayList<Cart>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        
        try{
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(RETRIEVE_STMT);
            stmt.setString(1,userID);
            rset = stmt.executeQuery();
            while(rset.next()){
                int cartID = rset.getInt(1);
                String UserID = rset.getString(2);
                String caseName = rset.getString(3);
                String color = rset.getString(4);
                int numbers = rset.getInt(5);
                int price = rset.getInt(6);
                String phoneType = rset.getString(7);
                String caseType = rset.getString(8);
                
                carts.add(new Cart(cartID, UserID, caseName, color, numbers, price, phoneType, caseType));
            }
            return carts;
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
    //장바구니에 상품을 추가한다
    void addToCart(String userID, String caseName, String color, int numbers, int price, String phoneType, String caseType){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try{
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(GETID_STMT);
            rset = stmt.executeQuery();
            int ID = -1;
            rset.next();
            ID = rset.getInt("COUNT(CartID)");
            ID++;
            //ADD_STMT = "INSERT INTO shoppingCart VALUES(?,?,?,?,?,?)";
    
            stmt = conn.prepareStatement(ADD_STMT);
            stmt.setInt(1, ID);
            stmt.setString(2, userID);
            stmt.setString(3, caseName);
            stmt.setString(4, color);
            stmt.setInt(5, numbers);
            stmt.setInt(6, price);
            stmt.setString(7, phoneType);
            stmt.setString(8, caseType);
            
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
    void deleteFromCart(String userID, int cartID){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        //DELETE_STMT = "DELETE FROM shoppingCart2 WHERE userID = ? AND CartID = ?";
    
        try{
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(DELETE_STMT);
            stmt.setString(1, userID);
            stmt.setInt(2, cartID);
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
    //장바구니에서 모든 상품을 지운다
    void cleanCart(String userID, int cartID){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try{
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(CLEAN_STMT);
            stmt.setString(1, userID);
            stmt.setInt(2, cartID);
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
