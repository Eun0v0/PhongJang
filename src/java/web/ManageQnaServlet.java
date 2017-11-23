/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;
import domain.Qna;
import domain.QnaService;
import domain.UserService;
import domain.User;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ManageQnaServlet extends HttpServlet {

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
        HttpSession HttpSession=request.getSession();
        
        QnaService QnaService = null;
        ArrayList<Qna> qnas = null; 
        
        QnaService = new QnaService();     
        qnas = QnaService.getAllQna();
            
        request.setCharacterEncoding("EUC-KR");
        request.setAttribute("user", HttpSession.getAttribute("user"));
        request.setAttribute("qnas", qnas);
        
        //view = request.getRequestDispatcher("admin/managePhoneCase.jsp");
        view = request.getRequestDispatcher("qna.jsp");
        
        view.forward(request, response);
    }
}
