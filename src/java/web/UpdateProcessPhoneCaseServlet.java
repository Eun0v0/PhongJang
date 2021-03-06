/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
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
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.Status;
/**
 * 캐이스 수정 진행 서블릿
*/
public class UpdateProcessPhoneCaseServlet extends HttpServlet {
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }
    public void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        RequestDispatcher view = null;
        Status status = new Status();
        response.setContentType("text/html; charset=euc-kr");
        request.setCharacterEncoding("EUC-KR");
        
        request.setAttribute("status", status);
        String path = request.getRealPath("/image/upload");
        PrintWriter out = response.getWriter();
        
        MultipartRequest multi = new MultipartRequest(request, path, 1024 * 1024 * 5, "euc-kr",
                    new DefaultFileRenamePolicy());
        request.setCharacterEncoding("EUC-KR");
        
        request.setAttribute("status", status);

        HttpSession HttpSession = request.getSession();
        User user = (User) HttpSession.getAttribute("user");
        int caseID = Integer.parseInt(multi.getParameter("caseID"));
        
        ArrayList<PhoneType> phoneTypes = new ArrayList<PhoneType>();
        ArrayList<CaseColor> caseColors = new ArrayList<CaseColor>();
        
        PhoneTypeService phoneTypeService = new PhoneTypeService();
        PhoneCaseService phoneCaseService = new PhoneCaseService();
        CaseColorService caseColorService = new CaseColorService();
        ReviewService reviewService = new ReviewService();
        
        PhoneCase phoneCase;
        phoneCase = phoneCaseService.getPhoneCase(caseID);
        
        String caseName = multi.getParameter("caseName");
        String caseType = multi.getParameter("caseType");
        String explanation = multi.getParameter("explanation");
        int price = Integer.parseInt(multi.getParameter("price"));
        String img = multi.getFilesystemName("img");
        String detailImg = multi.getFilesystemName("detailImg");
        
        ArrayList<Review> reviews = reviewService.reviewRetrieve(caseID); //리뷰글 내용 가져오기
        phoneTypes = phoneTypeService.getPhoneType(caseName);//핸드폰 기종 정보 가져오기
        caseColors = caseColorService.getCaseColor(caseName);//케이스 색상(종류) 정보 가져오기
        
        //이미지를 재업로드 하지 않았을 경우 기존 이미지 사용
        if(img == null){
            img = phoneCase.getImg();
        }
        if(detailImg == null){
            detailImg = phoneCase.getDetailImg();
        }
         
        ArrayList<PhoneCase> phoneCases = new ArrayList<PhoneCase>();
        request.setAttribute("phoneCases", phoneCases);
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
        

        try {
            if ((caseType == null) || (caseType.length() == 0)) {
                status.addException(new Exception(
                        "케이스 타입을 선택해주세요"));
            }
            if ((caseName == null) || (caseName.length() == 0)) {
                status.addException(new Exception(
                        "케이스 이름을 입력해주세요"));
            }
            if ((explanation == null) || (explanation.length() == 0)) {
                status.addException(new Exception(
                        "설명을 입력해주세요"));
            }
            try {
                //(int caseID, String caseType, String caseName, String explanation, int price)
                phoneCaseService.updatePhoneCase(caseID, caseType, caseName, explanation, price, img, detailImg);
                //PhoneCaseService.updatePhoneCase(caseID, caseType, caseName, explanation, price, imgPath);
                
                phoneCases = phoneCaseService.getAllPhoneCase();
                request.setAttribute("phoneCases", phoneCases);
                if (!status.isSuccessful()) {
                    view = request.getRequestDispatcher("admin/update.jsp");
                    view.forward(request, response);
                    return;
                }
                view = request.getRequestDispatcher("admin/update.jsp");
                view.forward(request, response);
            } catch (Exception e) {
                status.addException(e);
                view = request.getRequestDispatcher("admin/update.jsp");
                view.forward(request, response);
            }
        } catch (IllegalArgumentException e) {
            status.addException(e);
            view = request.getRequestDispatcher("admin/update.jsp");
            view.forward(request, response);
        }
    }
}
