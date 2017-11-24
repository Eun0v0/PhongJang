/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;
import java.util.ArrayList;
public class PaymentService {   
    private PaymentDAO paymentDataAccess;    
    public PaymentService() {
        paymentDataAccess = new PaymentDAO();
    }
    public ArrayList<Payment> getAllPayment() {
        ArrayList<Payment> payments = null;
        try {
            payments = paymentDataAccess.allpaymentRetrieve();
        } catch (Exception e) {
            payments = null;
        }
        return payments;
    }
    
    public ArrayList<Payment> getAllPayment(String userid) {
        ArrayList<Payment> payments = null;
        try {
            payments = paymentDataAccess.paymentRetrieve(userid);
        } catch (Exception e) {
            payments = null;
        }
        return payments;
    }
    
    public void paymentAdd(String userid, String caseName, int numbers, int price, String address, String phoneNumber, 
            String creditcardNumber, String creditcardPassword, String status, String parcelNumber, String s_date,
            String phoneType, String caseType, String color) {
        paymentDataAccess.paymentAdd(userid, caseName, numbers, price, address, phoneNumber, 
                creditcardNumber, creditcardPassword, status, parcelNumber, s_date,
                phoneType, caseType, color);
    }
    
    public void paymentDelete(int paymentID) {
        paymentDataAccess.paymentDelete(paymentID);
    }
    
    public void paymentUpdate(int paymentID, String parcelNumber) {
        paymentDataAccess.paymentUpdate(paymentID, parcelNumber);
    }
}