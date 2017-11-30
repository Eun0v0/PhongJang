/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import domain.User;
import domain.Qna;
import domain.QnaReply;
import domain.QnaReplyService;
import domain.QnaService;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class RetrieveQnaServlet extends HttpServlet {
     /*public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }*/
     public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }
     public void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        RequestDispatcher view = null;
        QnaService qnaService = null;
        HttpSession HttpSession=request.getSession();
        int qnaNum = Integer.parseInt(request.getParameter("qnaNum"));
        Qna qna = null;
        qnaService = new QnaService();
        qna = qnaService.getQnaInfo(qnaNum);
        request.setAttribute("user", HttpSession.getAttribute("user"));
        request.setAttribute("qna", qna);
        
        QnaReplyService qnaReplyService = new QnaReplyService();
        
        ArrayList<QnaReply> qnaReplys = null;
        qnaReplys = qnaReplyService.getAllReply(qnaNum);
        request.setAttribute("qnaReplys", qnaReplys);

        
        String userType = ((User) HttpSession.getAttribute("user")).getUsertype();    
        
        if(userType.equals("C")){
            view = request.getRequestDispatcher("qnaView.jsp"); //c7stomer 전용
            view.forward(request, response);
        } else {
            view = request.getRequestDispatcher("admin/qnaView.jsp");
            view.forward(request, response);
        }
    }
}
