<%-- 
    Document   : cart.jsp
    Created on : 2017. 11. 9, 오후 9:34:45
    Author     : yukih
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="domain.Cart"%>
<%@page import="domain.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>장바구니</title>
        <%ArrayList<Cart> carts = (ArrayList<Cart>)request.getAttribute("carts");%>
        <%User user = (User) request.getAttribute("user");%>
        <%session.setAttribute("user", user);%>
    </head>
    <body>
        <h1><%= user.getName()%>, 고객님 장바구니 입니다.</h1>
        <table border="2px">
            <tr>
                <th width="100">장바구니 ID</th>
                <th width="150">고객 이름</th>
                <th width="200">제품 ID</th>
                <th width="400">수량</th>
            </tr>
            <%
                for (int i = 0; i < carts.size(); i++) {
                    Cart cart = carts.get(i);
            %>
            <tr>
                <td align="center"><%=cart.getCartID()%></td>
                <td align="center"><%=cart.getUserID()%></td>
                <td align="center"><%=cart.getCaseID()%></td>
                <td align="center"><%=cart.getNumbers()%></td>
                <td align ="center">
                    <form action="delete" method="post">
                        <input type="hidden" name="cartID" value="<%=cart.getCartID()%>">
                        <input type="hidden" name="userID" value="<%=user.getId()%>">
                        <input type="submit" value="삭제">
                    </form></td>
            </tr>
            <% } %>
        </table>
        <form action="main.jsp" method="post">
            <input type="hidden" name="userID" value="<%=user.getId()%>">
            <input type="submit" value="메인으로">
        </form>
    </body>
</html>
