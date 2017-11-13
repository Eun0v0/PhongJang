<%-- 
    Document   : update
    Created on : 2017. 11. 12, 오후 8:13:24
    Author     : yukih
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <h2>Hello, <%=user.getName()%><br/>제품 수정 페이지 입니다.</h2>
            <%if ((status != null) && !status.isSuccessful()) {%>
        <font color="red">There were problems processing your request:
        <ul><%Iterator errors = status.getExceptions();
            while (errors.hasNext()) {
                Exception ex = (Exception) errors.next();%>
            <li><%= ex.getMessage()%><%}%></ul></font><%}%>
        
        <form action="updateprocess" method="post">
            <table>
                <tr><td>케이스 번호:</td><td>
                    <%=caseID%></tr>
                <tr><td>케이스 타입:</td><td>
                        <textarea name="caseType" size="20"><%=request.getAttribute("caseType")%></textarea>
                        <%--<input type="text" name="caseType" size="20"></td></tr>--%>
                <tr><td>케이스 이름:</td><td>
                        <textarea name="caseName" size="20"><%=request.getAttribute("caseName")%></textarea>
                        <%--<input type="text" name="caseName" size="20"></td></tr>--%>
                <tr><td>설명:</td><td>
                        <textarea name = "explanation" size="50"><%= request.getAttribute("explanation")%></textarea>
                        <%--<input type="text" name="explanation" size="50"></td></tr>--%>
                <tr><td>가격:</td><td>
                        <textarea name="price" size="5"><%=request.getAttribute("price")%></textarea>
                        <%--<input type="text" name="price" size="5"></td></tr>--%>
            </table>
            <input type="hidden" name="caseID" value="<%=caseID%>">
            <input type="submit" value="Submit">
        </form>         
    </body>
</html>
​