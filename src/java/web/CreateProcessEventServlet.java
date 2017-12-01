/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import domain.CaseColorService;
import domain.Event;
import domain.EventService;
import domain.MyCase;
import domain.MyCaseService;
import domain.PhoneCase;
import domain.PhoneCaseService;
import domain.PhoneTypeService;
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
 * 이벤트 추가 기능을 수행하는 서블릿
*/
public class CreateProcessEventServlet extends HttpServlet {

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

        String path = request.getRealPath("/image/upload");
        PrintWriter out = response.getWriter();

        java.util.Calendar cal = java.util.Calendar.getInstance();

        String year = String.valueOf(cal.get(cal.YEAR));
        String month = String.valueOf(cal.get(cal.MONTH) + 1);
        String date = String.valueOf(cal.get(cal.DATE));
        String s_date = year + "-" + month + "-" + date; //작성일을 저장하기 위해 날짜 저장

        MultipartRequest multi = new MultipartRequest(request, path, 1024 * 1024 * 5, "euc-kr",
                new DefaultFileRenamePolicy());

        EventService eventService = new EventService();

        HttpSession HttpSession = request.getSession();
        User user = (User) HttpSession.getAttribute("user");
        ArrayList<Event> events = new ArrayList<Event>();

        String userID = user.getId();
        events = eventService.getAllEvents();
        request.setAttribute("events", events);
        request.setAttribute("user", user);

        try {
            String title = multi.getParameter("title");
            String image = multi.getFilesystemName("image");
            String content = multi.getParameter("content");

            if ((title == null) || (title.length() == 0)) {
                status.addException(new Exception(
                        "Please enter your producttype"));
            }
            if ((image == null) || (image.length() == 0)) {
                status.addException(new Exception(
                        "Please enter your productname"));
            }
            if ((content == null) || (content.length() == 0)) {
                status.addException(new Exception(
                        "Please enter your explanation"));
            }

            try {
                //공란이 없다면 이벤트 추가
                if (!title.isEmpty() && !image.isEmpty() && !content.isEmpty()) {
                    eventService.addEvent(title, image, s_date, content);
                }

                events = eventService.getAllEvents();
                request.setAttribute("events", events);
                request.setAttribute("user", user);
                if (!status.isSuccessful()) {
                    view = request.getRequestDispatcher("admin/eventWrite.jsp");
                    view.forward(request, response);
                    return;
                }
                view = request.getRequestDispatcher("admin/eventList.jsp");
                view.forward(request, response);
            } catch (Exception e) {
                status.addException(e);
                view = request.getRequestDispatcher("admin/eventWrite.jsp");
                view.forward(request, response);
            }
        } catch (IllegalArgumentException e) {
            status.addException(e);
            view = request.getRequestDispatcher("admin/eventWrite.jsp");
            view.forward(request, response);
        }
    }
}
