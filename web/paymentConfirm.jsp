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
        <h1>결제 완료!</h1>
        <form action="main.jsp" method="post">
            <input type="submit" value="main">
        </form>
        <form action="paymentlist" method="post">
            <input type="submit" value="결제 내역">
        </form>
        
    </body>
</html>

