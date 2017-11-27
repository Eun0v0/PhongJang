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

public final class MyInfoServlet extends HttpServlet {

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
        
        User user = (User) HttpSession.getAttribute("user");
        String userID = user.getId();
        String userName = user.getName();
        String phoneNumber = user.getPhone();
        String address = user.getAddress();
        
        request.setCharacterEncoding("EUC-KR");
        request.setAttribute("user", user);
        request.setAttribute("userID", userID);
        request.setAttribute("userName", userName);
        request.setAttribute("phoneNumber", phoneNumber);
        request.setAttribute("address", address);
        
        view = request.getRequestDispatcher("myInfo.jsp");
        view.forward(request, response);
    }
}