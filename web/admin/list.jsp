<%-- 
    Document   : login
    Created on : 2017. 11. 3, ?? 4:28:19
    Author     : yukih
--%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.io.File"%>
<%-- test --%>

<%@page import="domain.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="domain.PhoneCase"%>
<%@page import="java.util.Iterator" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
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
                        <input type="submit" value="상품 관리">
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
                <td><form action="managePhoneCase" method="post">
                        <input type="submit" value="상품 관리">
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

    <form action="paymentlist" method="post">
        <input type="submit" value="모든 결제내역">
    </form>        
    <center> 
        <table border="2px">
            <tr>
                <th width="100">케이스 이름</th>
                <th width="100" height="100">케이스 사진</th>
                <th width="150">삭제</th>
            </tr>
            <%
                for (int i = 0; i < phoneCases.size(); i++) {
                    PhoneCase phoneCase = phoneCases.get(i);
                    int caseID = phoneCase.getCaseID();
                    String caseType = phoneCase.getCaseType();
                    String caseName = phoneCase.getCaseName();
                    String explanation = phoneCase.getExplanation();
                    int price = phoneCase.getPrice();
                    String imgPath = phoneCase.getImg();

                    String pcaseType = URLEncoder.encode(caseType);
                    String pcaseName = URLEncoder.encode(caseName);
                    String pexplanation = URLEncoder.encode(explanation);
            %>      
            <tr>
                <td align="center"><a href="update?caseID=<%=caseID%>"><%=caseName%>
                    </a></td>
                <td align="center">
                <img src="image/upload/<%=imgPath%>" height="240" width="280"/>    
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
    </center>
    <form action="create" method="post">
        <input type="submit" value="새 상품 추가">
    </form>
</body>
</html>
