
package web;

import java.io.IOException;
import java.io.PrintWriter;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import domain.PhoneCase;
import domain.PhoneCaseService;
import domain.User;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.oreilly.servlet.MultipartRequest;
import domain.CaseColorService;
import domain.PhoneType;
import domain.PhoneTypeService;
import java.io.File;
import util.Status;


public class ProcessPhoneCaseServlet extends HttpServlet {
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

        PhoneCaseService PhoneCaseService = new PhoneCaseService();
        PhoneTypeService phoneTypeService = new PhoneTypeService();
        CaseColorService caseColorService = new CaseColorService();
        HttpSession HttpSession = request.getSession();
        User user = (User) HttpSession.getAttribute("user");
        ArrayList<PhoneCase> phoneCases = new ArrayList<PhoneCase>();
        
        phoneCases = PhoneCaseService.getAllPhoneCase();
        request.setAttribute("phoneCases", phoneCases);
        request.setAttribute("user", user);
        
        try {
            String caseName = multi.getParameter("caseName");
            String caseType = multi.getParameter("caseType");
            String explanation = multi.getParameter("explanation");
            int price = Integer.parseInt(multi.getParameter("price"));
            String img = multi.getFilesystemName("img");
            String detailImg = multi.getFilesystemName("detailImg");
            int stock = 0; //인기 케이스 카운트를 위한 것
            String [] select_phoneTypes = multi.getParameterValues("phoneType"); //핸드폰 기종 체크박스에서 받아오기
            String [] selet_caseColors = multi.getParameterValues("color"); //핸드폰 기종 체크박스에서 받아오기
            
            if ((caseType == null) || (caseType.length() == 0)) {
                status.addException(new Exception(
                        " 케이스 타입을 입력해주세요"));
            }
            if ((caseName == null) || (caseName.length() == 0)) {
                status.addException(new Exception(
                        "케이스 이름을 입력해주세요"));
            }
            if ((explanation == null) || (explanation.length() == 0)) {
                status.addException(new Exception(
                        "설명을 입력해주세요"));
            }
            if ((price == 0)) {
                status.addException(new Exception(
                        "상품 가격은 0일수 없습니다."));
            }
          
            try {
                PhoneCaseService.insertPhoneCase(caseType, caseName, explanation, price, img, detailImg, stock);
                
                for(int i=0; i<select_phoneTypes.length; i++){
                    phoneTypeService.phoneTypeInsert(caseName,select_phoneTypes[i]);
                }
                for(int i=0; i<selet_caseColors.length; i++){
                    if((selet_caseColors[i]).isEmpty()){
                        break;
                    } else {
                        caseColorService.caseColorInsert(caseName,selet_caseColors[i]);
                    }
                }
                
                phoneCases = PhoneCaseService.getAllPhoneCase();
                request.setAttribute("phoneCases", phoneCases);
                if (!status.isSuccessful()) {
                    view = request.getRequestDispatcher("admin/create.jsp");
                    view.forward(request, response);
                    return;
                }
                view = request.getRequestDispatcher("admin/main.jsp");
                view.forward(request, response);
            } catch (Exception e) {
                status.addException(e);
                view = request.getRequestDispatcher("admin/create.jsp");
                view.forward(request, response);
            }
        } catch (IllegalArgumentException e) {
            status.addException(e);
            view = request.getRequestDispatcher("admin/create.jsp");
            view.forward(request, response);
        }
    }
}
