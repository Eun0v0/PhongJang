<%-- 
    Document   : login
    Created on : 2017. 11. 3, ?? 4:28:19
    Author     : yukih
--%>

<%@page session="false" import="java.util.Iterator"%>
<jsp:useBean id="status" scope="request" class="util.Status"/>
<html>
    <head><title>Login Complete!</title></head>
    <body>
        <h2>Login Complete!</h2>
         <form action="main.jsp" method="post">
            <input type="submit" value="main">
    </body>
</html>
