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
public class ProcessMyCaseServlet extends HttpServlet {
    public void doPost(HttpServletRequest request,
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
        
        String path = request.getRealPath("/image/myCase");
        PrintWriter out = response.getWriter();
        
        java.util.Calendar cal=java.util.Calendar.getInstance();
        
        String year =String.valueOf(cal.get(cal.YEAR));
        String month=String.valueOf(cal.get(cal.MONTH)+1);
        String date=String.valueOf(cal.get(cal.DATE));
        String s_date=year+"-"+month+"-"+date;	//date which user did slot machine
	
        MultipartRequest multi = new MultipartRequest(request, path, 1024 * 1024 * 5, "euc-kr",
                    new DefaultFileRenamePolicy());

        MyCaseService myCaseService = new MyCaseService();
        
        HttpSession HttpSession = request.getSession();
        User user = (User) HttpSession.getAttribute("user");
        ArrayList<MyCase> myCases = new ArrayList<MyCase>();
        
        String userID = user.getId();
        myCases = myCaseService.getAllMyCases(userID);
        request.setAttribute("myCases", myCases);
        request.setAttribute("user", user);
        
        try {
            String title = multi.getParameter("title");
            String caseType = multi.getParameter("caseType");
            String phoneType = multi.getParameter("phoneType");
            String color = multi.getParameter("color");
            String content = multi.getParameter("content");
            String image = multi.getFilesystemName("caseImage");
            
            if ((caseType == null) || (caseType.length() == 0)) {
                status.addException(new Exception(
                        "Please enter your producttype"));
            }
            if ((title == null) || (title.length() == 0)) {
                status.addException(new Exception(
                        "Please enter your productname"));
            }
            if ((phoneType == null) || (phoneType.length() == 0)) {
                status.addException(new Exception(
                        "Please enter your explanation"));
            }
             if ((color == null) || (color.length() == 0)) {
                status.addException(new Exception(
                        "Please enter your explanation"));
            }
             if ((content == null) || (content.length() == 0)) {
                status.addException(new Exception(
                        "Please enter your explanation"));
            }
            
            try {
                myCaseService.addMyCase(userID, title, caseType, phoneType, color, content, image, s_date);
                
                myCases = myCaseService.getAllMyCases(userID);
                request.setAttribute("myCases", myCases);
                if (!status.isSuccessful()) {
                    view = request.getRequestDispatcher("myCase.jsp");
                    view.forward(request, response);
                    return;
                }
                view = request.getRequestDispatcher("main.jsp");
                view.forward(request, response);
            } catch (Exception e) {
                status.addException(e);
                view = request.getRequestDispatcher("myCaseList.jsp");
                view.forward(request, response);
            }
        } catch (IllegalArgumentException e) {
            status.addException(e);
            view = request.getRequestDispatcher("myCase.jsp");
            view.forward(request, response);
        }
    }
}
