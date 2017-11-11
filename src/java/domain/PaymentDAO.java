package domain;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.DBConnectionPool;
public class PaymentDAO {
    private DBConnectionPool connPool;
    private static final String ALLRETRIEVE_STMT
            = "SELECT * FROM shoppingPayment";
    private static final String RETRIEVE_STMT
            = "SELECT * FROM shoppingPayment WHERE UserID = ?";
    private static final String GETID_STMT = "SELECT COUNT(PaymentID) FROM shoppingPayment";
    private static final String ADD_STMT = "INSERT INTO shoppingPayment VALUES(?,?,?,?,?,?,?,?,?)";
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
                payments.add(new Payment(PaymentID, UserID, CaseName, Numbers, Price, Address, PhoneNumber, CreditCardNumber, CreditCardPassword));
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
                String Contact = rset.getString(7);
                String CreditCardNumber = rset.getString(8);
                String CreditCardPassword = rset.getString(9);
                payments.add(new Payment(PaymentID, UserID, CaseName, Numbers, Price, Address, Contact, CreditCardNumber, CreditCardPassword));
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
    
    void paymentAdd(String userID, String caseName, int numbers, int price, String address, String phoneNumber, String creditCardNumber, String creditcardPassword) {
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
            ID = rset.getInt("COUNT(PaymentID)");
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