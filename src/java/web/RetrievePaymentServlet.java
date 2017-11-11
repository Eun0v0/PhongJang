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
        ArrayList<Payment> payments = null;
        PaymentService PaymentService = new PaymentService();
        payments = PaymentService.getAllPayment(userID);
        request.setAttribute("user", HttpSession.getAttribute("user"));
        request.setAttribute("payments", payments);
        view = request.getRequestDispatcher("payment.jsp");
        view.forward(request, response);
    }
} 