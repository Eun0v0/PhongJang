<%-- 
    Document   : paymentConfirm
    Created on : 2017. 11. 11, 오후 10:56:28
    Author     : yukih
--%>
<%-- test --%>
<%@page import="domain.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>결제 완료!</title>
    </head>
    <body>
        <table border="0px">
            <tr>
                <%  User user = (User) request.getAttribute("user");
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
            <% }%>

    <form action ="search.action" name="search" method="search">
        <img src="image\search.png" height="17" width="17">
        <input type="text" size="16" name="keyword" value="${keyword}">
        <input type="button" value="검색" onClick="check()">
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
    <center></br></br>
        <input type="image" src="image\paycomplete.jpg" name="Submit" value ="complete" aline="absmiddle">
        <form action="paymentlist" method="post">
            </br></br><input type="image" src="image\orderlistbutton.jpg" name="Submit" value ="주문목록" aline="absmiddle">
        </form>
    </center>
</body>
</html>

