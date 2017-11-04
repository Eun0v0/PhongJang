<%-- 
    Document   : join
    Created on : 2017. 11. 4, ?? 6:34:30
    Author     : yukih
--%>
<%@page session="false" import="java.util.Iterator"%>
<jsp:useBean id="status" scope="request" class="util.Status"/>
<html>
    <head><title>Join Form</title></head>
    <body>
        <h2>Join Form</h2>
        <%if ((status != null) && !status.isSuccessful()) {%>
        <font color="red">There were problems processing your request:
        <ul><%Iterator errors = status.getExceptions();
            while (errors.hasNext()) {
                Exception ex = (Exception) errors.next();%>
            <li><%= ex.getMessage()%><%}%></ul></font><%}%>
        <form action="join" method="post">
            <table>
                <tr><td>UserID:</td><td>
                        <input type="text" name="userID" size="24"></td></tr>
                <tr><td>Password:</td><td>
                        <input type="password" name="password" size="24"></td></tr>
                <tr><td>Username:</td><td>
                        <input type="text" name="userName" size="24"></td></tr>
                <tr><td>PhoneNumber:</td><td>
                        <input type="text" name="phoneNumber" size="24"></td></tr>
                <tr><td>Address:</td><td>
                        <input type="text" name="address" size="50"></td></tr></table>
            <input type="submit" value="Submit">
        </form>         
    </body>
</html>