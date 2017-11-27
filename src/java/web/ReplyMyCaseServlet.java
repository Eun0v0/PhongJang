/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import domain.CaseColorService;
import domain.MyCase;
import domain.MyCaseService;
import domain.PhoneCase;
import domain.PhoneCaseService;
import domain.PhoneTypeService;
import domain.ReplyMyCase;
import domain.ReplyMyCaseService;
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

/**
 *
 * @author yukih
 */
public class ReplyMyCaseServlet extends HttpServlet {

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

        String path = request.getRealPath("/image/myCase");
        PrintWriter out = response.getWriter();

        java.util.Calendar cal = java.util.Calendar.getInstance();

        String year = String.valueOf(cal.get(cal.YEAR));
        String month = String.valueOf(cal.get(cal.MONTH) + 1);
        String date = String.valueOf(cal.get(cal.DATE) + 3);
        String dueDate = year + "-" + month + "-" + date;	//date which user did slot machine

        MultipartRequest multi = new MultipartRequest(request, path, 1024 * 1024 * 5, "euc-kr",
                new DefaultFileRenamePolicy());

        ReplyMyCaseService replyMyCaseService = new ReplyMyCaseService();
        MyCaseService myCaseService = new MyCaseService();

        HttpSession HttpSession = request.getSession();
        User user = (User) HttpSession.getAttribute("user");
        ArrayList<ReplyMyCase> replyMyCases = new ArrayList<ReplyMyCase>();

        String userID = user.getId();

        int myCaseNum = Integer.parseInt(multi.getParameter("myCaseNum"));
        String content = multi.getParameter("content");
        String image = multi.getFilesystemName("image");
        String account = "524932-01-347928 국민은행 <예금주: 퐁장>";
        String v_status = "입금 대기";
        int price = Integer.parseInt(multi.getParameter("price"));

        MyCase myCase = null;
        myCase = myCaseService.getMyCase(myCaseNum);

        request.setAttribute("myCase", myCase);
        replyMyCases = replyMyCaseService.myCaseReplyRetrieve();
        request.setAttribute("replyMyCases", replyMyCases);
        request.setAttribute("user", user);

        try {

            if (image == null) {
                image = "사진 없음";
            }

            if ((content == null) || (content.length() == 0)) {
                status.addException(new Exception(
                        "Please enter your producttype"));
            }
            if ((image == null) || (image.length() == 0)) {
                status.addException(new Exception(
                        "Please enter your productname"));
            }

            try {
                replyMyCaseService.addMyCaseReply(myCaseNum, account, image, dueDate, content, v_status, price);

                replyMyCases = replyMyCaseService.myCaseReplyRetrieve();
                ReplyMyCase replyMyCase;

                myCase = myCaseService.getMyCase(myCaseNum);
                replyMyCase = replyMyCaseService.getMyCase(myCaseNum);
        
                request.setAttribute("myCase", myCase);
                request.setAttribute("user", user);
                request.setAttribute("replyMyCases", replyMyCases);
                request.setAttribute("replyMyCase",replyMyCase);

                if (!status.isSuccessful()) {
                    view = request.getRequestDispatcher("admin/replyMyCase.jsp");
                    view.forward(request, response);
                    return;
                }
                view = request.getRequestDispatcher("admin/replyMyCase.jsp");
                view.forward(request, response);
            } catch (Exception e) {
                status.addException(e);
                view = request.getRequestDispatcher("admin/replyMyCase.jsp");
                view.forward(request, response);
            }
        } catch (IllegalArgumentException e) {
            status.addException(e);
            view = request.getRequestDispatcher("admin/replyMyCase.jsp");
            view.forward(request, response);
        }
    }
}
