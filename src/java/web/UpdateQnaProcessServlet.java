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
 * QnA 등록 서블릿
*/
public class UpdateQnaProcessServlet extends HttpServlet {

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
        request.setCharacterEncoding("EUC-KR");
        response.setContentType("text/html; charset=euc-kr");
        
        Status status = new Status();
        request.setAttribute("status", status);

        User user = (User)  HttpSession.getAttribute("user");
        Qna qna = (Qna) HttpSession.getAttribute("qna");
        Qna qnaSave = null;
        QnaService qnaService = new QnaService();

        int qnaNum = qna.getQnaNum();
        String passwordCheck = qna.getPassWord();
        
        String userName = qna.getUserName();
        String qnaTitle = request.getParameter("qnaTitle");
        String passWord = request.getParameter("passWord");
        String qnaContent = request.getParameter("qnaContent");

        PrintWriter out = response.getWriter();
        try {
            if (user == null) {
                status.addException(new Exception(
                        "회원 본인만 수정할 수 있습니다"));
            }
            if ((qnaTitle == null) || (qnaTitle.length() == 0)) {
                status.addException(new Exception(
                        "제목을 입력해주세요"));
            }

            if ((passWord == null) || (passWord.length() == 0)) {
                status.addException(new Exception(
                        "비밀번호를 입력해주세요"));
            }
            if ((qnaContent == null) || (qnaContent.length() == 0)) {
                status.addException(new Exception(
                        "내용을 입력해주세요"));
            }
            if (!passwordCheck.equals(passWord)) {
                status.addException(new Exception(
                        "비밀번호가 틀렸습니다!"));
            }

            try {
                if (passwordCheck.equals(passWord) && user != null) {
                    qnaService.updateQna(qnaNum, userName, qnaTitle, qnaContent);
                }
                    qnaSave = qnaService.getQnaInfo(qnaNum);
                    
                    request.setCharacterEncoding("EUC-KR");
                    request.setAttribute("qna", qnaSave);
                    request.setAttribute("qnaNum", qnaNum);
                    request.setAttribute("userName", userName);
                    request.setAttribute("Password", passwordCheck);
                    request.setAttribute("qnaContent", qnaContent);
                    request.setAttribute("user", user);

                    if (!status.isSuccessful()) {
                        view = request.getRequestDispatcher("qnaUpdate.jsp");
                        view.forward(request, response);
                        return;
                    }
                    view = request.getRequestDispatcher("qnaView.jsp");
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
