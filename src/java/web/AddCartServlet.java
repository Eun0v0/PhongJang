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
import util.Status;

/**
 * 장바구니에 상품 추가
*/
public class AddCartServlet extends HttpServlet {

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

        CartService cartService = new CartService();
        PhoneCaseService phoneCaseService = new PhoneCaseService();
        Status status = new Status();
        request.setAttribute("status", status);
        response.setContentType("text/html; charset=euc-kr");
        request.setCharacterEncoding("EUC-KR");

        String userID = request.getParameter("userID");
        String caseName = request.getParameter("caseName");
        String caseType = request.getParameter("caseType");
        String phoneType = request.getParameter("phoneType");
        String caseColor = request.getParameter("caseColor");
        int numbers = Integer.parseInt(request.getParameter("numbers"));
        int price = Integer.parseInt(request.getParameter("price"));

        int caseID = Integer.parseInt(request.getParameter("caseID"));
        ArrayList<PhoneType> phoneTypes = new ArrayList<PhoneType>();
        ArrayList<CaseColor> caseColors = new ArrayList<CaseColor>();
        
        PhoneTypeService phoneTypeService = new PhoneTypeService();
        CaseColorService caseColorService = new CaseColorService();
        ReviewService reviewService = new ReviewService();
        
        PhoneCase phoneCase;
        phoneCase = phoneCaseService.getPhoneCase(caseID);
        
        ArrayList<Review> reviews = reviewService.reviewRetrieve(caseID);
        
        String CaseName = phoneCase.getCaseName();
        String CaseType = phoneCase.getCaseType();
        String explanation = phoneCase.getExplanation();
        int Price = phoneCase.getPrice();
        String img = phoneCase.getImg();
        String detailImg = phoneCase.getDetailImg();
        
        phoneTypes = phoneTypeService.getPhoneType(CaseName);
        caseColors = caseColorService.getCaseColor(CaseName);
        
        request.setAttribute("caseID", caseID);
        request.setAttribute("caseName", CaseName);
        request.setAttribute("caseType", CaseType);
        request.setAttribute("explanation", explanation);
        request.setAttribute("price", Price);
        request.setAttribute("img", img);
        request.setAttribute("detailImg", detailImg);

        request.setAttribute("user", HttpSession.getAttribute("user"));
        request.setAttribute("phoneCase", HttpSession.getAttribute("phoneCase"));
        request.setAttribute("phoneTypes", phoneTypes);
        request.setAttribute("caseColors", caseColors);
        request.setAttribute("reviews", reviews);
        if (request.getParameter("numbers").equals("0")) {
            status.addException(new Exception("제품 개수를 입력해주세요"));
        }
        if (phoneType.equals("unknown")) {
            status.addException(new Exception("기종을 선택해주세요"));
        }
        if (caseColor.equals("unknown")) {
            status.addException(new Exception("타입을 선택해주세요"));
        }

        ArrayList<PhoneCase> cases = null;
        phoneCaseService = new PhoneCaseService();
        cases = phoneCaseService.getAllPhoneCase();
        request.setAttribute("phoneCases", cases);

        cartService = new CartService();

        try {
            //공란이 없을 경우 장바구니에 데이터 추가
            if (!phoneType.equals("unknown") && !caseColor.equals("unknown") && !request.getParameter("numbers").equals("0")) {
                cartService.addToCart(userID, caseName, caseColor, numbers, price, phoneType, caseType);
            }
            ArrayList<Cart> carts = null;
            carts = cartService.getCart(userID);

            request.setAttribute("user", HttpSession.getAttribute("user"));
            request.setAttribute("carts", carts);
            
            if (!status.isSuccessful()) {
                view = request.getRequestDispatcher("detailPage.jsp"); //c7stomer 전용
                view.forward(request, response);
                return;
            }

            view = request.getRequestDispatcher("cart.jsp"); //c7stomer 전용
            view.forward(request, response);
        } catch (Exception e) {
            status.addException(e);
            view = request.getRequestDispatcher("detailPage.jsp"); //c7stomer 전용
            view.forward(request, response);
        }
    }
}
