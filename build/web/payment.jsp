<%-- 
    Document   : payment
    Created on : 2017. 11. 11, 오후 11:00:51
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
         <table border="0px">
            <tr>
                <%  User user = (User) request.getAttribute("user");
                    if (user == null) {
                        session.setAttribute("user", user); %>
                <td><img src="image\login.jpg" onClick="location.assign('login.jsp')"></td>
                <td><a OnClick="alert('로그인을 해주세요!')" style="cursor:pointer">
                        <img src="image\cart.jpg"></a>
                </td>
                <td><a OnClick="alert('로그인을 해주세요!')" style="cursor:pointer">
                        <img src="image\order.jpg"></a>
                </td>
                <td><a OnClick="alert('로그인을 해주세요!')" style="cursor:pointer">
                        &nbsp;
                        <input type="image" src="image\myPageUp_1.jpg" name="Submit" value ="MY PAGE"></a>
                </td>
                <td><form action="IDCheck" method="post">
                        <input type="image" src="image\join.jpg" name="Submit" value ="회원가입">
                    </form>    
                </td>
                <% } else {
                    session.setAttribute("user", user);%>
                <td><form action="logout" method="post">
                        <input type="image" src="image\logout.jpg" name="Submit" value ="로그아웃">
                    </form> 
                </td>
                <td><form action="cart" method="post">
                        <input type="hidden" name="userID" value="<%=user.getId()%>">
                        <input type="image" src="image\cart.jpg" name="Submit" value ="장바구니">
                    </form> 
                </td>

                <td><form action="paymentlist" method="post">
                        <input type="image" src="image\order.jpg" name="Submit" value ="주문 목록">
                    </form>    
                </td>
                <td><form action="myPage" method="post">
                        <input type="hidden" name="userID" value="<%=user.getId()%>">
                        &nbsp;
                        <input type="image" src="image\myPageUp_1.jpg" name="Submit" value ="MY PAGE">
                    </form>    
                </td>

                <%  }%>

                <td><form action="qnaList" methoe="post">
                        <input type="image" src="image\q&a.jpg" name="Submit" value="Q&A">
                    </form>
                </td>
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
            <% } %>

    <form action ="search" method="post">
        <img src="image\search.png" height="17" width="17">
        <input type="text" size="16" name="caseName">
        <input type="submit" value="검색">
    </form>

    <hr size="5" color="black">
    <center>
        <table>
            <tr>
                <% if (user != null) {%>
                <td><form action="myCase" method="post">
                        <input type="image" src="image\customCase3.jpg" name="Submit" height="35" width="140">
                    </form></td>
                <% } else {%>
                <td><a OnClick="alert('로그인을 해주세요!')" style="cursor:pointer">
                        <input type="image" src="image\customCase3.jpg" name="Submit" height="35" width="140"></a></td>
                <% } %>        
                <td><img src="image\space.jpg" height="35" width="80"></td>

                <td><form action ="caseTypePage" method="post">
                        <input type="image" src="image\bumperCase2.jpg" name="Submit" height="35" width="140">
                        <input type="hidden" name="caseType" value="범퍼">
                    </form></td>
                <td><img src="image\space.jpg" height="35" width="80"></td>

                <td><form action ="caseTypePage" method="post">
                        <input type="image" src="image\hardCase.jpg" name="Submit" height="35" width="140">
                        <input type="hidden" name="caseType" value="하드">
                    </form></td>
                <td><img src="image\space.jpg" height="35" width="80"></td>

                <td><form action ="caseTypePage" method="post">
                        <input type="image" src="image\jellyCase.jpg" name="Submit" height="35" width="140">
                        <input type="hidden" name="caseType" value="젤리">
                    </form></td>
                <td><img src="image\space.jpg" height="35" width="80"></td>

                <td><form action ="eventList" method="post">
                        <input type="image" src="image\event_.jpg" name="Submit" height="35" width="140">
                    </form></td> 
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
            
            <%if((payment.getStatus()).equals("배송중")) { %> 
            <td><a OnClick="alert('배송중에는 취소가 불가능합니다.')" style="cursor:pointer">
                   <input type="image" src="image\orderCancle.JPG" width="75" height="40" name="Submit" value ="결제 취소" >
            </td>
            <% } else { %>
            <td> <form action="deletePayment" method="post">
                <input type="hidden" name="paymentID" value="<%=payment.getPaymentID()%>">
                <% session.setAttribute("paymentID", payment.getPaymentID());%>
                &nbsp;
                <input type="image" src="image\orderCancle.JPG" width="75" height="40" name="Submit" value ="결제 취소" >
                </form></td>
            <% } %>
            <% }
        }%>
    </table>
</center>
</br></br></br></br>
</body>
</html>
