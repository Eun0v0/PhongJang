<%-- 
    Document   : cart.jsp
    Created on : 2017. 11. 9, 오후 9:34:45
    Author     : yukih
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="domain.Cart"%>
<%@page import="domain.User"%>
<%@page import="java.util.Iterator" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>내 정보</title>
        <%User user = (User) request.getAttribute("user");%>
        <%session.setAttribute("user", user);%>
    </head>
    <body>
        <table border="0px">
            <tr>
                <%
                    if (user == null) { %>
                <td><img src="image\login.jpg" onClick="location.assign('login.jsp')"></td>
                <td><td><a href="cart.jsp"><img src="image\cart.jpg"></a></td>
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
                  
            </td>
                    <%  }%>

                <td><a href="join.jsp"><img src="image\join.jpg"></a></td>
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
    
    <form action ="search.action" name="search" method="search">
        <img src="image\search.png" height="17" width="17">
        <input type="text" size="16" name="keyword" value="${keyword}">
        <input type="button" value="검색" onClick="check()">
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

    <br>
    <center> <img src="image\shoppingcart.jpg" width=200 height=60"> </center>
    <center> <br>
    <!--<h2><%= user.getName()%> 고객님 회원 정보 입니다.</h2>-->

        <table>
            <tr>
                <th width="170" height = "35"><img src="image\casename2.jpg" width=170 height=40"></th>
                <th width="120" height = "35"><img src="image\color.jpg" width=120 height=40"></th>
                <th width="120" height = "35"><img src="image\amount2.jpg" width=120 height=40"></th>
                <th width="120" height = "35"><img src="image\price.jpg" width=120 height=40"></th>
                <th width="40" height = "35"><img src="image\blank2.jpg" width=50 height=40"></th>

            </tr>
            
            <form action="updateMyInfo" method="post">
            <table>
                
                <tr><td>이름:</td><td>
                        <textarea name="userName" size="20"><%=request.getAttribute("userName")%></textarea>
                <tr><td>ID:</td><td>
                        <%=request.getAttribute("userID")%>
                <tr><td>핸드폰 번호:</td><td>
                        <textarea name="phoneNumber" size="20"><%=request.getAttribute("phoneNumber")%></textarea>
                <tr><td>주소:</td><td>
                        <textarea name = "address" size="50"><%= request.getAttribute("address")%></textarea>
            </table>
            <input type="submit" value="수정하기">
        </form>  
        <form action="myPage" method="post">
            <input type="hidden" name="userID" value="<%=user.getId()%>">
            &nbsp;
            <input type="image" src="image\myPageUp_1.jpg" name="Submit" value ="MY PAGE">
        </form> 
    </center>
    </body>
</html>
