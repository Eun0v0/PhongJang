<%-- 
    Document   : qna
    Created on : 2017. 11. 17, 오전 2:03:20
    Author     : user
--%>
<%-- test --%>
<%@page import="java.util.ArrayList"%>
<%@page import="domain.User"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="domain.Qna"%>
<%@page import="java.util.Iterator" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
        <title>Q&A</title>
        <% ArrayList<Qna> qnas = (ArrayList<Qna>) request.getAttribute("qnas");%>
        <%User user = (User) request.getAttribute("user");%>
        <%session.setAttribute("user", user);%>
        <%session.setAttribute("qnas", qnas);%>
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
                <td><a OnClick="alert('로그인을 해주세요!')" style="cursor:pointer">
                        &nbsp;
                        <input type="image" src="image\myPageUp_1.jpg" name="Submit" value ="MY PAGE"></a>
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
                <td><form action="IDCheck" method="post">
                        <input type="image" src="image\join.jpg" name="Submit" value ="회원가입">
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

    <center></br></br><img src="image\qnalist.jpg"><br><br></center>
    <center><table>
            <tr>
                <th width="60" height="35"><img src="image\boardnum.jpg" width=60 height=40"></th>
                <th width="250" height="35"><img src="image\boardtitle.jpg" width=250 height=40"></th>
                <th width="120" height="35"><img src="image\writer.jpg" width=120 height=40"></th>
                <th width="140" height="35"><img src="image\writedate.jpg" width=140 height=40"></th>
                <th width="60" height="35"><img src="image\view.jpg" width=60 height=40"></th>
                <th width="30" height="35">삭제</th>
            </tr>
            <%
                for (int i = 0; i < qnas.size(); i++) {
                    Qna qna = qnas.get(i);
                    int qnaNum = qna.getQnaNum();
                    String userName = qna.getUserName();
                    int passWord = qna.getPassWord();
                    String qnaTitle = qna.getQnaTitle();
                    String qnaContent = qna.getQnaContent();
                    String qnaTime = qna.getQnaTime();
                    
                    String puserName = URLEncoder.encode(userName);
                    String pqnaTitle = URLEncoder.encode(qnaTitle);
                    String pqnaContent =URLEncoder.encode(qnaContent);
            %>
            <tr>
                <td bgcolor="#dcdcdc" height="40" align="center"><a href="update?qnaNum=<%=qnaNum%>"></a></td>
                <td bgcolor="#dcdcdc" height="40"><a href="update?userName=<%=userName%>"></a></td>
                <td bgcolor="#dcdcdc" height="40" align="center"><a href="update?qnaTitle=<%=qnaTitle%>"></a></td>
                <td bgcolor="#dcdcdc" height="40" align="center"><a href="update?qnaTime=<%=qnaTime%>"></a></td>
                <td bgcolor="#dcdcdc" height="40" align="center">삭제</td>   
            </tr>
            <% }%>
        </table></br></br>
        <form action="createQna" method="post">
            <!-- <input type="image" src="image\boardwrite.jpg" value ="글쓰기" aline="absmiddle">-->
            <input type="submit" value="글쓰기">
        </form>
    </center>
</body>
</html>
