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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Q&A</title>
        <% ArrayList<Qna> qnas = (ArrayList<Qna>) request.getAttribute("qnas");%>
        <%User user = (User) request.getAttribute("user");%>
        <%session.setAttribute("user", user);%>
        <%session.setAttribute("qnas", qnas);%>
    </head>
    <body>
         <table border="0px">
            <tr>
                <% if (user == null) {
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


    <center></br></br><img src="image\qnalist.jpg"><br><br></center>
    <center><form action ="searchQnA" method="post">
            <img src="image\search.png" height="17" width="17">
            <input type="text" size="16" name="userName">
            <input type="submit" value="검색">
        </form></center>
    <center><table>
            <tr>
                </br><th width="60" height="35"><img src="image\boardnum.jpg" width=60 height=40"></th>
                <th width="250" height="35"><img src="image\boardtitle.jpg" width=250 height=40"></th>
                <th width="120" height="35"><img src="image\writer.jpg" width=120 height=40"></th>
                <th width="140" height="35"><img src="image\writedate.jpg" width=140 height=40"></th>
                <th width="40" height="40"><input type="image" src="image\deletePink.jpg" value ="삭제" aline="absmiddle" width=50 height=40>

            </tr>
            <%
                for (int i = 0; i < qnas.size(); i++) {
                    Qna qna = qnas.get(i);
                    int qnaNum = qna.getQnaNum();
                    String userName = qna.getUserName();

                    String passWord = qna.getPassWord();
                    String qnaTitle = qna.getQnaTitle();
                    String qnaContent = qna.getQnaContent();
                    String qnaTime = qna.getQnaTime();
            %>
            <tr>
                <td bgcolor="#dcdcdc" height="40" align="center"><%=qnaNum%></td>
                <td bgcolor="#dcdcdc" height="40" align="center">
                    <a href="showQna?qnaNum=<%=qnaNum%>"><%=qnaTitle%></a></td>
                <td bgcolor="#dcdcdc" height="40" align="center"><%=userName%></td>
                <td bgcolor="#dcdcdc" height="40" align="center"><%=qnaTime%></td>
                <td bgcolor="#dcdcdc" height="40" align="center">
                    <form action="deleteQna" methor="post">
                        <input type="hidden" name="qnaNum" value="<%=qnaNum%>">
                        <input type="image" src="image\delete.jpg" value ="삭제" aline="absmiddle">
                    </form>
                </td>   
            </tr>
            <% }%>
        </table></br></br>
        <form action="createQna" method="post">
            <input type="image" src="image\boardwrite.jpg" value ="글쓰기" aline="absmiddle">
        </form>
    </center>
</body>
</html>
