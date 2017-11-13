<%-- 
    Document   : paymentConfirm
    Created on : 2017. 11. 11, 오후 10:56:28
    Author     : yukih
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>결제 완료!</title>
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
                <% } else { session.setAttribute("user", user); %>
            <td><img src="image\logout.jpg" onClick="location.assign('logout.jsp')"></td>
            <td><form action="cart" method="post">
                    <input type="hidden" name="userID" value="<%=user.getId()%>">
                    <input type="image" src="image\cart.jpg" name="Submit" value ="장바구니">
                </form> 
            </td>
            <td><form action="paymentlist" method="post">
                    <input type="image" src="image\order.jpg" name="Submit" value ="주문 목록">
                </form>    
            </td>
                <%  }%>
            
            <td><a href="join.jsp"><img src="image\join.jpg"></a></td>
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

        <h1>결제 완료!</h1>
        <form action="main.jsp" method="post">
            <input type="submit" value="main">
        </form>
        <form action="paymentlist" method="post">
            <input type="submit" value="결제 내역">
        </form>
        
    </body>
</html>

