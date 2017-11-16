<%-- 
    Document   : payment
    Created on : 2017. 11. 11, 오후 11:00:51
    Author     : yukih
--%>

<%@page import="domain.Payment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="domain.User"%>
<%@page import="java.util.Iterator" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product List</title>
        <% ArrayList<Payment> payments = (ArrayList<Payment>) request.getAttribute("payments");%>
        <% User user = (User) request.getAttribute("user");%>
        <% session.setAttribute("user", user);%>
    </head>
    <body>
        <table>
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

<center></br></br><input type="image" src="image\orderlist.jpg" name="Submit" value ="complete" aline="absmiddle">
    </br>
    <table>
        <tr>
            <th width="170" height = "35"><img src="image\paynum.jpg" width=170 height=40"></th>
            <th width="170" height = "35"><img src="image\casename2.jpg" width=170 height=40"></th>
            <th width="120" height = "35"><img src="image\amount2.jpg" width=120 height=40"></th>
            <th width="120" height = "35"><img src="image\price.jpg" width=120 height=40"></th>                          
            <th width="230" height = "35"><img src="image\address2.jpg" width=230 height=40"></th>
            <th width="200" height = "35"><img src="image\phonenumber.jpg" width=200 height=40"></th>
            <th width="200" height = "35"><img src="image\deliverystate.jpg" width=200 height=40"></th>
            <th width="200" height = "35"><img src="image\deliverynumber.jpg" width=200 height=40"></th>
        </tr>
        <%
            for (int i = 0; i < payments.size(); i++) {
                Payment payment = payments.get(i);
        %> 
        <tr>
            <td bgcolor="#dcdcdc" align="center" height = "35"><%=payment.getPaymentID()%></td>
            <td bgcolor="#dcdcdc" align="center" height = "35"><%=payment.getCaseName()%></td>
            <td bgcolor="#dcdcdc" align="center" height = "35"><%=payment.getNumbers()%></td>
            <td bgcolor="#dcdcdc" align="center" height = "35"><%=payment.getPrice()%></td>
            <td bgcolor="#dcdcdc" align="center" height = "35"><%=payment.getAddress()%></td>
            <td bgcolor="#dcdcdc"  align="center" height = "35"><%=payment.getPhoneNumber()%></td>    
            <td bgcolor="#dcdcdc"  align="center" height = "35"><%=payment.getStatus()%></td>    
            <td bgcolor="#dcdcdc"  align="center" height = "35"><%=payment.getParcelNumber()%></td>    
            
            <%if((payment.getStatus()).equals("배송중")) { %> 
            <td><a OnClick="alert('배송중에는 취소가 불가능합니다.')" style="cursor:pointer">
                   <input type="Submit" value ="결제 취소">
            </td>
            <% } else { %>
            <td> <form action="deletePayment" method="post">
                <input type="hidden" name="paymentID" value="<%=payment.getPaymentID()%>">
                <% session.setAttribute("paymentID", payment.getPaymentID());%>
                &nbsp;
                <input type="Submit" value ="결제 취소">
                </form></td>
            <% } %>
        <% }%>
    </table>
</center>
</br></br></br></br>
</body>
</html>
