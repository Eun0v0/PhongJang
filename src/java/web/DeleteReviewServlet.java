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
/**
 * 리뷰글 삭제
*/
public class DeleteReviewServlet extends HttpServlet {
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
        
        response.setContentType("text/html; charset=euc-kr");
        request.setCharacterEncoding("EUC-KR");
        request.setAttribute("user", HttpSession.getAttribute("user"));
        int caseID = Integer.parseInt(request.getParameter("caseID"));
        ArrayList<PhoneType> phoneTypes = new ArrayList<PhoneType>();
        ArrayList<CaseColor> caseColors = new ArrayList<CaseColor>();
        
        PhoneTypeService phoneTypeService = new PhoneTypeService();
        PhoneCaseService phoneCaseService = new PhoneCaseService();
        CaseColorService caseColorService = new CaseColorService();
        ReviewService reviewService = new ReviewService();
        
        String userID = request.getParameter("userID");
        int replyNum = Integer.parseInt(request.getParameter("replyNum"));
        
        PhoneCase phoneCase;
        phoneCase = phoneCaseService.getPhoneCase(caseID);
        
        reviewService.deleteReview(userID, replyNum, caseID); //해당 리뷰글 삭제
        
        ArrayList<Review> reviews = reviewService.reviewRetrieve(caseID);
        
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
        request.setAttribute("reviews", reviews);
        
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
