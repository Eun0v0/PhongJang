<%-- 
    Document   : OracleConnection
    Created on : 2017. 11. 2, 오후 11:22:54
    Author     : yukih
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>데이터베이스 연동 성공!</h1>
        <% Connection conn = null;
            String driverName= "oracle.jdbc.driver.OracleDriver";
            Class.forName(driverName);
            String serverName = "localhost";
            String serverPort = "1521";
            String sid = "orcl";
            String url = "jdbc:oracle:thin:@" + serverName+ ":" + serverPort + ":" + sid;
            String username = "C##phongjang";
            String password = "1111";
            conn = DriverManager.getConnection(url, username, password);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from shoppinguser");
            while (rs.next()) {%>
        User Id: <%= rs.getString(1)%><br/>
        User Type : <%=rs.getString(2)%> <br/>
        User Name : <%=rs.getString(3)%> <br/>
        Password : <%=rs.getString(4)%> <br/>
        PhoneNum : <%=rs.getString(5)%> <br/>
        Address : <%=rs.getString(6)%>
        <% }
        rs.close();%>
    </body>
</html>
