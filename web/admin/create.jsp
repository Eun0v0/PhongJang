<%-- 
    Document   : create
    Created on : 2017. 11. 12, 오후 7:53:47
    Author     : yukih
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="domain.User"%>
<%@page import="java.util.Iterator"%>
<jsp:useBean id="status" scope="request" class="util.Status"/>
<html>
    <head><title>상품 추가</title>
        <%  User user = (User) request.getAttribute("user");
            session.setAttribute("user", user);%></head>
    <body>
        <h2>Hello, <%=user.getName()%><br/>상품 추가 페이지 입니다.</h2>
        <%if ((status != null) && !status.isSuccessful()) {%>
        <font color="red">There were problems processing your request:
        <ul><%Iterator errors = status.getExceptions();
            while (errors.hasNext()) {
                Exception ex = (Exception) errors.next();%>
            <li><%= ex.getMessage()%><%}%></ul></font><%}%>
        <form action="createprocess" method="post">
            <table>
                <tr><td>케이스 타입:</td><td>
                        <input type="text" name="caseType" size="20"></td></tr>
                <tr><td>케이스 이름:</td><td>
                        <input type="text" name="caseName" size="20"></td></tr>
                <tr><td>설명:</td><td>
                        <input type="text" name="explanation" size="50"></td></tr>
                <tr><td>가격:</td><td>
                        <input type="text" name="price" size="5"></td></tr>
                
            </table>
            <input type="submit" value="Submit">
        </form>         
    </body>
</html>
