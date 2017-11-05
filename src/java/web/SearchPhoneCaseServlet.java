package web;
import domain.PhoneCase;
import domain.PhoneCaseService;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public final class SearchPhoneCaseServlet extends HttpServlet {

    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    public void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        RequestDispatcher view = null;
        PhoneCaseService phoneCaseService = null;

        String phoneCaseName = request.getParameter("caseName");

        ArrayList<PhoneCase> cases = null;
        phoneCaseService = new PhoneCaseService();
        cases = phoneCaseService.getPhoneCase(phoneCaseName);

        request.setAttribute("phoneCases", cases);
        view = request.getRequestDispatcher("phoneCaseList.jsp");
        view.forward(request, response);
    }
}