/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

/**
 *
 * @author Hayoung_2
 */
public final class SearchPwdServlet extends HttpServlet {
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    //검색 함수?
    public void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        RequestDispatcher view = null;
        UserService userService = new UserService();
        request.setCharacterEncoding("EUC-KR");
        HttpSession HttpSession=request.getSession();
        User user = (User) HttpSession.getAttribute("user");
        
        String userID = request.getParameter("userID");
        String PhoneNum = request.getParameter("PhoneNum");
        
        user = userService.getSearchPwd(userID,PhoneNum);
        String userPwd = user.getPw();
        //request.setAttribute("user", user);
        request.setAttribute("userPwd", userPwd);
        view = request.getRequestDispatcher("searchPwdList.jsp");
        view.forward(request, response);
    }
}