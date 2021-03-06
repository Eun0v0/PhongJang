/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import domain.Cart;
import domain.CartService;
import domain.CaseColor;
import domain.CaseColorService;
import domain.PhoneCase;
import domain.PhoneCaseService;
import domain.PhoneType;
import domain.PhoneTypeService;
import domain.Qna;
import domain.QnaReply;
import domain.QnaReplyService;
import domain.QnaService;
import domain.Review;
import domain.ReviewService;
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
 * QnA에 답글 달기 서블릿
*/
public class QnaReplyServlet extends HttpServlet {

    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    public void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        RequestDispatcher view = null;

        HttpSession HttpSession = request.getSession();

        QnaReplyService qnaReplyService = new QnaReplyService();
        Status status = new Status();
        response.setContentType("text/html; charset=euc-kr");
        request.setAttribute("status", status);
        request.setCharacterEncoding("EUC-KR");
        
        int qnaNum = Integer.parseInt(request.getParameter("qnaNum"));
        String userID = request.getParameter("userID");
        String content = request.getParameter("content");
        
        java.util.Calendar cal=java.util.Calendar.getInstance();
        
        String year =String.valueOf(cal.get(cal.YEAR));
        String month=String.valueOf(cal.get(cal.MONTH)+1);
        String date=String.valueOf(cal.get(cal.DATE));
        String writeDate=year+"-"+month+"-"+date;//답글 작성 날짜 작성
      
        if (content.isEmpty()) {
            status.addException(new Exception("내용을 입력해주세요"));
        }
        
        //공란이 없을때 답글 작성
        if(!content.isEmpty()){
            qnaReplyService.addQnaReply(qnaNum, userID, content, writeDate);
        }
        
        ArrayList<QnaReply> qnaReplys = null;
        qnaReplys = qnaReplyService.getAllReply(qnaNum);
        request.setAttribute("qnaReplys", qnaReplys);

        request.setAttribute("user", HttpSession.getAttribute("user"));
        
        String userType = ((User) HttpSession.getAttribute("user")).getUsertype();    
        
        QnaService qnaService = new QnaService();
        Qna qna = qnaService.getQnaInfo(qnaNum);
        
        request.setAttribute("qna", qna);
        
        if(userType.equals("C")){
            view = request.getRequestDispatcher("qnaView.jsp"); //c7stomer 전용
            view.forward(request, response);
        } else {
            view = request.getRequestDispatcher("admin/qnaView.jsp");
            view.forward(request, response);
        }
        
    }
}
