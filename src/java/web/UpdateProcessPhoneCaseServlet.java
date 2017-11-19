/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;
import domain.PhoneCase;
import domain.PhoneCaseService;
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

public class UpdateProcessPhoneCaseServlet extends HttpServlet {
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }
    public void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        RequestDispatcher view = null;
        Status status = new Status();
        request.setCharacterEncoding("EUC-KR");
        
        request.setAttribute("status", status);
        PhoneCaseService PhoneCaseService = new PhoneCaseService();
        HttpSession HttpSession = request.getSession();
        User user = (User) HttpSession.getAttribute("user");
        
        int caseID = Integer.parseInt(request.getParameter("caseID"));
        String caseType = request.getParameter("caseType");
        String caseName = request.getParameter("caseName");
        String explanation = request.getParameter("explanation");
        int price = Integer.parseInt(request.getParameter("price"));

        
        ArrayList<PhoneCase> phoneCases = new ArrayList<PhoneCase>();
        phoneCases = PhoneCaseService.getAllPhoneCase();
        request.setAttribute("phoneCases", phoneCases);
        request.setAttribute("user", user);
        request.setAttribute("caseID", caseID);
        
        
        try {
            if ((caseType == null) || (caseType.length() == 0)) {
                status.addException(new Exception(
                        "Please enter your producttype"));
            }
            if ((caseName == null) || (caseName.length() == 0)) {
                status.addException(new Exception(
                        "Please enter your productname"));
            }
            if ((explanation == null) || (explanation.length() == 0)) {
                status.addException(new Exception(
                        "Please enter your explanation"));
            }
            if ((price == 0)) {
                status.addException(new Exception(
                        "Please enter your price"));
            }
            
            try {
                //(int caseID, String caseType, String caseName, String explanation, int price)
                PhoneCaseService.updatePhoneCase(caseID, caseType, caseName, explanation, price);
                phoneCases = PhoneCaseService.getAllPhoneCase();
                request.setAttribute("phoneCases", phoneCases);
                if (!status.isSuccessful()) {
                    view = request.getRequestDispatcher("admin/update.jsp");
                    view.forward(request, response);
                    return;
                }
                view = request.getRequestDispatcher("admin/main.jsp");
                view.forward(request, response);
            } catch (Exception e) {
                status.addException(e);
                view = request.getRequestDispatcher("admin/update.jsp");
                view.forward(request, response);
            }
        } catch (IllegalArgumentException e) {
            status.addException(e);
            view = request.getRequestDispatcher("admin/update.jsp");
            view.forward(request, response);
        }
    }
}
