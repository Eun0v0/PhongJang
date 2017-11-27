/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import domain.CaseColorService;
import domain.MyCase;
import domain.MyCaseService;
import domain.PhoneCase;
import domain.PhoneCaseService;
import domain.PhoneTypeService;
import domain.ReplyMyCase;
import domain.ReplyMyCaseService;
import domain.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.Status;

/**
 *
 * @author yukih
 */
public class ModifyMyCaseServlet extends HttpServlet {

    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }
     public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    public void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        RequestDispatcher view = null;
        Status status = new Status();
        response.setContentType("text/html; charset=euc-kr");
        request.setCharacterEncoding("EUC-KR");
        request.setAttribute("status", status);
        MyCaseService myCaseService = new MyCaseService();

        HttpSession HttpSession = request.getSession();
        User user = (User) HttpSession.getAttribute("user");
        MyCase myCase = null;
        ReplyMyCase replyMyCase;
        ReplyMyCaseService replyMyCaseService = new ReplyMyCaseService();
        
        String userID = user.getId();
        int myCaseNum = Integer.parseInt(request.getParameter("myCaseNum"));
        myCase = myCaseService.getMyCase(myCaseNum);
        replyMyCase = replyMyCaseService.getMyCase(myCaseNum);
        
        request.setAttribute("myCase", myCase);
        request.setAttribute("user", user);

        String userType = ((User) HttpSession.getAttribute("user")).getUsertype();    
        request.setAttribute("replyMyCase",replyMyCase);

        if(userType.equals("C")){
            view = request.getRequestDispatcher("modifyMyCase.jsp"); //c7stomer 전용
            view.forward(request, response);
        } else {
            view = request.getRequestDispatcher("admin/replyMyCase.jsp");
            view.forward(request, response);
        }
    }
}
