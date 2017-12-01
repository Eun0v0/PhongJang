/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import domain.Cart;
import domain.CartService;
import domain.CaseColor;
import domain.CaseColorService;
import domain.PaymentService;
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
import util.Status;

public class ProcessPaymentServlet extends HttpServlet {

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
        request.setCharacterEncoding("EUC-KR");

        java.util.Calendar cal = java.util.Calendar.getInstance();

        String year = String.valueOf(cal.get(cal.YEAR));
        String month = String.valueOf(cal.get(cal.MONTH) + 1);
        String date = String.valueOf(cal.get(cal.DATE));
        String s_date = year + "-" + month + "-" + date;	//date which user did slot machine

        ArrayList<Cart> carts = (ArrayList<Cart>) HttpSession.getAttribute("carts");
        User user = (User) HttpSession.getAttribute("user");

        ArrayList<PhoneCase> phonecases = null;
        PhoneCaseService phoneCaseService = new PhoneCaseService();
        CaseColorService caseColorService = new CaseColorService();

        PaymentService PaymentService = new PaymentService();

        String userID = user.getId();
        String address = user.getAddress();
        String phoneNumber = user.getPhone();
        String creditcardNumber = request.getParameter("creditcardNumber");
        String creditcardPassword = request.getParameter("creditcardPassword");
        String v_status = "배송 준비중";
        String parcelNumber = "준비중";

        try {

            if ((creditcardNumber == null) || (creditcardNumber.length() == 0)) {
                status.addException(new Exception(
                        "아이디를 입력해주세요"));
            }
            if ((creditcardPassword == null) || (creditcardPassword.length() == 0)) {
                status.addException(new Exception(
                        "이름을 입력해주세요"));
            }
            if ((creditcardNumber.length() != 16)) {
                status.addException(new Exception(
                        "카드 번호는 16자리 입니다"));
            }
            if ((creditcardPassword.length() != 4)) {
                status.addException(new Exception(
                        "카드 비밀번호는 4자리 입니다"));
            }
            try {
                if (!creditcardNumber.isEmpty() && !creditcardPassword.isEmpty() && (creditcardNumber.length() == 16) && (creditcardPassword.length() == 4)) {
                    for (int i = 0; i < carts.size(); i++) {
                        PaymentService.paymentAdd(userID, carts.get(i).getCaseName(), carts.get(i).getNumbers(), carts.get(i).getPrice() * carts.get(i).getNumbers(),
                                address, phoneNumber, creditcardNumber, creditcardPassword, v_status, parcelNumber, s_date,
                                carts.get(i).getPhoneType(), carts.get(i).getCaseType(), carts.get(i).getColor());
                        int cartID = carts.get(i).getCartID();
                        CartService CartService = new CartService();
                        CartService.cleanCart(userID, cartID);
                        String caseName = carts.get(i).getCaseName();
                        int caseID = phoneCaseService.getCaseID(caseName);
                        PhoneCase phoneCase = phoneCaseService.getPhoneCase(caseID);
                        int pop = phoneCase.getStock() + carts.get(i).getNumbers();//인기케이스
                        ArrayList<CaseColor> caseColors = caseColorService.getCaseColor(caseName);
                        CaseColor caseColor;
                        String v_caseColor = carts.get(i).getColor();
                        int tempStock = 0;
                        for (int j = 0; j < caseColors.size(); j++) {
                            caseColor = caseColors.get(j);
                            if (caseColor.getCaseColor().equals(v_caseColor)) {
                                tempStock = caseColor.getStock();
                                break;
                            }
                        }
                        int newStock = tempStock - carts.get(i).getNumbers();

                        caseColorService.stockChange(newStock, caseName, v_caseColor);
                        phoneCaseService.stockChange(caseID, pop);
                    }
                }
                phonecases = phoneCaseService.getAllPhoneCase();
                int totalprice = 0;
                ArrayList<PhoneCase> myCases = new ArrayList<PhoneCase>();
                for (int i = 0; i < carts.size(); i++) {
                    for (int j = 0; j < phonecases.size(); j++) {
                        if ((carts.get(i).getCaseName()).equals(phonecases.get(j).getCaseName())) {
                            totalprice += phonecases.get(j).getPrice() * carts.get(i).getNumbers();
                            myCases.add(phonecases.get(j));
                        }
                    }
                }
                
                request.setAttribute("phoncases", phonecases);
                request.setAttribute("user", HttpSession.getAttribute("user"));
                request.setAttribute("carts", carts);
                request.setAttribute("myCases", myCases);
                request.setAttribute("totalprice", totalprice);

                if (!status.isSuccessful()) {
                    view = request.getRequestDispatcher("addPayment.jsp");
                    view.forward(request, response);
                    return;
                }
                
                view = request.getRequestDispatcher("paymentConfirm.jsp");
                view.forward(request, response);

            } catch (Exception e) {
                status.addException(e);
                view = request.getRequestDispatcher("addPayment.jsp");
                view.forward(request, response);
            }
        } catch (IllegalArgumentException e) {
            status.addException(e);
            view = request.getRequestDispatcher("addPayment.jsp");
            view.forward(request, response);
        }
    }
}
