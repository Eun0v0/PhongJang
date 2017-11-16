<%-- 
    Document   : update
    Created on : 2017. 11. 12, 오후 8:13:24
    Author     : yukih
--%>

<%@page import="java.util.Iterator" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr"%>
<%@page import="domain.PhoneCase"%>
<%@page import="domain.User"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<jsp:useBean id="status" scope="request" class="util.Status"/>
<html>
    <head>
        
        <title>Update Form</title>
        <%  ArrayList<PhoneCase> phoneCases = (ArrayList<PhoneCase>) request.getAttribute("phoneCases");
  
            User user = (User)request.getAttribute("user");
            int caseID = (int)request.getAttribute("caseID");
           
            session.setAttribute("user", user);
            session.setAttribute("phoneCases", phoneCases);
        %>
    
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
            
                <% } else { session.setAttribute("user", user); %>
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
            <% if (user != null) { %>
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

        <h2>Hello, <%=user.getName()%><br/>제품 수정 페이지 입니다.</h2>
            <%if ((status != null) && !status.isSuccessful()) {%>
        <font color="red">There were problems processing your request:
        <ul><%Iterator errors = status.getExceptions();
            while (errors.hasNext()) {
                Exception ex = (Exception) errors.next();%>
            <li><%= ex.getMessage()%><%}%></ul></font><%}%>
        
        <form action="updateprocess" method="post">
            <table>
                <tr><td>케이스 번호:</td><td>
                    <%=caseID%></tr>
                <tr><td>케이스 타입:</td><td>
                        <textarea name="caseType" size="20"><%=request.getAttribute("caseType")%></textarea>
                        <%--<input type="text" name="caseType" size="20"></td></tr>--%>
                <tr><td>케이스 이름:</td><td>
                        <textarea name="caseName" size="20"><%=request.getAttribute("caseName")%></textarea>
                        <%--<input type="text" name="caseName" size="20"></td></tr>--%>
                <tr><td>설명:</td><td>
                        <textarea name = "explanation" size="50"><%= request.getAttribute("explanation")%></textarea>
                        <%--<input type="text" name="explanation" size="50"></td></tr>--%>
                <tr><td>가격:</td><td>
                        <textarea name="price" size="5"><%=request.getAttribute("price")%></textarea>
                        <%--<input type="text" name="price" size="5"></td></tr>--%>
            </table>
            <input type="hidden" name="caseID" value="<%=caseID%>">
            <input type="submit" value="Submit">
        </form>         
    </body>
</html>
?