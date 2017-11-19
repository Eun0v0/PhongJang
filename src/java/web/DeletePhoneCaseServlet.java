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
/*
    관리자모드 - 상품 삭제
*/
public class DeletePhoneCaseServlet extends HttpServlet {
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
        request.setAttribute("status", status);
        PhoneCaseService PhoneCaseService = new PhoneCaseService();
        HttpSession HttpSession = request.getSession();
        User user = (User) HttpSession.getAttribute("user");
        
        int caseID = Integer.parseInt(request.getParameter("caseID"));
        ArrayList<PhoneCase> phoneCases = null;
        PhoneCaseService.deletePhoneCase(caseID);
        
        phoneCases = PhoneCaseService.getAllPhoneCase();

        request.setCharacterEncoding("EUC-KR");
        request.setAttribute("user", user);
        request.setAttribute("phoneCases", phoneCases);
        
<<<<<<< HEAD
        view = request.getRequestDispatcher("admin/list.jsp");
=======
        view = request.getRequestDispatcher("admin/managePhoneCase.jsp");
>>>>>>> b1a42c8de5d04552ef6508021fa1a8c26be2d0df
        view.forward(request, response);
    }
}