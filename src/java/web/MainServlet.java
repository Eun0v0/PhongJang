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

public final class MainServlet extends HttpServlet {

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
        
        PhoneCaseService phoneCaseService = null;
        ArrayList<PhoneCase> phoneCases = null; 
        
        phoneCaseService = new PhoneCaseService();     
        phoneCases = phoneCaseService.getAllPhoneCase();
        ArrayList<PhoneCase> p_phoneCases = phoneCaseService.popPhoneCaseRetrieve();
        request.setCharacterEncoding("EUC-KR");
        request.setAttribute("user", HttpSession.getAttribute("user"));
        request.setAttribute("phoneCases", phoneCases);
        request.setAttribute("p_phoneCases", p_phoneCases);
        
        
        String userType = ((User) HttpSession.getAttribute("user")).getUsertype();    
        
        if(userType.equals("C")){
            view = request.getRequestDispatcher("main.jsp"); //c7stomer 전용
            view.forward(request, response);
        } else {
            view = request.getRequestDispatcher("admin/main.jsp");
            view.forward(request, response);
        }
    }
}