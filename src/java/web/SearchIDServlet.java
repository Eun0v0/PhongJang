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
 * @author Hayoung_2 ID찾기
 */
public final class SearchIDServlet extends HttpServlet {

    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    public void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        RequestDispatcher view = null;
        UserService userService = new UserService();
        Status status = new Status();

        request.setCharacterEncoding("EUC-KR");
        HttpSession HttpSession = request.getSession();
        User user = (User) HttpSession.getAttribute("user");

        String userName = request.getParameter("userName");
        String PhoneNum = request.getParameter("PhoneNum");

        if ((userName.isEmpty())) {
            status.addException(new Exception(
                    "이름을 입력해주세요"));
        }
        if ((PhoneNum.isEmpty())) {
            status.addException(new Exception(
                    "핸드폰 번호를 입력해주세요"));
        }
        try {
            //공란이 없다면 업데이트
            if (!userName.isEmpty() && !PhoneNum.isEmpty()) {
                user = userService.getSearchID(userName, PhoneNum); // 유저정보를 찾아옴
            }
            String userID = user.getId(); // ID를 가져옴

            if ((userID == null) || (userID.length() == 0)) {
                status.addException(new Exception(
                        "해당 아이디가 존재하지 않습니다."));
            }
            request.setAttribute("userID", userID);
            if (!status.isSuccessful()) {
                view = request.getRequestDispatcher("searchID.jsp");
                view.forward(request, response);
                return;
            }
            view = request.getRequestDispatcher("searchIDList.jsp");
            view.forward(request, response);

        } catch (Exception e) {
            status.addException(e);
            view = request.getRequestDispatcher("searchID.jsp");
            view.forward(request, response);
        }
    }
}
