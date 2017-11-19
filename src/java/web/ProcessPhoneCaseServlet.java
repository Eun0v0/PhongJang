
package web;

import java.io.IOException;
import java.io.PrintWriter;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import domain.PhoneCase;
import domain.PhoneCaseService;
import domain.User;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.oreilly.servlet.MultipartRequest;
import java.io.File;
import util.Status;


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
        response.setContentType("text/html; charset=euc-kr");
        request.setCharacterEncoding("EUC-KR");
        request.setAttribute("status", status);
        
        String path = request.getRealPath("/upload");
        PrintWriter out = response.getWriter();
        
        MultipartRequest multi = new MultipartRequest(request, path, 1024 * 1024 * 5, "euc-kr",
                    new DefaultFileRenamePolicy());

        PhoneCaseService PhoneCaseService = new PhoneCaseService();
        HttpSession HttpSession = request.getSession();
        User user = (User) HttpSession.getAttribute("user");
        ArrayList<PhoneCase> phoneCases = new ArrayList<PhoneCase>();
        phoneCases = PhoneCaseService.getAllPhoneCase();
        request.setAttribute("phoneCases", phoneCases);
        request.setAttribute("user", user);
        
        try {
            String caseName = multi.getParameter("caseName");
            String caseType = multi.getParameter("caseType");
            String explanation = multi.getParameter("explanation");
            int price = Integer.parseInt(multi.getParameter("price"));
            String img = multi.getFilesystemName("img");
            
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
                PhoneCaseService.insertPhoneCase(caseType, caseName, explanation, price, img);

                phoneCases = PhoneCaseService.getAllPhoneCase();
                request.setAttribute("phoneCases", phoneCases);
                if (!status.isSuccessful()) {
                    view = request.getRequestDispatcher("admin/create.jsp");
                    view.forward(request, response);
                    return;
                }
                view = request.getRequestDispatcher("admin/list.jsp");
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
