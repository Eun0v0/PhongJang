<%-- 
    Document   : login
    Created on : 2017. 11. 4, ?? 11:10:29
    Author     : yukih
--%>

<%@page session="false" import="java.util.Iterator" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr"%>
<jsp:useBean id="status" scope="request" class="util.Status"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>로그인</title>
    </head>
    <body>
        <h2>퐁장 로그인</h2>
        <%if ((status != null) && !status.isSuccessful()) {%>
        <font color="red">There were problems processing your request:
        <ul><%Iterator errors = status.getExceptions();
            while (errors.hasNext()) {
                Exception ex = (Exception) errors.next();%>
            <li><%= ex.getMessage()%><%}%></ul></font><%}%>
        <form action="login" method="post">
            <table>
                <tr><td>유저 타입:</td>
                    <td><select name="usertype">
                            <option name="usertype" value="unknown">-----
                            <option name="usertype" value="A">관리자
                            <option name="usertype" value="C">고객</select></td></tr>
                <tr><td>ID:</td><td>
                        <input type="text" name="userID" size="24"></td></tr>
                <tr><td>Password:</td><td>
                        <input type="password" name="password" size="24"></td></tr></table>
            <input type="submit" value="Submit">
        </form>
        <form action="main.jsp" method="post">
            <input type="submit" value="main">
        </form>
    </body>
</html>
