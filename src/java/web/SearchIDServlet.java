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
public final class SearchIDServlet extends HttpServlet {
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
        
        String userName = request.getParameter("userName");
        String PhoneNum = request.getParameter("PhoneNum");
        
        user = userService.getSearchID(userName,PhoneNum);
        String userID = user.getId();
        request.setAttribute("user", user);
        request.setAttribute("userID", userID);
        view = request.getRequestDispatcher("searchIDList.jsp");
        view.forward(request, response);
    }
}
/*

//이거 이름하고 현재 java파일하고 이름이 같아야 함
public final class SearchPhoneCaseServlet extends HttpServlet {
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
        PhoneCaseService phoneCaseService = null;
        request.setCharacterEncoding("EUC-KR");
        String phoneCaseName = request.getParameter("caseName");
        HttpSession HttpSession=request.getSession();
        
        
        ArrayList<PhoneCase> cases = null;
        phoneCaseService = new PhoneCaseService();
        cases = phoneCaseService.getPhoneCase(phoneCaseName);
        request.setAttribute("phoneCases", cases);
        request.setAttribute("user", HttpSession.getAttribute("user"));
        view = request.getRequestDispatcher("phoneCaseList.jsp");
        //view = request.getRequestDispatcher("main.jsp"); //c7stomer 전용
        view.forward(request, response);
    }
}
*/