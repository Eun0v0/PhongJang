<%-- 
    Document   : main
    Created on : 2017. 11. 3, ?? 12:35:30
    Author     : yukih
--%>
<%@page session="false" import="java.util.Iterator"%>
<jsp:useBean id="status" scope="request" class="util.Status"/>
<html>
    <head><title>Login</title></head>
    <body>
        <h2>PhongJang</h2>
        <form action="login.jsp" method="post">
            <input type="submit" value="Login">
        </form>
        if you have not your ID, you should join to my shopping site!
        <form action="join.jsp" method="post">
            <input type="submit" value="Join">
        </form>
        <form method="cart">
            <input type="submit" value="Cart">
        </form>
    </body>
</html>
