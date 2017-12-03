/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import domain.Qna;
import domain.QnaReply;
import domain.QnaReplyService;
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
import util.Status;

/**
 * QnA 게시글 삭제
 */
public class DeleteQnaServlet extends HttpServlet {

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
        request.setAttribute("status", status);
        QnaService qnaService = new QnaService();
        HttpSession HttpSession = request.getSession();
        User user = (User) HttpSession.getAttribute("user");

        Qna qna = (Qna) HttpSession.getAttribute("qna");
        int qnaNum = Integer.parseInt(request.getParameter("qnaNum"));
        String password = request.getParameter("password");
        String passwordCheck = qna.getPassWord();
        ArrayList<Qna> qnas = null;

        try {
            if(user == null){
                status.addException(new Exception(
                        "회원 본인만 삭제할 수 있습니다."));
            }
            if ((password == null) || (password.length() == 0)) {
                status.addException(new Exception(
                        "비밀번호를 입력해주세요"));
            }
            if (!passwordCheck.equals(password)) {
                status.addException(new Exception(
                        "비밀번호가 틀렸습니다!"));
            }

            try {
                if (passwordCheck.equals(password) && user!=null) {
                    qnaService.deleteQna(qnaNum, password); //해당 QnA 삭제
                }
                qnas = qnaService.getAllQna();

                request.setCharacterEncoding("EUC-KR");
                request.setAttribute("user", HttpSession.getAttribute("user"));
                request.setAttribute("qna", qna);
                request.setAttribute("user", user);
                request.setAttribute("qnas", qnas);

                QnaReplyService qnaReplyService = new QnaReplyService();
        
                ArrayList<QnaReply> qnaReplys = null;
                qnaReplys = qnaReplyService.getAllReply(qnaNum); //해당 QnA의 모든 답글을 가져옴
                request.setAttribute("qnaReplys", qnaReplys);

                if (!status.isSuccessful()) {
                    view = request.getRequestDispatcher("qnaView.jsp");
                    view.forward(request, response);
                    return;
                }
                view = request.getRequestDispatcher("qna.jsp");
                view.forward(request, response);

            } catch (Exception e) {
                status.addException(e);
                view = request.getRequestDispatcher("qnaView.jsp");
                view.forward(request, response);
            }
        } catch (IllegalArgumentException e) {
            status.addException(e);
            view = request.getRequestDispatcher("qnaView.jsp");
            view.forward(request, response);
        }
    }
}
