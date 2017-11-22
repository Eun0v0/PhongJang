<%-- 
    Document   : payment
    Created on : 2017. 11. 12, ���� 6:52:01
    Author     : yukih
--%>
<%-- test --%>
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
        <table border="0px">
            <tr>
                <% if (user == null) { %>
                <td><img src="image\login.jpg" onClick="location.assign('login.jsp')"></td>
                <td><a OnClick="alert('�α����� ���ּ���!')" style="cursor:pointer">
                        <input type="submit" value="��ǰ �߰�">
                    </a></td>
                <td><a OnClick="alert('�α����� ���ּ���!')" style="cursor:pointer">
                        <input type="submit" value="��� ����">
                    </a></td>
                <td><a OnClick="alert('�α����� ���ּ���!')" style="cursor:pointer">
                        <img src="image\order.jpg"></a>
                </td>

                <% } else {
                    session.setAttribute("user", user); %>
                <td><form action="logout" method="post">
                        <input type="image" src="image\logout.jpg" name="Submit" value ="�α׾ƿ�">
                    </form> 
                </td>
                <td><form action="create" method="post">
                        <input type="submit" value="��ǰ �߰�">
                    </form>
                </td>
                <td><form action="manageStock" method="post">
                        <input type="submit" value="��� ����">
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
        <% if (user != null) {%>
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
        <table>
            <tr>
                <td><a href="Top-main.jsp"><img src="image\customCase3.jpg" height="35" width="140"></a></td>
                <td><img src="image\space.jpg" height="35" width="80"></td>

                <td><form action ="caseTypePage" method="post">
                        <input type="image" src="image\bumperCase2.jpg" name="Submit" height="35" width="140">
                        <input type="hidden" name="caseType" value="����">
                    </form></td>
                <td><img src="image\space.jpg" height="35" width="80"></td>

                <td><form action ="caseTypePage" method="post">
                        <input type="image" src="image\hardCase.jpg" name="Submit" height="35" width="140">
                        <input type="hidden" name="caseType" value="�ϵ�">
                    </form></td>
                <td><img src="image\space.jpg" height="35" width="80"></td>

                <td><form action ="caseTypePage" method="post">
                        <input type="image" src="image\jellyCase.jpg" name="Submit" height="35" width="140">
                        <input type="hidden" name="caseType" value="����">
                    </form></td>
                <td><img src="image\space.jpg" height="35" width="80"></td>

                <td><a href="event.jsp"><img src="image\event_.jpg" height="35" width="140"></a></td> 
            </tr>
        </table>
    </center>
    <hr size="5" color="black">

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
            <%if ((payment.getParcelNumber()).equals("�غ���")) {%>
            <td align="center"><form action = "updatePayment" method = "post">
                    <% session.setAttribute("payment", payment);%>
                    <input type="text" name="parcelNumber">
                    <input type ="submit" value="�����ȣ �߰�">
                </form></td>
            <td>
                <% } else {%>
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
