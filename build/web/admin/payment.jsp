<%-- 
    Document   : payment
    Created on : 2017. 11. 12, 오후 6:52:01
    Author     : yukih
--%>
<%-- test --%>
<%@page import="domain.PhoneCase"%>
<%@page import="domain.Payment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="domain.User"%>
<%@page import="java.util.Iterator" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr"%>
<jsp:useBean id="status" scope="request" class="util.Status"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>고객 결제 내역</title>

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
                <td><a OnClick="alert('로그인을 해주세요!')" style="cursor:pointer">
                        <input type="image" src="image\adminAdd2.jpg" name="Submit" value ="로그아웃">
                    </a></td>
                <td><a OnClick="alert('로그인을 해주세요!')" style="cursor:pointer">
                        <input type="image" src="image\inventory.jpg" name="Submit" value ="로그아웃">
                    </a></td>
                <td><a OnClick="alert('로그인을 해주세요!')" style="cursor:pointer">
                        <img src="image\order.jpg"></a>
                </td>

                <% } else {
                    session.setAttribute("user", user); %>
                <td><form action="logout" method="post">
                        <input type="image" src="image\logout.jpg" name="Submit" value ="로그아웃">
                    </form> 
                </td>
                <td><form action="create" method="post">
                        <input type="image" src="image\adminAdd2.jpg" name="Submit" value ="로그아웃">
                    </form>
                </td>
                <td><form action="manageStock" method="post">
                        <input type="image" src="image\inventory.jpg" name="Submit" value ="로그아웃">
                    </form>
                </td>
                <td><form action="paymentlist" method="post">
                        <input type="image" src="image\order.jpg" name="Submit" value="모든 결제내역">
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
        <input type="submit" value="검색">
    </form>

    <hr size="5" color="black">
    <center>
        <table>
            <tr>
                <td><a href="Top-main.jsp"><img src="image\customCase3.jpg" height="35" width="140"></a></td>
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
    
    <center>
        <%if ((status != null) && !status.isSuccessful()) {%>
        <font color="red">오류 발생!!!:
        <ul><%Iterator errors = status.getExceptions();
            while (errors.hasNext()) {
                Exception ex = (Exception) errors.next();%>
            <li><%= ex.getMessage()%><%}%></ul></font>    
            <%}%>
    </center>  
    <center></br>
        <h2>고객 결제 목록 입니다.</h2>
        <hr width="25%" size="1" color="gray"><br>
        <table>
            <tr>
                <th width="170" height = "35"><img src="image\paynum.jpg" width=170 height=40"></th>
                <th width="120" height = "35"><img src="image\stockId.jpg" width=120 height=40"></th>
                <th width="170" height = "35"><img src="image\casename2.jpg" width=170 height=40"></th>
                <th width="200" height = "35"><img src="image\deliverystate.jpg" width=200 height=40"></th>
                <th width="200" height = "35"><img src="image\deliverynumber.jpg" width=200 height=40"></th>
            </tr>
            <%
                for (int i = 0; i < payments.size(); i++) {
                    Payment payment = payments.get(i);
            %> 
            <tr>
                <td bgcolor="#dcdcdc" align="center"><%=payment.getPaymentID()%> 
                    <br> <font size="2"><%=payment.getOrderDate()%> </font></td>
                <td  bgcolor="#dcdcdc" align="center"><%=payment.getUserID()%></td>                
                <td bgcolor="#dcdcdc" align="center"><%=payment.getCaseName()%>
                    <br> <font size="2"><%=payment.getNumbers()%>개 | <%=payment.getPrice()%>원</font></td>

                <td bgcolor="#dcdcdc" align="center"><%=payment.getStatus()%></td>
                <%if ((payment.getParcelNumber()).equals("준비중")) {%>
                <td bgcolor="#dcdcdc" align="center"><form action = "updatePayment" method = "post">
                        <% session.setAttribute("payment", payment);%>
                        <input type="text" name="parcelNumber">
                        <br><input type ="submit" value="송장번호 추가">
                    </form></td>
                <td>
                    <% } else {%>
                <td  bgcolor="#dcdcdc" align="center"><%=payment.getParcelNumber()%></td>
                <% } %>
            </tr>
            <% }%>
        </table>
    </center>
</body>
</html>
