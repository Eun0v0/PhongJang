package web;
import domain.Cart;
import domain.PhoneCase;
import domain.PhoneCaseService;
import domain.User;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddPaymentServlet extends HttpServlet {
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
        ArrayList <Cart> carts = (ArrayList <Cart>) HttpSession.getAttribute("carts");
        User user = (User) HttpSession.getAttribute("user");
        PhoneCaseService PhoneCaseService;
        PhoneCaseService = new PhoneCaseService();
        ArrayList<PhoneCase> phoneCases = null;
        phoneCases = PhoneCaseService.getAllPhoneCase();
        int totalprice = 0;
        ArrayList<PhoneCase> myCases = new ArrayList<PhoneCase>();
        for (int i = 0; i < carts.size(); i++) {
            for (int j = 0; j < phoneCases.size(); j++) {
                if ((carts.get(i).getCaseName()).equals(phoneCases.get(j).getCaseName())) {
                    totalprice += phoneCases.get(j).getPrice() * carts.get(i).getNumbers();
                    myCases.add(phoneCases.get(j));
                }
            }
        }
        
        request.setAttribute("carts", carts);
        request.setAttribute("user", user);
        request.setAttribute("myCases", myCases);
        request.setAttribute("totalprice", totalprice);
        view = request.getRequestDispatcher("addPayment.jsp");
        view.forward(request, response);
    }
}