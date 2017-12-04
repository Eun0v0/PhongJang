/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;
import domain.CaseColor;
import domain.CaseColorService;
import domain.Event;
import domain.EventService;
import domain.PhoneCase;
import domain.PhoneCaseService;
import domain.PhoneType;
import domain.PhoneTypeService;
import domain.Review;
import domain.ReviewService;
import domain.User;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 이벤트 열람/수정 페이지로 이동
*/
public class UpdateEventServlet extends HttpServlet {
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }
     public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }
    public void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        RequestDispatcher view = null;
        HttpSession HttpSession = request.getSession();
        
        response.setContentType("text/html; charset=euc-kr");
        request.setCharacterEncoding("EUC-KR");
        request.setAttribute("user", HttpSession.getAttribute("user"));
        int eventID = Integer.parseInt(request.getParameter("eventID"));
        EventService eventService = new EventService();
        Event event;
        event = eventService.getEvent(eventID);
        
        String title = event.getTitle();
        String image = event.getImage();
        String content = event.getContent();
        
        request.setAttribute("event", event);
        request.setAttribute("title", title);
        request.setAttribute("image", image);
        request.setAttribute("content", content);
        
        String userType = null;
        User user =(User) HttpSession.getAttribute("user"); 
        if(user != null)
            userType = user.getUsertype();    
         
        if(user == null || userType.equals("C")){
            view = request.getRequestDispatcher("eventView.jsp"); //고객은 열람만 가능
            view.forward(request, response);
        } else {
            view = request.getRequestDispatcher("admin/eventUpdate.jsp"); //관리자는 열람 동시에 수정 가능
            view.forward(request, response);
        }
    }
}