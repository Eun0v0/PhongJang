<%-- 
    Document   : qnaCreate
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    Created on : 2017. 11. 21, ???? 1:08:11
=======
    Created on : 2017. 11. 22, 오후 8:24:14
>>>>>>> 60686308e1d6f2449b4a273da030dbb69f1cb072
=======
    Created on : 2017. 11. 22, 오후 8:24:14
>>>>>>> 60686308e1d6f2449b4a273da030dbb69f1cb072
=======
    Created on : 2017. 11. 22, 오후 8:24:14
>>>>>>> 4d66c32f8041698e6c3f0a1e3eabda29173218c3
    Author     : user
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="domain.User"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="domain.Qna"%>
<%@page import="java.util.Iterator" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr"%>
<jsp:useBean id="status" scope="request" class="util.Status"/>
<!DOCTYPE html>
<html>
    <head>
        <%--<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">--%>
        <title>Q&A 작성하기</title>
        <% ArrayList<Qna> qnas = (ArrayList<Qna>) request.getAttribute("qnas");%>
        <%User user = (User) request.getAttribute("user");%>
        <%session.setAttribute("user", user);%>
        <%session.setAttribute("qnas", qnas);%>
    </head>
    <body>
        <table border="0px">
            <tr>
                <%
                    if (user == null) { %>
                <td><img src="image\login.jpg" onClick="location.assign('login.jsp')"></td>
                <td><a OnClick="alert('로그인을 해주세요!')" style="cursor:pointer">
                        <img src="image\cart.jpg"></a>
                </td>
                <td><a OnClick="alert('로그인을 해주세요!')" style="cursor:pointer">
                        <img src="image\order.jpg"></a>
                </td>
                <td><a OnClick="alert('로그인을 해주세요!')" style="cursor:pointer">
                        &nbsp;
                        <input type="image" src="image\myPageUp_1.jpg" name="Submit" value ="MY PAGE"></a>
                </td>
                <% } else {
                    session.setAttribute("user", user);%>
                <td><form action="logout" method="post">
                        <input type="image" src="image\logout.jpg" name="Submit" value ="로그아웃">
                    </form> 
                </td>
                <td><form action="cart" method="post">
                        <input type="hidden" name="userID" value="<%=user.getId()%>">
                        <input type="image" src="image\cart.jpg" name="Submit" value ="장바구니">
                    </form> 
                </td>

                <td><form action="paymentlist" method="post">
                        <input type="image" src="image\order.jpg" name="Submit" value ="주문 목록">
                    </form>    
                </td>
                <td><form action="myPage" method="post">
                        <input type="hidden" name="userID" value="<%=user.getId()%>">
                        &nbsp;
                        <input type="image" src="image\myPageUp_1.jpg" name="Submit" value ="MY PAGE">
                    </form>    
                </td>
                <%  }%>
                <td><form action="IDCheck" method="post">
                        <input type="image" src="image\join.jpg" name="Submit" value ="회원가입">
                    </form>    
                </td>

                <td><a href="board\board-list.jsp"><img src="image\q&a.jpg"></a></td>
            </tr>
        </table>
        <% if (user != null) {%>
    <center> <div align="middle">
            <form action="main" method="post">
                <input type="hidden" name="userID" value="<%=user.getId()%>">
                <input type="image" src="image\banner.jpg" name="Submit">
            </form>
        </div> </center>
        <% } else {%>
    <center> <div align="middle"> <img src="image\banner2.jpg" onClick="location.assign('main.jsp')"> </div> </center>
            <% }%>

    <form action ="search" method="post">
        <img src="image\search.png" height="17" width="17">
        <input type="text" size="16" name="caseName">
        <input type="submit" value="검색">
    </form>

    <hr size="5" color="black">
    <center>
        <a href="Top-main.jsp"><img src="image\customCase3.jpg" height="35" width="140"></a>
        <img src="image\space.jpg" height="35" width="80">
        <a href="Bottom-main.jsp"><img src="image\bumperCase2.jpg" height="35" width="140"></a>
        <img src="image\space.jpg" height="35" width="80">
        <a href="Outer-main.jsp"><img src="image\hardCase.jpg" height="35" width="140"></a>
        <img src="image\space.jpg" height="35" width="80">
        <a href="Sho-main.jsp"><img src="image\jellyCase.jpg" height="35" width="140"></a>
        <img src="image\space.jpg" height="35" width="80">
        <a href="event.jsp"><img src="image\event_.jpg" height="35" width="140"></a>
    </center>
    <hr size="5" color="black">
    
    <%if ((status != null) && !status.isSuccessful()) {%>
    <font color="red">There were problems processing your request:
    <ul><%Iterator errors = status.getExceptions();
        while (errors.hasNext()) {
            Exception ex = (Exception) errors.next();%>
        <li><%= ex.getMessage()%><%}%></ul></font>    
        <%}%>
    <center></br></br><img src="image\qnawrite.jpg"><br></center>
    <center>
        <form action="writeQna" methor="post">
            <table>
                <tr>
                    <td><center>
                        <tr height="1" bgcolor="#ECBFD8"><td colspan="4"></td></tr>
                        <tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
                        <tr>
                            <td>&nbsp;</td>
                            <th width="120" height="35">제목</th>
                            <td><input name="qnaTitle" size="48" maxlength="100"></td>
                            <td>&nbsp;</td>
                        </tr>
                        <tr height="1" bgcolor="#dddddd"><td colspan="3"></td></tr>
                        <tr>
                            <td>&nbsp;</td>
                            <th width="120" height="35">작성자</th>
                            <td><input name="userName" size="48" maxlength="50"></td>
                            <td>&nbsp;</td>
                        </tr>
                        <tr height="1" bgcolor="#dddddd"><td colspan="3"></td></tr>
                        <tr>
                            <td>&nbsp;</td>
                            <th width="60" height="35">비밀번호</th>
                            <td><input name="passWord" size="48" maxlength="50"></td>
                            <td>&nbsp;</td>
                        </tr>
                        <tr height="1" bgcolor="#dddddd"><td colspan="3"></td></tr>
                        <tr>
                            <td>&nbsp;</td>
                            <th width="60" height="35">내용</th>
                            <td><textarea name="qnaContent" cols="50" rows="13"></textarea></td>
                            <td>&nbsp;</td>
                        </tr>
                        <tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
                        <tr height="1" bgcolor="#ECBFD8"><td colspan="4"></td></tr>
                        <tr align="center">
                            <td>&nbsp;</td><br>
                        <td colspan="2">
                            <input type="submit" value="등록">
                        <td>&nbsp;</td>
                        </tr>      
                </center></td></tr>
            </table>
            </form>
    </center>
</body>
</html>
