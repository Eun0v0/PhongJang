
<%@page import="java.util.Iterator" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr"%>
<%@page import="domain.User"%>
<jsp:useBean id="status" scope="request" class="util.Status"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>상품 추가</title>
        <%  User user = (User) request.getAttribute("user");
            session.setAttribute("user", user);%></head>
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
    <%--여기서부터 코드내용--%>

    <center> <h2>상품 추가 페이지 입니다.</h2> </center>
        <%if ((status != null) && !status.isSuccessful()) {%>
        <font color="red">There were problems processing your request:
        <ul><%Iterator errors = status.getExceptions();
            while (errors.hasNext()) {
                Exception ex = (Exception) errors.next();%>
            <li><%= ex.getMessage()%><%}%></ul></font><%}%>
        <form action="createprocess" method="post" enctype="multipart/form-data"> 
            <center>
            <table width="1100" height="300">
                <tr>
                    <td width="900">
                        <hr size="1"><br>
                        <div align="left"><font size="2">케이스 이름</font></div>
                        <div align="right"><input type="text" name="caseName" size="40" padding="10px"></div>
                        <div align="left"><font size="2">케이스 타입</font></div>
                        <div align="right"><select name="caseType" >
                                <option name="caseType" value="unknown">-----
                                <option name="caseType" value="젤리">젤리
                                <option name="caseType" value="하드">하드
                                <option name="caseType" value="범퍼">범퍼</select></div>
                        <div align="left"><font size="2">가격</font></div>
                        <div align="right"><input type="text" name="price" size="10" padding="10px">원</div>
                        <div align="left"><font size="2">설명</font></div>
                        <div align="right"><textarea name="explanation" cols="65" rows="4"></textarea></div>

                        <div align="left">상품이미지 : </div>
                        <div align="right"><input type="file" name="img"><br> </div>
                        <hr size="1">
                <%--<tr><td>케이스 타입:</td><td>
                        <input type="text" name="caseType" size="20"></td></tr>
                
                <tr><td>케이스 이름:</td><td>
                        <input type="text" name="caseName" size="20"></td></tr>
                <tr><td>설명:</td><td>
                        <input type="text" name="explanation" size="50"></td></tr>
                <tr><td>가격:</td><td>
                        <input type="text" name="price" size="5"></td></tr>--%>

                    </td>
                </tr>
            </table>
                <table>

                    <td><tr><input type="submit" value="등록"> &nbsp;&nbsp; <input type="reset" value="다시쓰기"> </tr> </td>
                </table>
            <hr size="1" width="1100">
        </form>
        </center>
    </body>

</html>