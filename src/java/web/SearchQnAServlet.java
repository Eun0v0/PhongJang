package web;

import domain.PhoneCase;
import domain.PhoneCaseService;
import domain.Qna;
import domain.QnaService;
import domain.User;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public final class SearchQnAServlet extends HttpServlet {

    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    public void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        Qna qna;
        RequestDispatcher view = null;
        QnaService qnaService = null;
        HttpSession HttpSession = request.getSession();
        request.setCharacterEncoding("EUC-KR");
        User user = (User) HttpSession.getAttribute("user");

        String userName = request.getParameter("userName");

        ArrayList<Qna> qnas = new ArrayList<Qna>();
        qnaService = new QnaService();
        qnas = qnaService.getMyQna(userName);
        
        request.setAttribute("qnas", qnas);
        request.setAttribute("user", HttpSession.getAttribute("user"));

        view = request.getRequestDispatcher("qna.jsp");
        view.forward(request, response);
    }
}
