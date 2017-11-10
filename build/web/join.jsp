<%-- 
    Document   : join
    Created on : 2017. 11. 4, ?? 6:34:30
    Author     : yukih
--%>
<%@page session="false" import="java.util.Iterator" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr"%>
<jsp:useBean id="status" scope="request" class="util.Status"/>
<html>
    <head><title>회원가입</title></head>
    <body>
        <%  String name = "";
             if (name == null || name.equals("")) { %>
        <img src="image\login.jpg" onClick="location.assign('login.jsp')">
        <% } else { %>
        <img src="image\logout.jpg" onClick="location.assign('logout.jsp')">
        <%  }%>
        <a href="cart_list.jsp"><img src="image\cart.jpg"></a>
        <a href="order_list.jsp"><img src="image\order.jpg"></a>
        <a href="join.jsp"><img src="image\join.jpg"></a>
        <a href="board\board-list.jsp"><img src="image\q&a.jpg"></a>

    <center> <div align="middle"> <img src="image\banner2.jpg" onClick="location.assign('main.jsp')"> </div> </center>

    <%if ((status != null) && !status.isSuccessful()) {%>
    <font color="red">There were problems processing your request:
    <ul><%Iterator errors = status.getExceptions();
        while (errors.hasNext()) {
            Exception ex = (Exception) errors.next();%>
        <li><%= ex.getMessage()%><%}%></ul></font><%}%>
    <form name ="join" action="join" method="post">
        <center> <br>
            <table>
                <tr>
                    <td><img src="image\id.JPG" width=150 height=35"></td>
                    <td><input type="text" name="userID" size="24"></td></tr>
                <tr>
                    <td><img src="image\password.JPG" width=150 height=35"></td>
                    <td><input type="password" name="password" size="24"></td></tr>
                <tr>
                    <td><img src="image\name.jpg" width=150 height=35"></td>
                    <td><input type="text" name="userName" size="24"></td></tr>
                <tr>
                    <td><img src="image\phone.jpg" width=150 height=35"></td>
                    <td><input type="text" name="phoneNumber" size="24"></td></tr>
                <tr>
                    <td><img src="image\address.jpg" width=150 height=35"></td>
                    <td><input type="text" name="address" size="50"></td></tr>
                <tr><td><img src="image\white.jpg" height = 35></td></tr>
            </table>
        </center>
        <center>
            <input type="image" src="image\loginbutton.jpg" name="Submit" value ="Submit" aline="absmiddle">
            <input type="image" src="image\clearbutton.jpg" name="Reset" value ="Reset" aline="absmiddle">
        </center>
    </form>
    <form action="main.jsp" method="post">
        <input type="submit" value="main">
    </form>
</body>
</html>