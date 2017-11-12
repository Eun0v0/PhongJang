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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

        RequestDispatcher view = null;
        UserService UserService = null;
        Status status = new Status();
        request.setAttribute("status", status);
        request.setCharacterEncoding("EUC-KR");
        try {
            String userID = request.getParameter("userID");
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            String phoneNumber = request.getParameter("phoneNumber");
            String address = request.getParameter("address");

            if ((userID == null) || (userID.length() == 0)) {
                status.addException(new Exception(
                        "Please enter your ID"));
            }
            if ((userName == null) || (userName.length() == 0)) {
                status.addException(new Exception(
                        "Please enter your name"));
            }
            if ((password == null) || (password.length() == 0)) {
                status.addException(new Exception(
                        "Please enter your password"));
            }
            if ((phoneNumber == null) || (phoneNumber.length() == 0)) {
                status.addException(new Exception(
                        "Please enter your phone number"));
            }
            if ((address == null) || (address.length() == 0)) {
                status.addException(new Exception(
                        "Please enter your address"));
            }

            try {

                UserService = new UserService();
                UserService.userCreate(userID,"C", userName, password, phoneNumber, address);

                if (!status.isSuccessful()) {
                    view = request.getRequestDispatcher("join.jsp");
                    view.forward(request, response);
                    return;
                }
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
