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
 * 이벤트 리스트 서블릿
*/
public class EventListServlet extends HttpServlet {

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
        EventService eventService = new EventService();

        HttpSession HttpSession = request.getSession();
        User user = (User) HttpSession.getAttribute("user");
        ArrayList<Event> events = new ArrayList<Event>();

        String userID = user.getId();

        String userType = ((User) HttpSession.getAttribute("user")).getUsertype();

        if (userType.equals("C")) {
            events = eventService.getAllEvents();//전체 이벤트 내용을 가져온다
            request.setAttribute("events", events);
            request.setAttribute("user", user);
            view = request.getRequestDispatcher("eventList.jsp");
            view.forward(request, response);
        } else {
             events = eventService.getAllEvents();//전체 이벤트 내용을 가져온다
            request.setAttribute("events", events);
            request.setAttribute("user", user);
            view = request.getRequestDispatcher("admin/eventList.jsp");
            view.forward(request, response);
        }
    }
}
