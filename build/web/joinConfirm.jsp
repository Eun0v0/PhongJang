<%-- 
    Document   : joinConfirm
    Created on : 2017. 11. 4, 오후 6:44:38
    Author     : yukih
--%>
<%-- test --%>
<%@page import="domain.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>회원가입 완료</title>
    </head>
    <body>
        <table border="0px">
        <tr>
            <%  User user = (User) request.getAttribute("user");
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
                <% } else { session.setAttribute("user", user); %>
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
            <% if (user != null) { %>
            <center> <div align="middle">
                <form action="main" method="post">
                    <input type="hidden" name="userID" value="<%=user.getId()%>">
                    <input type="image" src="image\banner.jpg" name="Submit">
                </form>
            </div> </center>
            <% } else {%>
            <center> <div align="middle"> <img src="image\banner2.jpg" onClick="location.assign('main.jsp')"> </div> </center>
            <% } %>
            
            <form action ="search" method="post">
                <img src="image\search.png" height="17" width="17">
                <input type="text" size="16" name="caseName">
                <input type="submit" value="검색">
            </form>
                
    <hr size="5" color="black">
        <h1>회원가입 완료!</h1>
        <form action="main.jsp" method="post">
            <input type="submit" value="main">
    </body>
</html>
