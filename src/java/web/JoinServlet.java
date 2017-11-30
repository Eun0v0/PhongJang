/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author yukih
 */
package web;

import domain.User;
import domain.UserService;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.Status;

public class JoinServlet extends HttpServlet {

    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    public void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {

        HttpSession HttpSession=request.getSession();
        
        RequestDispatcher view = null;
        UserService userService = new UserService();;
        Status status = new Status();
        User user = null;

        request.setAttribute("status", status);
        request.setAttribute("user", user);
       

        request.setCharacterEncoding("EUC-KR");
        try {
            String userID = request.getParameter("userID");
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            String phoneNumber = request.getParameter("phoneNumber");
            String address = request.getParameter("address");
            String findID = null;
            findID = userService.findID(userID);

            if ((userID == null) || (userID.length() == 0)) {
                status.addException(new Exception(
                        "아이디를 입력해주세요"));
            }
            if ((userName == null) || (userName.length() == 0)) {
                status.addException(new Exception(
                        "이름을 입력해주세요"));
            }
            if ((password == null) || (password.length() == 0)) {
                status.addException(new Exception(
                        "비밀번호를 입력해주세요"));
            }
            if ((phoneNumber == null) || (phoneNumber.length() == 0)) {
                status.addException(new Exception(
                        "핸드폰 번호를 입력해주세요"));
            }
            if ((address == null) || (address.length() == 0)) {
                status.addException(new Exception(
                        "주소를 입력해주세요"));
            }
            if (!findID.equals("X")) {
                status.addException(new Exception(
                        "이미 가입된 아이디 입니다"));
            }
            
            try {
                if (!userID.isEmpty() && !password.isEmpty() && !phoneNumber.isEmpty() && !address.isEmpty() && findID.isEmpty()) {
                    userService.userCreate(userID, "C", userName, password, phoneNumber, address);
                }
                if (!status.isSuccessful()) {
                    view = request.getRequestDispatcher("join.jsp");
                    view.forward(request, response);
                    return;
                }
                request.setAttribute("user", HttpSession.getAttribute("user"));
                view = request.getRequestDispatcher("joinConfirm.jsp");
                view.forward(request, response);

            } catch (Exception e) {
                status.addException(e);
                view = request.getRequestDispatcher("join.jsp");
                view.forward(request, response);
            }
        } catch (IllegalArgumentException e) {
            status.addException(e);
            view = request.getRequestDispatcher("join.jsp");
            view.forward(request, response);
        }
    }
}
