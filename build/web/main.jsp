<%-- 
    Document   : main
    Created on : 2017. 11. 3, ?? 12:35:30
    Author     : yukih
--%>
<%@page session="false" import="java.util.Iterator" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr"%>
<jsp:useBean id="status" scope="request" class="util.Status"/>
<html>
    <head><title>Login</title></head>
    <body>
        <h2>퐁장</h2>
        <form action="login.jsp" method="post">
            <input type="submit" value="Login">
        </form>
        회원이 아니라면, 회원가입을 해주세요 :-)
        <form action="join.jsp" method="post">
            <input type="submit" value="Join">
        </form>
        <form method="cart">
            <input type="submit" value="Cart">
        </form>
    </body>
</html>