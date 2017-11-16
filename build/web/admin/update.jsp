<%-- 
    Document   : update
    Created on : 2017. 11. 12, ���� 8:13:24
    Author     : yukih
--%>

<%@page import="java.util.Iterator" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr"%>
<%@page import="domain.PhoneCase"%>
<%@page import="domain.User"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<jsp:useBean id="status" scope="request" class="util.Status"/>
<html>
    <head>
        
        <title>Update Form</title>
        <%  ArrayList<PhoneCase> phoneCases = (ArrayList<PhoneCase>) request.getAttribute("phoneCases");
  
            User user = (User)request.getAttribute("user");
            int caseID = (int)request.getAttribute("caseID");
           
            session.setAttribute("user", user);
            session.setAttribute("phoneCases", phoneCases);
        %>
    
    </head>
    <body>
        <h2>Hello, <%=user.getName()%><br/>��ǰ ���� ������ �Դϴ�.</h2>
            <%if ((status != null) && !status.isSuccessful()) {%>
        <font color="red">There were problems processing your request:
        <ul><%Iterator errors = status.getExceptions();
            while (errors.hasNext()) {
                Exception ex = (Exception) errors.next();%>
            <li><%= ex.getMessage()%><%}%></ul></font><%}%>
        
        <form action="updateprocess" method="post">
            <table>
                <tr><td>���̽� ��ȣ:</td><td>
                    <%=caseID%></tr>
                <tr><td>���̽� Ÿ��:</td><td>
                        <textarea name="caseType" size="20"><%=request.getAttribute("caseType")%></textarea>
                        <%--<input type="text" name="caseType" size="20"></td></tr>--%>
                <tr><td>���̽� �̸�:</td><td>
                        <textarea name="caseName" size="20"><%=request.getAttribute("caseName")%></textarea>
                        <%--<input type="text" name="caseName" size="20"></td></tr>--%>
                <tr><td>����:</td><td>
                        <textarea name = "explanation" size="50"><%= request.getAttribute("explanation")%></textarea>
                        <%--<input type="text" name="explanation" size="50"></td></tr>--%>
                <tr><td>����:</td><td>
                        <textarea name="price" size="5"><%=request.getAttribute("price")%></textarea>
                        <%--<input type="text" name="price" size="5"></td></tr>--%>
            </table>
            <input type="hidden" name="caseID" value="<%=caseID%>">
            <input type="submit" value="Submit">
        </form>         
    </body>
</html>
?