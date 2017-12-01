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
/**
 * 결제한 모든 내역을 보여줌
*/
public final class RetrievePaymentServlet extends HttpServlet {
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }
    public void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        RequestDispatcher view = null;
        HttpSession HttpSession = request.getSession();
        String userID = ((User) HttpSession.getAttribute("user")).getId();
        String userType = ((User) HttpSession.getAttribute("user")).getUsertype();
        ArrayList<Payment> payments = null;
        PaymentService PaymentService = new PaymentService();
        
        if(userType.equals("C")){
            payments = PaymentService.getAllPayment(userID); // 고객은 본인이 결제한 목록만을 가져옴
        } else {
            payments = PaymentService.getAllPayment(); //관리자 모드에서는 모든 결제 내역을 가져옴
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