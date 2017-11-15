/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;
import domain.Cart;
import domain.CartService;
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
public class ProcessPaymentServlet extends HttpServlet {
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
        
        ArrayList<Cart> carts = (ArrayList<Cart>) HttpSession.getAttribute("carts");
        User user = (User) HttpSession.getAttribute("user");
        String userID = user.getId();
        String address = user.getAddress();
        String phoneNumber = user.getPhone();
        String creditcardNumber = request.getParameter("creditcardNumber");
        String creditcardPassword = request.getParameter("creditcardPassword");
        String status = "배송 준비중";
        String parcelNumber = "준비중";
        ArrayList<PhoneCase> phonecases = null;
        PhoneCaseService PhoneCaseService = new PhoneCaseService();
        phonecases = PhoneCaseService.getAllPhoneCase();
        request.setAttribute("phoncases", phonecases);
        request.setAttribute("user", HttpSession.getAttribute("user"));
        PaymentService PaymentService = new PaymentService();
        for (int i = 0; i < carts.size(); i++) {
            PaymentService.paymentAdd(userID, carts.get(i).getCaseName(), carts.get(i).getNumbers(),carts.get(i).getPrice(), address, phoneNumber, creditcardNumber, creditcardPassword, status, parcelNumber);
            int cartID = carts.get(i).getCartID();
            CartService CartService = new CartService();
            CartService.cleanCart(userID, cartID);
        }
        
        
        view = request.getRequestDispatcher("paymentConfirm.jsp");
        view.forward(request, response);
    }
}
