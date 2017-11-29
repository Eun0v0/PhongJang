/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import domain.Cart;
import domain.CartService;
import domain.MyCase;
import domain.MyCaseService;
import domain.Payment;
import domain.PaymentService;
import domain.PhoneCase;
import domain.PhoneCaseService;
import domain.ReplyMyCase;
import domain.ReplyMyCaseService;
import domain.User;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateMyCaseStatusServlet extends HttpServlet {

    public void doPost(HttpServletRequest request,
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

        //ReplyMyCase replyMyCase = null;
        User user = (User) HttpSession.getAttribute("user");
        MyCaseService myCaseService = new MyCaseService();
        ReplyMyCaseService replyMyCaseService = new ReplyMyCaseService();

        ArrayList<MyCase> myCases = new ArrayList<MyCase>();
        ArrayList<ReplyMyCase> replyMyCases = new ArrayList<ReplyMyCase>();

        
        String myCaseStatus = "제작중";
        int myCaseNum = Integer.parseInt(request.getParameter("myCaseNum"));
        replyMyCaseService.myCaseReplyUpdate(myCaseNum, myCaseStatus);

        myCases = myCaseService.getAllMyCases();
        replyMyCases = replyMyCaseService.myCaseReplyRetrieve();
        request.setAttribute("myCases", myCases);
        request.setAttribute("replyMyCases", replyMyCases);
        request.setAttribute("user", HttpSession.getAttribute("user"));

        view = request.getRequestDispatcher("admin/myCaseList.jsp");
        view.forward(request, response);
    }
}
