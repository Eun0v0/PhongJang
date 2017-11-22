/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;
import domain.User;
import domain.Qna;
import domain.QnaService;
import java.util.ArrayList;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CreateQnaServlet extends HttpServlet {
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
        request.setAttribute("user", HttpSession.getAttribute("user"));
        view = request.getRequestDispatcher("qnaCreate.jsp");
        //view = request.getRequestDispatcher("admin/detailPage.jsp");
        view.forward(request, response);
    }
      /*public void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        RequestDispatcher view = null;
        HttpSession HttpSession = request.getSession();
        ArrayList <Qna> qnas = (ArrayList <Qna>) HttpSession.getAttribute("qnas");
        User user = (User) HttpSession.getAttribute("user");
        QnaService Qnaervice;
        QnaService = new QnaService();
        ArrayList<PhoneCase> phoneCases = null;
        phoneCases = PhoneCaseService.getAllPhoneCase();
        int totalprice = 0;
        ArrayList<PhoneCase> myCases = new ArrayList<PhoneCase>();
        for (int i = 0; i < carts.size(); i++) {
            for (int j = 0; j < phoneCases.size(); j++) {
                if ((carts.get(i).getCaseName()).equals(phoneCases.get(j).getCaseName())) {
                    totalprice += phoneCases.get(j).getPrice() * carts.get(i).getNumbers();
                    myCases.add(phoneCases.get(j));
                }
            }
        }
        
        request.setAttribute("carts", carts);
        request.setAttribute("user", user);
        request.setAttribute("myCases", myCases);
        request.setAttribute("totalprice", totalprice);
        view = request.getRequestDispatcher("addPayment.jsp");
        view.forward(request, response);
    }*/
}
