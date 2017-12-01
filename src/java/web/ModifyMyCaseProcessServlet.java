package web;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import domain.MyCase;
import domain.MyCaseService;
import domain.ReplyMyCase;
import domain.ReplyMyCaseService;
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
import util.Status;
/**
 * 케이스 정보 수정 서블릿
*/
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
        
        response.setContentType("text/html; charset=euc-kr");
        String path = request.getRealPath("/image/upload");
        PrintWriter out = response.getWriter();
        
        MultipartRequest multi = new MultipartRequest(request, path, 1024 * 1024 * 5, "euc-kr",
                    new DefaultFileRenamePolicy());
       
        User user = (User) HttpSession.getAttribute("user");
        MyCase myCase = (MyCase) HttpSession.getAttribute("myCase");
        MyCase s_myCase = null;
        MyCaseService myCaseService = new MyCaseService();

        ReplyMyCase replyMyCase;
        ReplyMyCaseService replyMyCaseService = new ReplyMyCaseService();

        String userID = user.getId();
        request.setCharacterEncoding("EUC-KR");

        int myCaseNum = Integer.parseInt(multi.getParameter("myCaseNum"));
        String title = multi.getParameter("title");
        String caseType = multi.getParameter("caseType");
        String phoneType = multi.getParameter("phoneType");
        String color = multi.getParameter("color");
        String content = multi.getParameter("content");
        String image = multi.getFilesystemName("caseImage");
        replyMyCase = replyMyCaseService.getMyCaseReply(myCaseNum);
        
        //재업로드한 사진이 없을 경우 기존 이미지로 유지
        if(image == null){
            image = myCase.getImage();
        }
        try {
            //정보 업데이트
            myCaseService.myCaseUpdate(myCaseNum, title, caseType, phoneType, color, content, image);
            s_myCase = myCaseService.getMyCase(myCaseNum);

            request.setCharacterEncoding("EUC-KR");
            ArrayList<MyCase> myCases = new ArrayList<MyCase>();
            myCases = myCaseService.getAllMyCases(userID);
            request.setAttribute("myCases", myCases);
            request.setAttribute("myCase", s_myCase);
            request.setAttribute("user", user);
            request.setAttribute("replyMyCase",replyMyCase);

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
