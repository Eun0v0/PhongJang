<%-- 
    Document   : login
    Created on : 2017. 11. 4, ?? 11:10:29
    Author     : yukih
--%>

<%@page session="false" import="java.util.Iterator"%>
<jsp:useBean id="status" scope="request" class="util.Status"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>PhongJang Login</h2>
        <%if ((status != null) && !status.isSuccessful()) {%>
        <font color="red">There were problems processing your request:
        <ul><%Iterator errors = status.getExceptions();
            while (errors.hasNext()) {
                Exception ex = (Exception) errors.next();%>
            <li><%= ex.getMessage()%><%}%></ul></font><%}%>
        <form action="login" method="post">
            <table>
                <tr><td>Login Select:</td>
                    <td><select name="usertype">
                            <option name="usertype" value="unknown">Your Select
                            <option name="usertype" value="A">Administrator
                            <option name="usertype" value="C">Customer</select></td></tr>
                <tr><td>UserID:</td><td>
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
