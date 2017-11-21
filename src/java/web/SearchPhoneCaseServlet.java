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

public final class SearchPhoneCaseServlet extends HttpServlet {

    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    public void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        RequestDispatcher view = null;
        PhoneCaseService phoneCaseService = null;
        HttpSession HttpSession = request.getSession();
        request.setCharacterEncoding("EUC-KR");
        User user = (User)HttpSession.getAttribute("user");
        
        String phoneCaseName = request.getParameter("caseName");

        ArrayList<PhoneCase> cases = null;
        phoneCaseService = new PhoneCaseService();
        cases = phoneCaseService.getPhoneCase(phoneCaseName);
        request.setAttribute("phoneCases", cases);
        request.setAttribute("user", HttpSession.getAttribute("user"));
        
        if(user == null || user.getUsertype().equals("C") ){
            view = request.getRequestDispatcher("caseTypePage.jsp");
            view.forward(request, response);
        } else {
            view = request.getRequestDispatcher("admin/caseTypePage.jsp");
            view.forward(request, response);
        }
    }
}
