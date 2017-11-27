package web;

import domain.UserService;
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

/*public final class IDOverlapCheckServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();

        UserService UserService = null;
        ArrayList<User> users = null;
        String userID = request.getParameter("userID");

        UserService = new UserService();
        String findID = UserService.findID(userID);

        request.setCharacterEncoding("EUC-KR");
        request.setAttribute("users", users);

        if (findID == null) {
            out.println("<script> alert('사용 가능한 아이디 입니다');history.back()</script>");

        } else {
            out.println("<script> alert('사용중인 아이디 입니다');history.back()</script>");

        }

        //view = request.getRequestDispatcher("join.jsp");
        view.forward(request, response);
    }
}*/
