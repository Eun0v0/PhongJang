/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import domain.UserService;
import domain.User;
import domain.Qna;
import domain.QnaService;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher; 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.Status;

public class UpdateQnaServlet extends HttpServlet {

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
        HttpSession HttpSession = request.getSession();
        Status status = new Status();
        request.setAttribute("status", status);

        Qna qna = (Qna) HttpSession.getAttribute("qna");
        Qna qnaSave = null;
        QnaService qnaService = new QnaService();

        int qnaNum = qna.getQnaNum();
        request.setCharacterEncoding("EUC-KR");
        String qnaTitle = request.getParameter("qnaTitle");
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        String qnaContent = request.getParameter("qnaContent");

        try {
            if ((qnaTitle == null) || (qnaTitle.length() == 0)) {
                status.addException(new Exception(
                        "Please enter your qnaTItle"));
            }
            if ((userName == null) || (userName.length() == 0)) {
                status.addException(new Exception(
                        "Please enter your userName"));
            }
            if ((passWord == null) || (passWord.length() == 0)) {
                status.addException(new Exception(
                        "Please enter your Password"));
            }
            if ((qnaContent == null) || (qnaContent.length() == 0)) {
                status.addException(new Exception(
                        "Please enter your Content"));
            }

            try {

                qnaService.updateQna(userName, passWord, qnaTitle, qnaContent);
                qnaSave = qnaService.getQnaInfo(qnaNum);

                request.setCharacterEncoding("EUC-KR");
                request.setAttribute("qna", qnaSave);
                request.setAttribute("qnaNum", qnaNum);
                request.setAttribute("userName", userName);
                request.setAttribute("Password", passWord);
                request.setAttribute("qnaContent", qnaContent);

                if (!status.isSuccessful()) {
                    view = request.getRequestDispatcher("qnaUpdate.jsp");
                    view.forward(request, response);
                    return;
                }
                view = request.getRequestDispatcher("qna.jsp");
                view.forward(request, response);
            } catch (Exception e) {
                status.addException(e);
                view = request.getRequestDispatcher("qnaUpdate.jsp");
                view.forward(request, response);
            }
        } catch (IllegalArgumentException e) {
            status.addException(e);
            view = request.getRequestDispatcher("qnaUpdate.jsp");
            view.forward(request, response);
        }
    }
}
