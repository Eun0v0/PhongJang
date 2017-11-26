/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

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

public class UpdateQnaServlet extends HttpServlet {

    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    public void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        RequestDispatcher view = null;
        QnaService qnaService = null;
        HttpSession HttpSession = request.getSession();

        response.setContentType("text/html; charset=euc-kr");
        request.setCharacterEncoding("EUC-KR");

        int qnaNum = Integer.parseInt(request.getParameter("qnaNum"));
        ArrayList<Qna> qnas = null;
        qnaService = new QnaService();
        qnas = qnaService.getAllQna();
        
       /* request.setAttribute("", caseID);
        request.setAttribute("caseName", caseName);
        request.setAttribute("caseType", caseType);
        request.setAttribute("explanation", explanation);
        request.setAttribute("price", price);
        request.setAttribute("img", img);
        request.setAttribute("detailImg", detailImg);

        request.setAttribute("user", HttpSession.getAttribute("user"));
        request.setAttribute("qnas, HttpSession.getAttribute("qnas
        "));
        
        view = request.getRequestDispatcher("qnaUpdate.jsp");
        view.forward(request, response);*/
    }
}
