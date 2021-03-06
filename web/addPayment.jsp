<%-- 
    Document   : payment
    Created on : 2017. 11. 11, 오후 5:33:37
    Author     : yukih
--%>
<%-- test --%>
<%@page import="domain.PhoneCase"%>
<%@page import="domain.User"%>
<%@page import="domain.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr"%>
<jsp:useBean id="status" scope="request" class="util.Status"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product List</title>
        <%  ArrayList<Cart> carts = (ArrayList<Cart>) request.getAttribute("carts");
            User user = (User) request.getAttribute("user");
            int totalprice = (int) request.getAttribute("totalprice");
            ArrayList<PhoneCase> myCases = (ArrayList<PhoneCase>) request.getAttribute("myCases");
            session.setAttribute("carts", carts);
            session.setAttribute("user", user);%>
    </head>
    <body>
         <table border="0px">
            <tr>
                <%  if (user == null) {
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

    <center>
        <br><br>
        <%if ((status != null) && !status.isSuccessful()) {%>
        <font color="red">오류 발생!!!:
        <ul><%Iterator errors = status.getExceptions();
            while (errors.hasNext()) {
                Exception ex = (Exception) errors.next();%>
            <li><%= ex.getMessage()%><%}%></ul></font>    
            <%}%>
    </center>
    <center>
        <br><h2>안녕하세요, <%= user.getName()%>님</h2>
        <table>
            <thead>
                <tr>
                    <th width="170" height = "35"><img src="image\username.JPG" width=170 height=40></th>
                    <th width="170" height = "35"><img src="image\productname.JPG" width=170 height=40></th>
                    <th width="170" height = "35"><img src="image\amount.jpg" width=170 height=40></th>
                </tr>
            </thead>
            <%
                for (int i = 0; i < carts.size(); i++) {
                    Cart cart = carts.get(i);
                    PhoneCase phoneCase = myCases.get(i);
            %> 
            <tbody>
                <tr>
                    <td bgcolor="#dcdcdc" align="center" height = "35"><%=user.getName()%></td>
                    <td bgcolor="#dcdcdc" align="center" height = "35"><%=phoneCase.getCaseName()%></td>
                    <td bgcolor="#dcdcdc" align="center" height = "35"><%=cart.getNumbers()%></td>
                </tr>
                <% }%>
            </tbody>
        </table><br/> </center>
    <center><br>
        <table>
            <thead>
                <tr>
                    <th width="600" height ="35"><img src="image\paymentinfo.jpg" width=600 height=40></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td align="center" td bgcolor="#dcdcdc" height ="35">
                        주소 : <%=user.getAddress()%></br>
                        전화번호 : <%=user.getPhone()%></br>
                        총 금액 : <%=totalprice%>
                    </td>
                </tr>
                <tr>
                    <td align="center" td bgcolor="#dcdcdc" height ="35">
                        <form action="pay" method="post">
                            신용 카드 번호를 입력하세요 (16자리)
                            <input type="text" name="creditcardNumber"></br>
                            신용 카드 비밀번호를 입력하세요 (4자리)
                            <input type="password" name="creditcardPassword">
                            </br>
                            <input type="image" src="image\paymentbutton.jpg" name="Submit" value ="삭제" aline="absmiddle">   
                        </form>
                    </td>
                </tr>
            </tbody>
        </table>
    </center>
</body>
</html>