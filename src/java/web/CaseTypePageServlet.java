package web;

import domain.PhoneCase;
import domain.PhoneCaseService;
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
/**
 * 케이스 타입별로 모아서 보여주기 위한 서블릿
*/
public final class CaseTypePageServlet extends HttpServlet {

    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    public void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        RequestDispatcher view = null;
        HttpSession HttpSession=request.getSession();
        response.setContentType("text/html; charset=euc-kr");
        
        PhoneCaseService PhoneCaseService = null;
        ArrayList<PhoneCase> phoneCases = null; 
        request.setCharacterEncoding("EUC-KR");
        User user = (User)HttpSession.getAttribute("user");
        PhoneCaseService = new PhoneCaseService();  
        String caseType = request.getParameter("caseType");
        phoneCases = PhoneCaseService.getPhoneCaseType(caseType); //해당 케이스 타입을 가진 케이스만을 가져옴
            
        
        request.setAttribute("caseType", caseType);
        request.setAttribute("user", HttpSession.getAttribute("user"));
        request.setAttribute("phoneCases", phoneCases);
        
        if(user == null || user.getUsertype().equals("C") ){
            view = request.getRequestDispatcher("caseTypePage.jsp");
            view.forward(request, response);
        } else {
            view = request.getRequestDispatcher("admin/caseTypePage.jsp");
            view.forward(request, response);
        }
    }
}