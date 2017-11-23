/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import domain.Qna;
import domain.QnaService;
import domain.User;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import util.Status;

public class ProcessQnaServlet extends HttpServlet {

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

        java.util.Calendar cal = java.util.Calendar.getInstance();

        String year = String.valueOf(cal.get(cal.YEAR));
        String month = String.valueOf(cal.get(cal.MONTH) + 1);
        String date = String.valueOf(cal.get(cal.DATE));
        String s_date = year + "-" + month + "-" + date;	//date which user did slot machine

        QnaService qnaService = new QnaService();
        HttpSession HttpSession = request.getSession();
        //User user = (User) HttpSession.getAttribute("user");
        ArrayList<Qna> qnas = new ArrayList<Qna>();
        qnas = qnaService.getAllQna();
        request.setAttribute("qnas", qnas);
        //request.setAttribute("user", user);

        try {
            String userName = request.getParameter("userName");
            String passWord = request.getParameter("passWord");
            String qnaTitle = request.getParameter("qnaTitle");
            String qnaContent = request.getParameter("qnaContent");
            //String qnaTime = request.getParameter("qnaTime");

            if ((userName == null) || (userName.length() == 0)) {
                status.addException(new Exception(
                        "Please enter your passWord"));
            }
            if ((passWord == null) || (passWord.length() == 0)) {
                status.addException(new Exception(
                        "Please enter your passWord"));
            }
            if ((qnaTitle == null) || (qnaTitle.length() == 0)) {
                status.addException(new Exception(
                        "Please enter your qnaTitle"));
            }
            if ((qnaContent == null) || (qnaContent.length() == 0)) {
                status.addException(new Exception(
                        "Please enter your qnaContent"));
            }

            try {
                if((userName !=null) && (passWord != null) && (qnaTitle != null) && (qnaContent != null)){
                    qnaService.insertQna(userName, passWord, qnaTitle, qnaContent, s_date);
                }
                //PhoneCaseService.insertPhoneCase(caseType, caseName, explanation, price, imgPath);

                qnas = qnaService.getAllQna();
                request.setAttribute("qnas", qnas);
                if (!status.isSuccessful()) {
                    view = request.getRequestDispatcher("qnaCreate.jsp");
                    view.forward(request, response);
                    return;
                }
                view = request.getRequestDispatcher("qna.jsp");
                view.forward(request, response);
            } catch (Exception e) {
                status.addException(e);
                view = request.getRequestDispatcher("qnaCreate.jsp");
                view.forward(request, response);
            }
        } catch (IllegalArgumentException e) {
            status.addException(e);
            view = request.getRequestDispatcher("admin/create.jsp");
            view.forward(request, response);
        }    
    }
}
