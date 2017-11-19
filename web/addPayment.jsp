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
                <%
                    if (user == null) { %>
                <td><img src="image\login.jpg" onClick="location.assign('login.jsp')"></td>
                <td><a OnClick="alert('로그인을 해주세요!')" style="cursor:pointer">
                        <img src="image\cart.jpg"></a>
                </td>
                <td><a OnClick="alert('로그인을 해주세요!')" style="cursor:pointer">
                        <img src="image\order.jpg"></a>
                </td>
                <% } else {
                    session.setAttribute("user", user);%>
                <td><img src="image\logout.jpg" onClick="location.assign('logout.jsp')"></td>
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

    <form action ="search" method="post">
                <img src="image\search.png" height="17" width="17">
                <input type="text" size="16" name="caseName">
                <input type="submit" value="검색">
    </form>

    <hr size="5" color="black">
    <center>
        <a href="Top-main.jsp"><img src="image\customCase3.jpg" height="35" width="140"></a>
        <img src="image\space.jpg" height="35" width="80">
        <a href="Bottom-main.jsp"><img src="image\bumperCase2.jpg" height="35" width="140"></a>
        <img src="image\space.jpg" height="35" width="80">
        <a href="Outer-main.jsp"><img src="image\hardCase.jpg" height="35" width="140"></a>
        <img src="image\space.jpg" height="35" width="80">
        <a href="Sho-main.jsp"><img src="image\jellyCase.jpg" height="35" width="140"></a>
        <img src="image\space.jpg" height="35" width="80">
        <a href="event.jsp"><img src="image\event_.jpg" height="35" width="140"></a>
    </center>
    <hr size="5" color="black">

    <center>
        <br><h2>Hello, <%= user.getName()%></h2>
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
                            신용 카드 번호를 입력하세요
                            <input type="text" name="creditcardnumber"></br>
                            신용 카드 비밀번호를 입력하세요
                            <input type="password" name="creditcardpassword">
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