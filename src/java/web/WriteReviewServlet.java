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
 * 리뷰 작성 서블릿
*/
public class WriteReviewServlet extends HttpServlet {

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

        ReviewService reviewService = new ReviewService();
        Status status = new Status();
        response.setContentType("text/html; charset=euc-kr");
        request.setAttribute("status", status);
        request.setCharacterEncoding("EUC-KR");
        
        int caseID = Integer.parseInt(request.getParameter("caseID"));
        String userID = request.getParameter("userID");
        String content = request.getParameter("content");
        String grade = request.getParameter("grade");
        
        java.util.Calendar cal=java.util.Calendar.getInstance();
        
        String year =String.valueOf(cal.get(cal.YEAR));
        String month=String.valueOf(cal.get(cal.MONTH)+1);
        String date=String.valueOf(cal.get(cal.DATE));
        String writeDate=year+"-"+month+"-"+date;//날짜 저장
        
        if (content.isEmpty()) {
            status.addException(new Exception("내용을 입력해주세요"));
        }
        if (grade.isEmpty()) {
            status.addException(new Exception("평점을 입력해주세요"));
        }

        if(!content.isEmpty() && !grade.isEmpty()){
            reviewService.addReview(caseID, userID, content, grade, writeDate);
        }
        
        ArrayList<Review> reviews = null;
        reviews = reviewService.reviewRetrieve(caseID);
        request.setAttribute("reviews", reviews);

        request.setAttribute("user", HttpSession.getAttribute("user"));
        
        ArrayList<PhoneType> phoneTypes = new ArrayList<PhoneType>();
        ArrayList<CaseColor> caseColors = new ArrayList<CaseColor>();
        
        PhoneTypeService phoneTypeService = new PhoneTypeService();
        PhoneCaseService phoneCaseService = new PhoneCaseService();
        CaseColorService caseColorService = new CaseColorService();
        
        PhoneCase phoneCase;
        phoneCase = phoneCaseService.getPhoneCase(caseID);
        
        String caseName = phoneCase.getCaseName();
        String caseType = phoneCase.getCaseType();
        String explanation = phoneCase.getExplanation();
        int price = phoneCase.getPrice();
        String img = phoneCase.getImg();
        String detailImg = phoneCase.getDetailImg();
        
        phoneTypes = phoneTypeService.getPhoneType(caseName);
        caseColors = caseColorService.getCaseColor(caseName);
        
        request.setAttribute("caseID", caseID);
        request.setAttribute("caseName", caseName);
        request.setAttribute("caseType", caseType);
        request.setAttribute("explanation", explanation);
        request.setAttribute("price", price);
        request.setAttribute("img", img);
        request.setAttribute("detailImg", detailImg);

        request.setAttribute("user", HttpSession.getAttribute("user"));
        request.setAttribute("phoneCase", HttpSession.getAttribute("phoneCase"));
        request.setAttribute("phoneTypes", phoneTypes);
        request.setAttribute("caseColors", caseColors);
        
        String userType = ((User) HttpSession.getAttribute("user")).getUsertype();    
        
        if(userType.equals("C")){
            view = request.getRequestDispatcher("detailPage.jsp"); //c7stomer 전용
            view.forward(request, response);
        } else {
            view = request.getRequestDispatcher("admin/update.jsp");
            view.forward(request, response);
        }
        
    }
}
