<%-- 
    Document   : create
    Created on : 2017. 11. 12, ���� 7:53:47
    Author     : yukih
--%>
<%-- test --%>
<%@page import="java.util.Iterator" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr"%>
<%@page import="domain.User"%>
<jsp:useBean id="status" scope="request" class="util.Status"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>��ǰ �߰�</title>
        <%  User user = (User) request.getAttribute("user");
            session.setAttribute("user", user);%></head>
    <body>
                <table border="0px">
        <tr>
            <% if (user == null) { %>
            <td><img src="image\login.jpg" onClick="location.assign('login.jsp')"></td>
            <td><a OnClick="alert('�α����� ���ּ���!')" style="cursor:pointer">
                <input type="submit" value="��ǰ ����">
                </a></td>
            <td><a OnClick="alert('�α����� ���ּ���!')" style="cursor:pointer">
                    <img src="image\order.jpg"></a>
            </td>
            
                <% } else { session.setAttribute("user", user); %>
            <td><form action="logout" method="post">
                    <input type="image" src="image\logout.jpg" name="Submit" value ="�α׾ƿ�">
                </form> 
            </td>
            <td><form action="managePhoneCase" method="post">
                    <input type="submit" value="��ǰ ����">
                </form>
            </td>
            
            <td><form action="paymentlist" method="post">
                    <input type="image" src="image\order.jpg" name="Submit" value="��� ��������">
                </form> 
            </td>
            
                <%  }%>
           
            <td><a href="board\board-list.jsp"><img src="image\q&a.jpg"></a></td>
        </tr>
    </table>
            <% if (user != null) { %>
            <center> <div align="middle">
                <form action="main" method="post">
                    <input type="hidden" name="userID" value="<%=user.getId()%>">
                    <input type="image" src="image\banner.jpg" name="Submit">
                </form>
            </div> </center>
            <% } else {%>
            <center> <div align="middle"> <img src="image\banner2.jpg" onClick="location.assign('admin/main.jsp')"> </div> </center>
            <% } %>
            
            <form action ="search" method="post">
                <img src="image\search.png" height="17" width="17">
                <input type="text" size="16" name="caseName">
                <input type="submit" value="�˻�">
            </form>
                
    <hr size="5" color="black">
    <center>
        <a href="Top-main.jsp"><img src="image\customCase3.jpg" height="35" width="140"></a>
        <img src="image\space.jpg" height="35" width="80">
        <a href="Bottom-main.jsp"><img src="image\bumperCase2.jpg" height="35" width="140"></a>
        <img src="image\space.jpg" height="35" width="80">
        <a href="Outer-main.jsp"><img src="image\hardCase.jpg" height="35" width="140"></a>
        <img src="image\space.jpg" height="35" width="80">
        <a href="Sho-main.jsp"><img src="image\jellyCase.jpg" height="35" width="140"></a>
        <img src="image\space.jpg" height="35" width="80">
        <a href="event.jsp"><img src="image\event_.jpg" height="35" width="140"></a>
    </center>
    <hr size="5" color="black">

        <h2>Hello, <%=user.getName()%><br/>��ǰ �߰� ������ �Դϴ�.</h2>
        <%if ((status != null) && !status.isSuccessful()) {%>
        <font color="red">There were problems processing your request:
        <ul><%Iterator errors = status.getExceptions();
            while (errors.hasNext()) {
                Exception ex = (Exception) errors.next();%>
            <li><%= ex.getMessage()%><%}%></ul></font><%}%>
        <form action="createprocess" method="post">
            <table>
                <tr><td>���̽� Ÿ��:</td><td>
                        <input type="text" name="caseType" size="20"></td></tr>
                <tr><td>���̽� �̸�:</td><td>
                        <input type="text" name="caseName" size="20"></td></tr>
                <tr><td>����:</td><td>
                        <input type="text" name="explanation" size="50"></td></tr>
                <tr><td>����:</td><td>
                        <input type="text" name="price" size="5"></td></tr>
                
            </table>
            <input type="submit" value="Submit">
        </form>         
    </body>
</html>
