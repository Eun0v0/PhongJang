<%-- 
    Document   : payment
    Created on : 2017. 11. 12, 오후 6:52:01
    Author     : yukih
--%>
<%@page import="domain.PhoneCase"%>
<%@page import="domain.Payment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="domain.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product List</title>
        
        <% ArrayList<PhoneCase> phoneCases = (ArrayList<PhoneCase>) request.getAttribute("phoneCases");%>       
        <% ArrayList<Payment> payments = (ArrayList<Payment>) request.getAttribute("payments");%>
        <% User user = (User) request.getAttribute("user");%>
        <% session.setAttribute("user", user);%>
        <% session.setAttribute("phoneCases", phoneCases);%>
        
    </head>
    <body>
        <h2>Hello, <%= user.getName()%></h2>
        <table border="2px">
            <tr>
                <th width="100">결제 번호</th>
                <th width="100">주문자 ID</th>
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
                <td align="center"><%=payment.getUserID()%></td>                
                <td align="center"><%=payment.getCaseName()%></td>
                <td align="center"><%=payment.getNumbers()%></td>
                <td align="center"><%=payment.getPrice()%></td>
                <td align="center"><%=payment.getAddress()%></td>
                <td align="center"><%=payment.getPhoneNumber()%></td>                
            </tr>
            <% }%>
        </table>
        
        <form action="main" method="post">
            <input type="hidden" name="userID" value="<%=user.getId()%>">
            <input type="submit" value="메인으로">
        </form> 
    </body>
</html>​
