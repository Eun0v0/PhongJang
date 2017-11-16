<%-- 
    Document   : payment
    Created on : 2017. 11. 12, ���� 6:52:01
    Author     : yukih
--%>
<%@page import="domain.PhoneCase"%>
<%@page import="domain.Payment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="domain.User"%>
<%@page import="java.util.Iterator" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>�� ���� ����</title>
        
        <% ArrayList<PhoneCase> phoneCases = (ArrayList<PhoneCase>) request.getAttribute("phoneCases");%>       
        <% ArrayList<Payment> payments = (ArrayList<Payment>) request.getAttribute("payments");%>
        <% User user = (User) request.getAttribute("user");%>
        <% session.setAttribute("user", user);%>
        <% session.setAttribute("phoneCases", phoneCases);%>
        
    </head>
    <body>
        <h2>�� ���� ��� �Դϴ�.</h2>
        <table border="2px">
            <tr>
                <th width="100">���� ��ȣ</th>
                <th width="100">���� ��¥</th>
                <th width="100">�ֹ��� ID</th>
                <th width="100">��ǰ��</th>
                <th width="100">����</th>               
                <th width="100">����</th>                                
                <th width="200">��� ����</th>
                <th width="200">�����ȣ</th>
            </tr>
            <%
                for (int i = 0; i < payments.size(); i++) {
                    Payment payment = payments.get(i);
            %> 
            <tr>
                <td align="center"><%=payment.getPaymentID()%></td>
                <td align="center"><%=payment.getOrderDate()%></td>
                <td align="center"><%=payment.getUserID()%></td>                
                <td align="center"><%=payment.getCaseName()%></td>
                <td align="center"><%=payment.getNumbers()%></td>
                <td align="center"><%=payment.getPrice()%></td>
                <td align="center"><%=payment.getStatus()%></td>
                <%if((payment.getParcelNumber()).equals("�غ���")) {%>
                <td align="center"><form action = "updatePayment" method = "post">
                    <% session.setAttribute("payment", payment);%>
                    <input type="text" name="parcelNumber">
                    <input type ="submit" value="�����ȣ �߰�">
                    </form></td>
                <td>
                <% } else { %>
                <td align="center"><%=payment.getParcelNumber()%></td>
                <% } %>
            </tr>
            <% }%>
        </table>
        <form action="main" method="post">
            <input type="hidden" name="userID" value="<%=user.getId()%>">
            <input type="submit" value="��������">
        </form>
    </body>
</html>?
