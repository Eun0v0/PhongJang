/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

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

        int qnaNum = Integer.parseInt(request.getParameter("qnaNum"));
        ArrayList<Qna> qnas = null;
        qnaService.deleteQna(qnaNum); //해당 QnA 삭제

        qnas = qnaService.getAllQna();

        request.setCharacterEncoding("EUC-KR");
        request.setAttribute("user", user);
        request.setAttribute("qnas", qnas);

        view = request.getRequestDispatcher("qna.jsp");
        view.forward(request, response);
    }
}
