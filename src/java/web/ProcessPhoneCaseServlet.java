<<<<<<< HEAD
package web;

import java.io.IOException;
import java.io.PrintWriter;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
=======
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
>>>>>>> b1a42c8de5d04552ef6508021fa1a8c26be2d0df
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
<<<<<<< HEAD
import com.oreilly.servlet.MultipartRequest;
import domain.PhoneCase;
import domain.PhoneCaseService;
import domain.User;
import java.io.File;
import java.util.ArrayList;
import util.Status;

=======
import util.Status;
>>>>>>> b1a42c8de5d04552ef6508021fa1a8c26be2d0df
public class ProcessPhoneCaseServlet extends HttpServlet {
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
<<<<<<< HEAD
        response.setContentType("text/html; charset=euc-kr");
        request.setCharacterEncoding("EUC-KR");
        request.setAttribute("status", status);
        
        String path = request.getRealPath("/upload");
        PrintWriter out = response.getWriter();
        
        MultipartRequest multi = new MultipartRequest(request, path, 1024 * 1024 * 5, "euc-kr",
                    new DefaultFileRenamePolicy());
        
=======
        request.setCharacterEncoding("EUC-KR");
        request.setAttribute("status", status);
>>>>>>> b1a42c8de5d04552ef6508021fa1a8c26be2d0df
        PhoneCaseService PhoneCaseService = new PhoneCaseService();
        HttpSession HttpSession = request.getSession();
        User user = (User) HttpSession.getAttribute("user");
        ArrayList<PhoneCase> phoneCases = new ArrayList<PhoneCase>();
        phoneCases = PhoneCaseService.getAllPhoneCase();
        request.setAttribute("phoneCases", phoneCases);
        request.setAttribute("user", user);
        
        try {
<<<<<<< HEAD
            String caseName = multi.getParameter("caseName");
            String caseType = multi.getParameter("caseType");
            String explanation = multi.getParameter("explanation");
            int price = Integer.parseInt(multi.getParameter("price"));
            String img = multi.getFilesystemName("img");
=======
            String caseType = request.getParameter("caseType");
            String caseName = request.getParameter("caseName");
            String explanation = request.getParameter("explanation");
            int price = Integer.parseInt(request.getParameter("price"));
>>>>>>> b1a42c8de5d04552ef6508021fa1a8c26be2d0df
            
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
<<<<<<< HEAD
                PhoneCaseService.insertPhoneCase(caseType, caseName, explanation, price, img);
=======
                PhoneCaseService.insertPhoneCase(caseType, caseName, explanation, price);
>>>>>>> b1a42c8de5d04552ef6508021fa1a8c26be2d0df
                phoneCases = PhoneCaseService.getAllPhoneCase();
                request.setAttribute("phoneCases", phoneCases);
                if (!status.isSuccessful()) {
                    view = request.getRequestDispatcher("admin/create.jsp");
                    view.forward(request, response);
                    return;
                }
<<<<<<< HEAD
                view = request.getRequestDispatcher("admin/list.jsp");
=======
                view = request.getRequestDispatcher("admin/main.jsp");
>>>>>>> b1a42c8de5d04552ef6508021fa1a8c26be2d0df
                view.forward(request, response);
            } catch (Exception e) {
                status.addException(e);
                view = request.getRequestDispatcher("admin/create.jsp");
                view.forward(request, response);
            }
        } catch (IllegalArgumentException e) {
            status.addException(e);
            view = request.getRequestDispatcher("admin/create.jsp");
            view.forward(request, response);
        }
    }
}
