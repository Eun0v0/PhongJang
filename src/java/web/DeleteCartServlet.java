/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;
import domain.Cart;
import domain.CartService;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 장바구니에서 상품 삭제
*/
public class DeleteCartServlet extends HttpServlet {
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    public void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        RequestDispatcher view = null;
        CartService CartService = new CartService();  
        HttpSession HttpSession=request.getSession();
        String userID = request.getParameter("userID");
        int cartID = Integer.parseInt(request.getParameter("cartID"));
        
        ArrayList<Cart> carts = null;
        CartService.deleteFromCart(userID, cartID); // 장바구니에서 해당 상품 삭제
        carts = CartService.getCart(userID); //장바구니 내역 다시 조회
        request.setAttribute("carts", carts);
        request.setAttribute("user", HttpSession.getAttribute("user"));
        
        view = request.getRequestDispatcher("cart.jsp"); //c7stomer 전용
        view.forward(request, response);
    }
}
