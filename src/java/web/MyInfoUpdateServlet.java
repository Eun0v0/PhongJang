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
import util.Status;

public final class MyInfoUpdateServlet extends HttpServlet {

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
        Status status = new Status();
        request.setAttribute("status", status);
        
        User user = (User) HttpSession.getAttribute("user");
        UserService UserSerice = new UserService();
                
        String userID = user.getId();
        request.setCharacterEncoding("EUC-KR");
        String userName = request.getParameter("userName");
        String phoneNumber = request.getParameter("phoneNumber");
        String address = request.getParameter("address");
        
        try {
            if ((userID == null) || (userID.length() == 0)) {
                status.addException(new Exception(
                        "Please enter your userID"));
            }
            if ((userName == null) || (userName.length() == 0)) {
                status.addException(new Exception(
                        "Please enter your userName"));
            }
            if ((phoneNumber == null) || (phoneNumber.length() == 0)) {
                status.addException(new Exception(
                        "Please enter your phoneNumber"));
            }
            if ((address == null) || (address.length() == 0)) {
                status.addException(new Exception(
                        "Please enter your address"));
            }
            
            try {
                //(int caseID, String caseType, String caseName, String explanation, int price)
                UserSerice.userUpdate(userID, userName, phoneNumber, address);
                
                request.setCharacterEncoding("EUC-KR");
                request.setAttribute("user", user);
                request.setAttribute("userID", userID);
                request.setAttribute("userName", userName);
                request.setAttribute("phoneNumber", phoneNumber);
                request.setAttribute("address", address);
        
                
                if (!status.isSuccessful()) {
                    view = request.getRequestDispatcher("myInfo.jsp");
                    view.forward(request, response);
                    return;
                }
                view = request.getRequestDispatcher("myInfo.jsp");
                view.forward(request, response);
            } catch (Exception e) {
                status.addException(e);
                view = request.getRequestDispatcher("myInfo.jsp");
                view.forward(request, response);
            }
        } catch (IllegalArgumentException e) {
            status.addException(e);
            view = request.getRequestDispatcher("myInfo.jsp");
            view.forward(request, response);
        }
    }
}