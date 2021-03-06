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
 * 재고 관리 서블릿
*/
public final class ManageStockServlet extends HttpServlet {

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
        
        PhoneCaseService PhoneCaseService = null;
        ArrayList<PhoneCase> phoneCases = null; 
        
        PhoneCaseService = new PhoneCaseService();     
        phoneCases = PhoneCaseService.getAllPhoneCase();
            
        request.setCharacterEncoding("EUC-KR");
        request.setAttribute("user", HttpSession.getAttribute("user"));
        request.setAttribute("phoneCases", phoneCases);
        
        //view = request.getRequestDispatcher("admin/managePhoneCase.jsp");
        view = request.getRequestDispatcher("admin/manageStock.jsp");
        
        view.forward(request, response);
    }
}