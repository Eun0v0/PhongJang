package web;

import domain.UserService;
import domain.User;
import domain.PhoneCase;
import domain.PhoneCaseService;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
import oracle.jdbc.pool.OracleDataSource;
import util.Status;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


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
        PhoneCaseService PhoneCaseService = null;
        
        Status status = new Status();
        request.setAttribute("status", status);
        
        String usertype = request.getParameter("usertype");
        String userID = request.getParameter("userID");
        String password = request.getParameter("password");

        if (usertype.equals("unknown")) {
            status.addException(new Exception(
                    "로그인 타입을 선택해주세요"));
        }
        if ((userID == null) || (userID.length() == 0)) {
            status.addException(new Exception(
                    "아이디를 입력해주세요"));
        }
        if ((password == null) || (password.length() == 0)) {
            status.addException(new Exception(
                    "비밀번호를 입력해주세요"));
        }

        User user = null;
        ArrayList<PhoneCase> phoneCases = null; 
        try {
            UserService = new UserService();
            user = UserService.getUser(usertype, userID, password);
            PhoneCaseService = new PhoneCaseService();
            phoneCases = PhoneCaseService.getAllPhoneCase();
            if (user == null) {
                status.addException(new Exception(
                        "Fill in forms correctly"));
            }
            if (phoneCases == null) {
                status.addException(new Exception(
                        "The product database error"));
            }
            if (!status.isSuccessful()) {
                view = request.getRequestDispatcher("login.jsp");
                view.forward(request, response);
                return;
            }
            request.setAttribute("user", user);
            request.setAttribute("phoneCases", phoneCases);
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
            view = request.getRequestDispatcher("phoneCaseList.jsp");
            //view = request.getRequestDispatcher("customerMain.jsp");
            view.forward(request, response);
        }
    }
}



