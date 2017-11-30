/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;
import domain.CaseColorService;
import domain.PhoneCase;
import domain.PhoneCaseService;
import domain.PhoneTypeService;
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
        request.setCharacterEncoding("EUC-KR");
        request.setAttribute("status", status);
        PhoneCaseService phoneCaseService = new PhoneCaseService();
        PhoneTypeService phoneTypeService = new PhoneTypeService();
        CaseColorService caseColorService = new CaseColorService();
        HttpSession HttpSession = request.getSession();
        User user = (User) HttpSession.getAttribute("user");
        
        int caseID = Integer.parseInt(request.getParameter("caseID"));
        String caseName = request.getParameter("caseName");
        ArrayList<PhoneCase> phoneCases = null;
        phoneCaseService.deletePhoneCase(caseID);
        phoneTypeService.phoneTypeDelete(caseName);
        caseColorService.caseColorDelete(caseName);
        
        phoneCases = phoneCaseService.getAllPhoneCase();

        request.setCharacterEncoding("EUC-KR");
        request.setAttribute("user", user);
        request.setAttribute("phoneCases", phoneCases);
        
        view = request.getRequestDispatcher("admin/manageStock.jsp");
        view.forward(request, response);
    }
}