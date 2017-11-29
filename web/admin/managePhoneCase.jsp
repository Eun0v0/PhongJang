<%-- 
    Document   : login
    Created on : 2017. 11. 3, ?? 4:28:19
    Author     : yukih
--%>
<%-- test --%>
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

    <form action="paymentlist" method="post">
        <input type="submit" value="모든 결제내역">
    </form>        
    <table border="2px">
        <tr>
            <th width="100">케이스 ID</th>
            <th width="150">타입</th>
            <th width="200">케이스 이름</th>
            <th width="400">설명</th>
            <th width="150">가격</th>
            <th width="150">수정</th>
            <th width="150">삭제</th>
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
                    <input type="hidden" name="img" value="<%=phoneCase.getImg()%>">
                    <input type="submit" value="수정">
                </form>
            </td>
            <td align="center">
                <form action="deleteCase" method="post">
                    <input type="hidden" name="caseID" value="<%=phoneCase.getCaseID()%>">
                    <input type="submit" value="삭제">
                </form>
            </td>
        </tr>
        <% }%>
    </table>    

    <form action="create" method="post">
        <input type="submit" value="새 상품 추가">
    </form>
</body>
</html>
