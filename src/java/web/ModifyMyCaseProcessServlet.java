package web;

import domain.MyCase;
import domain.MyCaseService;
import domain.UserService;
import domain.User;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.Status;

public final class ModifyMyCaseProcessServlet extends HttpServlet {

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
        Status status = new Status();
        request.setAttribute("status", status);

        User user = (User) HttpSession.getAttribute("user");
        MyCase myCase = (MyCase) HttpSession.getAttribute("myCase");
        MyCase s_myCase = null;
        MyCaseService myCaseService = new MyCaseService();

        String userID = user.getId();
        request.setCharacterEncoding("EUC-KR");

        int myCaseNum = Integer.parseInt(request.getParameter("myCaseNum"));
        String title = request.getParameter("title");
        String caseType = request.getParameter("caseType");
        String phoneType = request.getParameter("phoneType");
        String color = request.getParameter("color");
        String content = request.getParameter("content");
        String image = request.getParameter("caseImage");

        try {

            myCaseService.myCaseUpdate(myCaseNum, title, caseType, phoneType, color, content, image);
            s_myCase = myCaseService.getMyCase(myCaseNum);

            request.setCharacterEncoding("EUC-KR");
            ArrayList<MyCase> myCases = new ArrayList<MyCase>();
            myCases = myCaseService.getAllMyCases(userID);
            request.setAttribute("myCases", myCases);
            request.setAttribute("myCase", s_myCase);
            request.setAttribute("user", user);

            if (!status.isSuccessful()) {
                view = request.getRequestDispatcher("modifyMyCase.jsp");
                view.forward(request, response);
                return;
            }
            view = request.getRequestDispatcher("myCaseList.jsp");
            view.forward(request, response);
        } catch (Exception e) {
            status.addException(e);
            view = request.getRequestDispatcher("modifyMyCase.jsp");
            view.forward(request, response);
        }
    }
}
