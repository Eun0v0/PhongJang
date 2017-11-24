<%-- 
    Document   : payment
    Created on : 2017. 11. 11, ���� 11:00:51
    Author     : yukih
--%>
<%-- test --%>
<%@page import="domain.Payment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="domain.User"%>
<%@page import="java.util.Iterator" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product List</title>
        <% ArrayList<Payment> payments = (ArrayList<Payment>) request.getAttribute("payments");%>
        <% User user = (User) request.getAttribute("user");%>
        <% session.setAttribute("user", user);%>
    </head>
    <body>
        <table>
            <%
                if (user == null) { %>
            <td><img src="image\login.jpg" onClick="location.assign('login.jsp')"></td>
            <td><td><a href="cart.jsp"><img src="image\cart.jpg"></a></td>
                    <% } else {
                        session.setAttribute("user", user);%>
            <td><form action="logout" method="post">
                    <input type="image" src="image\logout.jpg" name="Submit" value ="�α׾ƿ�">
                </form> 
            </td>
            <td><form action="cart" method="post">
                    <input type="hidden" name="userID" value="<%=user.getId()%>">
                    <input type="image" src="image\cart.jpg" name="Submit" value ="��ٱ���">
                </form> 
            </td>
            <td><form action="paymentlist" method="post">
                    <input type="image" src="image\order.jpg" name="Submit" value ="�ֹ� ���">
                </form>    
            </td>    
            <td><form action="myPage" method="post">
                    <input type="hidden" name="userID" value="<%=user.getId()%>">
                    &nbsp;
                    <input type="image" src="image\myPageUp_1.jpg" name="Submit" value ="MY PAGE">
                </form>    
            </td>
            <%  }%>

            <td><a href="join.jsp"><img src="image\join.jpg"></a></td>
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
<center> <div align="middle"> <img src="image\banner2.jpg" onClick="location.assign('main.jsp')"> </div> </center>
        <% }%>

<form action ="search.action" name="search" method="search">
    <img src="image\search.png" height="17" width="17">
    <input type="text" size="16" name="keyword" value="${keyword}">
    <input type="button" value="�˻�" onClick="check()">
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

<center></br></br><input type="image" src="image\orderlist.jpg" name="Submit" value ="complete" aline="absmiddle">
    </br>
    <table>
        <tr>
            <th width="170" height = "35"><img src="image\paynum.jpg" width=170 height=40"></th>
            <%--<th width="170" height = "35"><img src="image\orderDate1.jpg" width=170 height=40"></th>--%>
            <th width="170" height = "35"><img src="image\casename2.jpg" width=170 height=40"></th>
            <th width="120" height = "35"><img src="image\amount2.jpg" width=120 height=40"></th>
            <th width="120" height = "35"><img src="image\price.jpg" width=120 height=40"></th>                          
            <th width="200" height = "35"><img src="image\deliverystate.jpg" width=200 height=40"></th>
            <th width="200" height = "35"><img src="image\deliverynumber.jpg" width=200 height=40"></th>
        </tr>
        <%
            for (int i = 0; i < payments.size(); i++) {
                Payment payment = payments.get(i);
        if(payments.size() != 0){
        %> 
        <tr>
            <td bgcolor="#dcdcdc" align="center" height = "35"><%=payment.getPaymentID()%>
                <br> <%=payment.getOrderDate()%> </td>
            <%--<td bgcolor="#dcdcdc" align="center" height = "35"><%=payment.getOrderDate()%></td>--%>
            <td bgcolor="#dcdcdc" align="center" height = "35"><%=payment.getCaseName()%>
                <br><font size="2"><%=payment.getCaseType()%> | <%=payment.getColor()%> | <%=payment.getPhoneType()%></font></td>
            <td bgcolor="#dcdcdc" align="center" height = "35"><%=payment.getNumbers()%></td>
            <td bgcolor="#dcdcdc" align="center" height = "35"><%=payment.getPrice()%></td>
            <td bgcolor="#dcdcdc"  align="center" height = "35"><%=payment.getStatus()%></td>    
            <td bgcolor="#dcdcdc"  align="center" height = "35"><%=payment.getParcelNumber()%></td>    
            
            <%if((payment.getStatus()).equals("�����")) { %> 
            <td><a OnClick="alert('����߿��� ��Ұ� �Ұ����մϴ�.')" style="cursor:pointer">
                   <input type="image" src="image\orderCancle.JPG" width="75" height="40" name="Submit" value ="���� ���" >
            </td>
            <% } else { %>
            <td> <form action="deletePayment" method="post">
                <input type="hidden" name="paymentID" value="<%=payment.getPaymentID()%>">
                <% session.setAttribute("paymentID", payment.getPaymentID());%>
                &nbsp;
                <input type="image" src="image\orderCancle.JPG" width="75" height="40" name="Submit" value ="���� ���" >
                </form></td>
            <% } %>
            <% }
        }%>
    </table>
</center>
</br></br></br></br>
</body>
</html>
