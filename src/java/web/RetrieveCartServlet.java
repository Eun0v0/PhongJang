/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;
import domain.Cart;
import domain.CartService;
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
 * 장바구니의 모든 내용을 보여줌
*/
public final class RetrieveCartServlet extends HttpServlet {
     public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    public void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        RequestDispatcher view = null;
        CartService CartService = null;
        HttpSession HttpSession=request.getSession();
        String userID = request.getParameter("userID");
        ArrayList<Cart> carts = null;
        CartService = new CartService();
        carts = CartService.getCart(userID);
        request.setAttribute("user", HttpSession.getAttribute("user"));
        request.setAttribute("carts", carts);
        view = request.getRequestDispatcher("cart.jsp"); //c7stomer 전용
        view.forward(request, response);
    }
}
