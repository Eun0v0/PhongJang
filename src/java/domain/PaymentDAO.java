package domain;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import util.DBConnectionPool;
public class PaymentDAO {
    private DBConnectionPool connPool;
    private static final String ALLRETRIEVE_STMT
            = "SELECT * FROM shoppingPayment";
    private static final String RETRIEVE_STMT
            = "SELECT * FROM shoppingPayment WHERE UserID = ?";
    private static final String NUMBER_STMT
            = "SELECT Numbers FROM shoppingPayment WHERE PaymentID = ?";
    private static final String COLOR_STMT
            = "SELECT Color FROM shoppingPayment WHERE PaymentID = ?";
    private static final String NAME_STMT
            = "SELECT CaseName FROM shoppingPayment WHERE PaymentID = ?";
    
    private static final String GETID_STMT = "SELECT MAX(PaymentID) FROM shoppingPayment";
    private static final String ADD_STMT = "INSERT INTO shoppingPayment VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String DELETE_STMT = "DELETE FROM shoppingPayment WHERE PaymentID = ?";
    private static final String UPDATE_STMT = "UPDATE shoppingPayment SET ParcelNumber = ?, Status=? WHERE PaymentID = ?";
   
    //관리자 모드- 모든 고객이 결제한 내역을 가져온다
    ArrayList<Payment> allpaymentRetrieve() throws SQLException {
        ArrayList<Payment> payments = new ArrayList<Payment>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try {
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(ALLRETRIEVE_STMT);
            rset = stmt.executeQuery();
            while (rset.next()) {
                int PaymentID = rset.getInt(1);
                String UserID = rset.getString(2);
                String CaseName = rset.getString(3);
                int Numbers = rset.getInt(4);
                int Price = rset.getInt(5);
                String Address = rset.getString(6);
                String PhoneNumber = rset.getString(7);
                String CreditCardNumber = rset.getString(8);
                String CreditCardPassword = rset.getString(9);
                String status = rset.getString(10);
                String parcelNumber= rset.getString(11);
                String orderDate = rset.getString(12);
                String phoneType = rset.getString(13);
                String caseType = rset.getString(14);
                String color = rset.getString(15);
                payments.add(new Payment(PaymentID, UserID, CaseName, Numbers, Price, Address, 
                             PhoneNumber, CreditCardNumber, CreditCardPassword, status, parcelNumber, orderDate,
                             phoneType, caseType, color));
            }
            return payments;
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
    
    //고객 모드- 결제한 내역을 가져온다
    ArrayList<Payment> paymentRetrieve(String userID) throws SQLException {
        ArrayList<Payment> payments = new ArrayList<Payment>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try {
            //String RETRIEVE_STMT= "SELECT * FROM shoppingPayment WHERE UserID = ?";
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(RETRIEVE_STMT);
            stmt.setString(1, userID);
            rset = stmt.executeQuery();
            while (rset.next()) {
                int PaymentID = rset.getInt(1);
                String UserID = rset.getString(2);
                String CaseName = rset.getString(3);
                int Numbers = rset.getInt(4);
                int Price = rset.getInt(5);
                String Address = rset.getString(6);
                String PhoneNumber = rset.getString(7);
                String CreditCardNumber = rset.getString(8);
                String CreditCardPassword = rset.getString(9);
                String status = rset.getString(10);
                String parcelNumber = rset.getString(11);
                String orderDate = rset.getString(12);
                String phoneType = rset.getString(13);
                String caseType = rset.getString(14);
                String color = rset.getString(15);
                payments.add(new Payment(PaymentID, UserID, CaseName, Numbers, Price, Address, 
                             PhoneNumber, CreditCardNumber, CreditCardPassword, status, parcelNumber, orderDate,
                             phoneType, caseType, color));
            }
            return payments;
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
    
    //결제한 항목에 대한 수량을 가져온다
    int getNumbers(int paymentID) throws SQLException {
        int numbers = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try {
            //String RETRIEVE_STMT= "SELECT * FROM shoppingPayment WHERE UserID = ?";
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(NUMBER_STMT);
            stmt.setInt(1, paymentID);
            rset = stmt.executeQuery();
            while (rset.next()) {
                numbers = rset.getInt(1);
            }
            return numbers;
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
    //색상을 가져온다
    String getColor(int paymentID) throws SQLException {
        String color =null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try {
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(COLOR_STMT);
            stmt.setInt(1, paymentID);
            rset = stmt.executeQuery();
            while (rset.next()) {
                color = rset.getString(1);
            }
            return color;
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
    //케이스 이름을 가져온다
    String getCaseName(int paymentID) throws SQLException {
        String caseName =null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try {
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(NAME_STMT);
            stmt.setInt(1, paymentID);
            rset = stmt.executeQuery();
            while (rset.next()) {
                caseName = rset.getString(1);
            }
            return caseName;
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
    //고객이 결제한 내용을 데이터베이스에 저장한다.
    void paymentAdd(String userID, String caseName, int numbers, int price, String address, String phoneNumber, 
                    String creditCardNumber, String creditcardPassword, String status, String parcelNumber, String s_date,
                    String phoneType, String caseType, String color) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try {
            //String GETID_STMT = "SELECT COUNT(PaymentID) FROM shoppingPayment";
            //String ADD_STMT = "INSERT INTO shoppingPayment VALUES(?,?,?,?,?,?,?,?,?)";
   
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(GETID_STMT);
            rset = stmt.executeQuery();
            int ID = -1;
            rset.next();
            ID = rset.getInt("MAX(PaymentID)");
            ID++;
            stmt = conn.prepareStatement(ADD_STMT);
            stmt.setInt(1, ID);
            stmt.setString(2, userID);
            stmt.setString(3, caseName);
            stmt.setInt(4, numbers);
            stmt.setInt(5, price);
            stmt.setString(6, address);
            stmt.setString(7, phoneNumber);
            stmt.setString(8, creditCardNumber);
            stmt.setString(9, creditcardPassword);
            stmt.setString(10,status);
            stmt.setString(11,parcelNumber);
            stmt.setString(12,s_date);
            stmt.setString(13, phoneType);
            stmt.setString(14, caseType);
            stmt.setString(15, color);
            
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
    //결제 내역을 삭제한다
     void paymentDelete(int paymentID) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try {
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(DELETE_STMT);
            stmt.setInt(1, paymentID);
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
     
     //결제 내용을 수정한다.
    void paymentUpdate(int paymentID, String parcelNumber) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        //UPDATE_STMT = "UPDATE shoppingPayment SET ParcelNumber = ? WHERE PaymentID = ?";
        try {
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(UPDATE_STMT);
            stmt.setString(1, parcelNumber);
            stmt.setString(2, "배송중");
            stmt.setInt(3, paymentID);
            
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