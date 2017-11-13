<%-- 
    Document   : login
    Created on : 2017. 11. 3, ?? 4:28:19
    Author     : yukih
--%>

<%@page import="domain.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="domain.PhoneCase"%>
<%@page import="java.util.Iterator" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product List</title>
        <% ArrayList<PhoneCase> phoneCases = (ArrayList<PhoneCase>) request.getAttribute("phoneCases");%>
        <% User user = (User) request.getAttribute("user");%>
        <% session.setAttribute("user", user);%>
        <% session.setAttribute("phoneCases", phoneCases);%>
        
    </head>
    <body>
        <h2>Hello, <%= user.getName()%></h2>
        <form action="paymentlist" method="post">
            <input type="submit" value="��� ��������">
        </form>        
        <table border="2px">
            <tr>
                <th width="100">���̽� ID</th>
                <th width="150">Ÿ��</th>
                <th width="200">���̽� �̸�</th>
                <th width="400">����</th>
                <th width="150">����</th>
                <th width="150">����</th>
                <th width="150">����</th>
            </tr>
            <%
                for (int i = 0; i < phoneCases.size(); i++) {
                    PhoneCase phoneCase = phoneCases.get(i);
            %> 
            <tr>
                <td align="center"><%=phoneCase.getCaseID()%></td>
                <td align="center"><%=phoneCase.getCaseType()%></td>
                <td align="center"><%=phoneCase.getCaseName()%></td>
                <td align="center"><%=phoneCase.getExplanation()%></td>
                <td align="center">$<%=phoneCase.getPrice()%></td>
                <td align="center">
                    <form action="update" method="post">
                        <input type="hidden" name="caseID" value="<%=phoneCase.getCaseID()%>">
                        <input type="hidden" name="caseType" value="<%=phoneCase.getCaseType()%>">
                        <input type="hidden" name="caseName" value="<%=phoneCase.getCaseName()%>">
                        <input type="hidden" name="explanation" value="<%=phoneCase.getExplanation()%>">
                        <input type="hidden" name="price" value="<%=phoneCase.getPrice()%>">
                        <input type="submit" value="����">
                    </form>
                </td>
                <td align="center">
                    <form action="deleteCase" method="post">
                        <input type="hidden" name="caseID" value="<%=phoneCase.getCaseID()%>">
                        <input type="submit" value="����">
                    </form>
                </td>
            </tr>
            <% }%>
        </table>    
        
        <form action="create" method="post">
            <input type="submit" value="�� ��ǰ �߰�">
        </form>
    </body>
</html>
