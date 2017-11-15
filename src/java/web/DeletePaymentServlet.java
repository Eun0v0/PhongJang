/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;
import domain.Payment;
import domain.PaymentService;
import domain.User;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.Status;
/*
    관리자모드 - 상품 삭제
*/
public class DeletePaymentServlet extends HttpServlet {
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }
    public void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        RequestDispatcher view = null;
        Status status = new Status();
        request.setAttribute("status", status);
        PaymentService paymentService = new PaymentService();
        HttpSession HttpSession = request.getSession();
        User user = (User) HttpSession.getAttribute("user");
        
        String userID = ((User) HttpSession.getAttribute("user")).getId();
        String userType = ((User) HttpSession.getAttribute("user")).getUsertype();
        ArrayList<Payment> payments = null;
        Payment payment = (Payment) request.getAttribute("payment");
        
        paymentService.paymentDelete(payment.getPaymentID());
       
        if(userType.equals("C")){
            payments = paymentService.getAllPayment(userID);
        } else {
            payments = paymentService.getAllPayment();
        }
        request.setAttribute("user", HttpSession.getAttribute("user"));
        request.setAttribute("payments", payments);
        
        if(userType.equals("C")){
            view = request.getRequestDispatcher("payment.jsp");
            view.forward(request, response);
        } else {
            view = request.getRequestDispatcher("admin/payment.jsp");
            view.forward(request, response);
        } 
    }
}