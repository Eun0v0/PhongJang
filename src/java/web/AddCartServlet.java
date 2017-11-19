/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;
import domain.Cart;
import domain.CartService;
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
import util.Status;
public class AddCartServlet extends HttpServlet {
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    public void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        RequestDispatcher view = null;
        CartService cartService = new CartService();
        PhoneCaseService phoneCaseService = new PhoneCaseService();
        Status status = new Status();
        request.setAttribute("status", status);
        
        request.setCharacterEncoding("EUC-KR");
        
        HttpSession HttpSession=request.getSession();
        String userID = request.getParameter("userID");
        String caseName = request.getParameter("caseName");
        String color = "투명";
        int numbers = Integer.parseInt(request.getParameter("numbers"));
        int price = Integer.parseInt(request.getParameter("price"));
        
        if(request.getParameter("numbers")==null){
            status.addException(new Exception("제품 개수를 입력해주세요"));
        }
        if(numbers==0){
            status.addException(new Exception("제품 개수를 입력해주세요"));    
        }
        
        ArrayList<PhoneCase> cases = null;
        phoneCaseService = new PhoneCaseService();
        cases = phoneCaseService.getAllPhoneCase();
        request.setAttribute("phoneCases", cases);
        request.setAttribute("user", HttpSession.getAttribute("user"));
       
        
        try{
            cartService = new CartService();
            cartService.addToCart(userID, caseName, color, numbers, price);
            
            ArrayList<Cart> carts = null;
            carts = cartService.getCart(userID);
        
        
            if(!status.isSuccessful()){
                view = request.getRequestDispatcher("phoneCaseList.jsp"); //c7stomer 전용
                view.forward(request, response);
                return;
            }
        
            request.setAttribute("user", HttpSession.getAttribute("user"));
            request.setAttribute("carts", carts);
        
            view = request.getRequestDispatcher("cart.jsp"); //c7stomer 전용
            view.forward(request, response);
        } catch (Exception e){
            status.addException(e);
            view = request.getRequestDispatcher("phoneCaseList.jsp"); //c7stomer 전용
            view.forward(request, response); 
        }
    }
}
