/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import domain.User;
import domain.UserService;
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
 *
 * @author Hayoung_2 비밀번호 찾기
 */
public final class SearchPwdServlet extends HttpServlet {

    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    //검색 함수?
    public void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        RequestDispatcher view = null;
        UserService userService = new UserService();
        request.setCharacterEncoding("EUC-KR");
        HttpSession HttpSession = request.getSession();
        User user = (User) HttpSession.getAttribute("user");
        Status status = new Status();

        String userID = request.getParameter("userID");
        String PhoneNum = request.getParameter("PhoneNum");

        try {
            if ((userID.isEmpty())) {
                status.addException(new Exception(
                        "아이디를 입력해주세요"));
            }
            if ((PhoneNum.isEmpty())) {
                status.addException(new Exception(
                        "핸드폰 번호를 입력해주세요"));
            }
            try {
                //공란이 없다면 업데이트
                if (!userID.isEmpty() && !PhoneNum.isEmpty()) {
                    user = userService.getSearchPwd(userID, PhoneNum);//해당 유저의 정보를 가져옴
                }
                String userPwd = user.getPw();//비밀번호를 가져옴

                if ((userPwd == null) || (userPwd.length() == 0)) {
                    status.addException(new Exception(
                            "해당 정보를 찾을 수 없습니다."));
                }
                if (!status.isSuccessful()) {
                    view = request.getRequestDispatcher("searchPwd.jsp");
                    view.forward(request, response);
                    return;
                }
                request.setAttribute("userPwd", userPwd);
                view = request.getRequestDispatcher("searchPwdList.jsp");
                view.forward(request, response);

            } catch (Exception e) {
                status.addException(e);
                view = request.getRequestDispatcher("searchPwd.jsp");
                view.forward(request, response);
            }
        } catch (IllegalArgumentException e) {
            status.addException(e);
            view = request.getRequestDispatcher("searchPwd.jsp");
            view.forward(request, response);
        }
    }
}
