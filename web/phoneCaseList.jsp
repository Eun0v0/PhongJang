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
        <table border="0px">
            <tr>
                <%
                if (user == null) { %>
                <td><img src="image\login.jpg" onClick="location.assign('login.jsp')"></td>
                <td><a OnClick="alert('�α����� ���ּ���!')" style="cursor:pointer">
                        <img src="image\cart.jpg"></a>
                </td>
                <td><a OnClick="alert('�α����� ���ּ���!')" style="cursor:pointer">
                        <input type="submit" value ="MY PAGE"></a>
                </td>
                <td><a OnClick="alert('�α����� ���ּ���!')" style="cursor:pointer">
                        <img src="image\order.jpg"></a>
                </td>
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
                        <input type="submit" value ="MY PAGE">
                    </form>    
                </td>
                <%  }%>
                <td><form action="IDCheck" method="post">
                        <input type="image" src="image\join.jpg" name="Submit" value ="ȸ������">
                    </form>    
                </td>

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
            <% } %>

    <form action ="search" method="post">
        <img src="image\search.png" height="17" width="17">
        <input type="text" size="16" name="caseName">
        <input type="submit" value="�˻�">
    </form>

    <hr size="5" color="black">
    <center>
        <% if (user != null) {%>
        <h1>�ȳ��ϼ���, <%=user.getName()%>��</h1>

        <h2>���� ��ǰ ���</h2>

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
                        <input type="hidden" name="caseName" value="<%=phonecase.getCaseName()%>">
                        <input type="hidden" name="price" value="<%=phonecase.getPrice()%>">
                        <input type="text" name ="numbers" size="5">
                        <input type="submit" value="���">
                    </form> </td>
            </tr>
            <% } %>
        </table>

        <% } else { %>
        <h1>�ȳ��ϼ���, ����</h1>

        <h2>���� ��ǰ ���</h2>

        <table border="2px">
            <tr>
                <th width="100">���̽� ID</th>
                <th width="150">���̽� �̸�</th>
                <th width="200">Ÿ��</th>
                <th width="400">����</th>
                <th width="150">����</th>
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
            </tr>
            <% } %>
        </table>

        <% }%>

    </center>
</body>
</html>
