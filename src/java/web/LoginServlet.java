package web;

import domain.UserService;
import domain.User;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
import oracle.jdbc.pool.OracleDataSource;
import util.Status;

public final class LoginServlet extends HttpServlet {

    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    public void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        RequestDispatcher view = null;
        UserService UserService = null;
        Status status = new Status();
        request.setAttribute("status", status);

        String usertype = request.getParameter("usertype");
        String userID = request.getParameter("userID");
        String password = request.getParameter("password");

        if (usertype.equals("unknown")) {
            status.addException(new Exception(
                    "Select login type"));
        }
        if ((userID == null) || (userID.length() == 0)) {
            status.addException(new Exception(
                    "Type ID"));
        }
        if ((password == null) || (password.length() == 0)) {
            status.addException(new Exception(
                    "Type password"));
        }

        User user = null;

        try {
            UserService = new UserService();
            user = UserService.getUser(usertype, userID, password);

            if (user == null) {
                status.addException(new Exception(
                        "Fill in forms correctly"));
            }

            if (!status.isSuccessful()) {
                view = request.getRequestDispatcher("login.jsp");
                view.forward(request, response);
                return;
            }

            request.setAttribute("user", user);

        } catch (Exception e) {
            status.addException(e);
            view = request.getRequestDispatcher("main.jsp");
            view.forward(request, response);
        }

        if (usertype.equals("A")) { //관리자 모드
            view = request.getRequestDispatcher("admin/adminLoginConfirm.jsp");
            view.forward(request, response);
        }

        if (usertype.equals("C")) { //고객 모드
            view = request.getRequestDispatcher("loginConfirm.jsp");
            view.forward(request, response);
        }
    }
}



