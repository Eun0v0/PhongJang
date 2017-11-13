<%-- 
    Document   : login
    Created on : 2017. 11. 4, ���� 7:17:19
    Author     : yukih
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="domain.PhoneCase"%>
<%@page import="domain.User"%>
<%@page import="java.util.Iterator" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>���� ��ǰ ���</title>
        <% ArrayList<PhoneCase> phoneCase = (ArrayList<PhoneCase>) request.getAttribute("phoneCases");%>
        <% User user = (User) request.getAttribute("user");%>
        <%session.setAttribute("user", user);%>
    </head>
    <body>
        <h1>�ȳ��ϼ���, <%=user.getName()%>��</h1>
        <h2>���� ��ǰ ���</h2>
        <form action="cart" method="post">
            <input type="hidden" name="userID" value="<%=user.getId()%>">
            <input type="submit" value="��ٱ���">
        </form>
        <form action="search" method="post">
            ��ǰ �˻� :
            <input type="text" name="caseName" size="24">
            <input type="submit" value="�˻�">
        </form>
        <table border="2px">
            <tr>
                <th width="100">���̽� ID</th>
                <th width="150">���̽� �̸�</th>
                <th width="200">Ÿ��</th>
                <th width="400">����</th>
                <th width="150">����</th>
                <th width="200">��ٱ��Ͽ� ���</th>
            </tr>
            <%
                for (int i = 0; i < phoneCase.size(); i++) {
                    PhoneCase phonecase = phoneCase.get(i);
            %> 
            <tr>
                <td align="center"><%=phonecase.getCaseID()%></td>
                <td align="center"><%=phonecase.getCaseName()%></td>
                <td align="center"><%=phonecase.getCaseType()%></td>
                <td align="center"><%=phonecase.getExplanation()%></td>
                <td align="center"><%=phonecase.getPrice()%>��</td>
                <td align="center">
                    <form action="take" method="post">
                        ���ϴ� ������ �Է��ϼ��� :
                        <input type="hidden" name="userID" value="<%=user.getId()%>">
                        <input type="hidden" name="caseID" value="<%=phonecase.getCaseID()%>">
                        <input type="text" name ="numbers" size="5">
                        <input type="submit" value="���">
                   </form>
            </tr>
            <% } %>
        </table>
        <form action="main.jsp" method="post">
            <input type="submit" value="��������">
    </body>
</html>
