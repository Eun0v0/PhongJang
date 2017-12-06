package web;


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
/**
 * 회원가입 세션 처리를 위한 서블릿
*/
public final class IDCheckServlet extends HttpServlet {

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
        
        UserService UserService = null;
        ArrayList<User> users = null; 
        
        UserService = new UserService();     
        users = UserService.getAllUser();
            
        request.setCharacterEncoding("EUC-KR");
        request.setAttribute("users", users);
        request.setAttribute("user", HttpSession.getAttribute("user"));
                
        view = request.getRequestDispatcher("join.jsp");
        view.forward(request, response);
        
        
    }
}