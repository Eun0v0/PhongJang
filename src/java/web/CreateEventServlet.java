/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 이벤트 작성을 위한 페이지로 넘어가기 위한 서블릿
*/
public class CreateEventServlet extends HttpServlet {
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
        request.setAttribute("user", HttpSession.getAttribute("user"));
        view = request.getRequestDispatcher("admin/eventWrite.jsp");
        //view = request.getRequestDispatcher("admin/detailPage.jsp");
        view.forward(request, response);
    }
}