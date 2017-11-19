/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;
import domain.PhoneCase;
import domain.PhoneCaseService;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class UpdatePhoneCaseServlet extends HttpServlet {
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
        int caseID = Integer.parseInt(request.getParameter("caseID"));
        PhoneCaseService phoneCaseService = new PhoneCaseService();
        PhoneCase phoneCase;
        phoneCase = phoneCaseService.getPhoneCase(caseID);
        
        String caseName = phoneCase.getCaseName();
        String caseType = phoneCase.getCaseType();
        String explanation = phoneCase.getExplanation();
        int price = phoneCase.getPrice();
        String img = phoneCase.getImg();
        
        request.setAttribute("caseID", caseID);
        request.setAttribute("caseName", caseName);
        request.setAttribute("caseType", caseType);
        request.setAttribute("explanation", explanation);
        request.setAttribute("price", price);
        request.setAttribute("img", img);

        request.setAttribute("user", HttpSession.getAttribute("user"));
        request.setAttribute("phoneCase", HttpSession.getAttribute("phoneCase"));
        
        view = request.getRequestDispatcher("admin/update.jsp");
        view.forward(request, response);
    }
}