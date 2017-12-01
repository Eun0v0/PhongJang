/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;
import domain.Cart;
import domain.CartService;
import domain.Payment;
import domain.PaymentService;
import domain.PhoneCase;
import domain.PhoneCaseService;
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
 * 결제 상태 수정
*/
public class UpdatePaymentServlet extends HttpServlet {
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
        
        request.setCharacterEncoding("EUC-KR");
        
        User user = (User) HttpSession.getAttribute("user");
        Payment payment = (Payment)HttpSession.getAttribute("payment");
        PaymentService paymentService = new PaymentService();
        
        int paymentID = payment.getPaymentID();
        String parcelNumber = request.getParameter("parcelNumber"); //송장 번호 받아오기
        paymentService.paymentUpdate(paymentID, parcelNumber); //송장번호 업데이트
        
        ArrayList<Payment> payments = null;
        PaymentService PaymentService = new PaymentService();
        payments = PaymentService.getAllPayment();
        request.setAttribute("payments", payments);
        request.setAttribute("user", HttpSession.getAttribute("user"));
        request.setAttribute("phoneCases", HttpSession.getAttribute("phoneCases"));

        view = request.getRequestDispatcher("admin/payment.jsp");
        view.forward(request, response);
    }
}
