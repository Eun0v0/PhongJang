<%-- 
    Document   : payment
    Created on : 2017. 11. 11, 오후 5:33:37
    Author     : yukih
--%>

<%@page import="domain.PhoneCase"%>
<%@page import="domain.User"%>
<%@page import="domain.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <h2>Hello, <%= user.getName()%></h2>
        <table border="2px">
            <thead>
                <tr>
                    <th width="200">구매자 이름</th>
                    <th width="200">상품명</th>
                    <th width="200">수량</th>
                </tr>
            </thead>
            <%
                for (int i = 0; i < carts.size(); i++) {
                    Cart cart = carts.get(i);
                    PhoneCase phoneCase = myCases.get(i);
            %> 
            <tbody>
                <tr>
                    <td align="center"><%=user.getName()%></td>
                    <td align="center"><%=phoneCase.getCaseName()%></td>
                    <td align="center"><%=cart.getNumbers()%></td>
                </tr>
                <% }%>
            </tbody>
        </table><br/>
        <table border="2px">
            <thead>
                <tr>
                    <th width="600">결제 정보</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td align="center">
                        주소 : <%=user.getAddress()%></br>
                        전화번호 : <%=user.getPhone()%></br>
                        총 금액 : <%=totalprice%>
                    </td>
                </tr>
                <tr>
                    <td align="center">
                        <form action="pay" method="post">
                            신용 카드 번호를 입력하세요
                            <input type="text" name="creditcardnumber"></br>
                            신용 카드 비밀번호를 입력하세요
                            <input type="password" name="creditcardpassword"></br>
                            <input type="submit" value="Pay">
                        </form>
                    </td>
                </tr>
            </tbody>
        </table>
    </body>
</html>