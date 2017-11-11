<%-- 
    Document   : payment
    Created on : 2017. 11. 11, 오후 11:00:51
    Author     : yukih
--%>

<%@page import="domain.Payment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="domain.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product List</title>
        <% ArrayList<Payment> payments = (ArrayList<Payment>) request.getAttribute("payments");%>
        <% User user = (User) request.getAttribute("user");%>
        <% session.setAttribute("user", user);%>
    </head>
    <body>
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
        <h2><%= user.getName()%>님 주문 목록 입니다.</h2>
        <table border="2px">
            <tr>
                <th width="100">결제 번호</th>
                <th width="100">제품명</th>
                <th width="100">수량</th>               
                <th width="100">가격</th>                                
                <th width="200">주소</th>
                <th width="200">전화번호</th>
            </tr>
            <%
                for (int i = 0; i < payments.size(); i++) {
                    Payment payment = payments.get(i);
            %> 
            <tr>
                <td align="center"><%=payment.getPaymentID()%></td>
                <td align="center"><%=payment.getCaseName()%></td>
                <td align="center"><%=payment.getNumbers()%></td>
                <td align="center"><%=payment.getPrice()%></td>
                <td align="center"><%=payment.getAddress()%></td>
                <td align="center"><%=payment.getPhoneNumber()%></td>                
            </tr>
            <% }%>
        </table>
    </body>
</html>
