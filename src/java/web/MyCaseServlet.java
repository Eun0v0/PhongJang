package web;

import domain.PhoneCase;
import domain.PhoneCaseService;
import domain.UserService;
import domain.User;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public final class MyCaseServlet extends HttpServlet {

    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    public void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        RequestDispatcher view = null;
        HttpSession HttpSession=request.getSession();
        
        request.setCharacterEncoding("EUC-KR");
        request.setAttribute("user", HttpSession.getAttribute("user"));
 
        view = request.getRequestDispatcher("myCase.jsp"); //c7stomer 전용
        view.forward(request, response);
        
    }
}