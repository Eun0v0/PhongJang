<%-- 
    Document   : login
    Created on : 2017. 11. 3, ?? 4:28:19
    Author     : yukih
--%>

<%@page import="domain.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="domain.PhoneCase"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product List</title>
        <% ArrayList<PhoneCase> phoneCases = (ArrayList<PhoneCase>) request.getAttribute("phoneCases");%>
        <% User user = (User) request.getAttribute("user");%>
        <% session.setAttribute("user", user);%>
    </head>
    <body>
        <h2>Hello, <%= user.getName()%></h2>
        <form action="paymentlist" method="post">
            <input type="submit" value="모든 결제내역">
        </form>        
        <table border="2px">
            <tr>
                <th width="100">케이스 ID</th>
                <th width="150">타입</th>
                <th width="200">케이스 이름</th>
                <th width="400">설명</th>
                <th width="150">가격</th>
            </tr>
            <%
                for (int i = 0; i < phoneCases.size(); i++) {
                    PhoneCase phoneCase = phoneCases.get(i);
            %> 
            <tr>
                <td align="center"><%=phoneCase.getCaseID()%></td>
                <td align="center"><%=phoneCase.getCaseType()%></td>
                <td align="center"><%=phoneCase.getCaseName()%></td>
                <td align="center"><%=phoneCase.getExplanation()%></td>
                <td align="center">$<%=phoneCase.getPrice()%></td>
            </tr>
            <% }%>
        </table>
    </body>
</html>
