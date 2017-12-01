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
/**
 * 내정보 수정 서블릿
*/
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
        User userSave = null;
        UserService userSerice = new UserService();
                
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

                userSerice.userUpdate(userID, userName, phoneNumber, address);//정보 수정
                userSave = userSerice.getUserInfo(userID);

                request.setCharacterEncoding("EUC-KR");
                request.setAttribute("user", userSave);
                request.setAttribute("userID", userID);
                request.setAttribute("userName", userName);
                request.setAttribute("phoneNumber", phoneNumber);
                request.setAttribute("address", address);
        
                
                if (!status.isSuccessful()) {
                    view = request.getRequestDispatcher("myInfo.jsp");
                    view.forward(request, response);
                    return;
                }
                view = request.getRequestDispatcher("myPage.jsp");
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