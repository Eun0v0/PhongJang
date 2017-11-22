/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import domain.PhoneCase;
import domain.PhoneCaseService;
import domain.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.Status;

public class StockChangeServlet extends HttpServlet {

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
        HttpSession HttpSession = request.getSession();
        response.setContentType("text/html; charset=euc-kr");
        request.setCharacterEncoding("EUC-KR");

        request.setCharacterEncoding("EUC-KR");
        request.setAttribute("status", status);
        
        PhoneCaseService phoneCaseService = new PhoneCaseService();
        User user = (User) HttpSession.getAttribute("user");

        int caseID = Integer.parseInt(request.getParameter("caseID"));
        int stock = Integer.parseInt(request.getParameter("stock"));

        ArrayList<PhoneCase> phoneCases = new ArrayList<PhoneCase>();

        try {
            if (stock == 0) {
                status.addException(new Exception(
                        "Please enter your producttype"));
            }
            try {
                phoneCaseService.stockChange(caseID, stock);
                phoneCases = phoneCaseService.getAllPhoneCase();
                request.setAttribute("phoneCases", phoneCases);
                request.setAttribute("user", user);
                request.setAttribute("caseID", caseID);
                if (!status.isSuccessful()) {
                    view = request.getRequestDispatcher("admin/manageStock.jsp");
                    view.forward(request, response);
                    return;
                }
                view = request.getRequestDispatcher("admin/main.jsp");
                view.forward(request, response);
            } catch (Exception e) {
                status.addException(e);
                view = request.getRequestDispatcher("admin/manageStock.jsp");
                view.forward(request, response);
            }
        } catch (IllegalArgumentException e) {
            status.addException(e);
            view = request.getRequestDispatcher("admin/manageStock.jsp");
            view.forward(request, response);
        }
    }
}
