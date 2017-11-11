<%-- 
    Document   : login
    Created on : 2017. 11. 4, 오후 7:17:19
    Author     : yukih
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="domain.PhoneCase"%>
<%@page import="domain.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>퐁장 상품 목록</title>
        <% ArrayList<PhoneCase> phoneCase = (ArrayList<PhoneCase>) request.getAttribute("phoneCases");%>
        <% User user = (User) request.getAttribute("user");%>
        <%session.setAttribute("user", user);%>
    </head>
    <body>
        <h1>안녕하세요, <%=user.getName()%>님</h1>
        <h2>퐁장 상품 목록</h2>
        <form action="cart" method="post">
            <input type="hidden" name="userID" value="<%=user.getId()%>">
            <input type="submit" value="장바구니">
        </form>
        <form action="search" method="post">
            상품 검색 :
            <input type="text" name="caseName" size="24">
            <input type="submit" value="검색">
        </form>
        <table border="2px">
            <tr>
                <th width="100">케이스 ID</th>
                <th width="150">케이스 이름</th>
                <th width="200">타입</th>
                <th width="400">설명</th>
                <th width="150">가격</th>
                <th width="200">장바구니에 담기</th>
            </tr>
            <%
                for (int i = 0; i < phoneCase.size(); i++) {
                    PhoneCase phonecase = phoneCase.get(i);
            %> 
            <tr>
                <td align="center"><%=phonecase.getCaseID()%></td>
                <td align="center"><%=phonecase.getCaseName()%></td>
                <td align="center"><%=phonecase.getCaseType()%></td>
                <td align="center"><%=phonecase.getExplanation()%></td>
                <td align="center"><%=phonecase.getPrice()%>원</td>
                <td align="center">
                    <form action="take" method="post">
                        원하는 수량을 입력하세요 :
                        <input type="hidden" name="userID" value="<%=user.getId()%>">
                        <input type="hidden" name="caseID" value="<%=phonecase.getCaseID()%>">
                        <input type="text" name ="numbers" size="5">
                        <input type="submit" value="담기">
                   </form>
            </tr>
            <% } %>
        </table>
        <form action="main.jsp" method="post">
            <input type="submit" value="메인으로">
    </body>
</html>
