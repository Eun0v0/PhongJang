<%-- 
    Document   : update
    Created on : 2017. 11. 12, 오후 8:13:24
    Author     : yukih
--%>
<%@page import="domain.Event"%>
<%@page import="domain.Review"%>
<%@page import="domain.CaseColor"%>
<%@page import="domain.PhoneType"%>
<%-- test --%>
<%@page import="java.util.Iterator" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr"%>
<%@page import="domain.PhoneCase"%>
<%@page import="domain.User"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<jsp:useBean id="status" scope="request" class="util.Status"/>
<html>
    <head>

        <title>수정 페이지</title>
        <%  User user = (User) request.getAttribute("user");

            Event event = (Event) request.getAttribute("event");
            session.setAttribute("user", user);
            session.setAttribute("event", event);
        %>
        <script type="text/javascript">
            //<![CDATA[
            function initMoving(target, position, topLimit, btmLimit) {
                if (!target)
                    return false;

                var obj = target;
                obj.initTop = position;
                obj.topLimit = topLimit;
                obj.bottomLimit = Math.max(document.documentElement.scrollHeight, document.body.scrollHeight) - btmLimit - obj.offsetHeight;

                obj.style.position = "absolute";
                obj.top = obj.initTop;
                obj.left = obj.initLeft;

                if (typeof (window.pageYOffset) == "number") {	//WebKit
                    obj.getTop = function () {
                        return window.pageYOffset;
                    }
                } else if (typeof (document.documentElement.scrollTop) == "number") {
                    obj.getTop = function () {
                        return Math.max(document.documentElement.scrollTop, document.body.scrollTop);
                    }
                } else {
                    obj.getTop = function () {
                        return 0;
                    }
                }

                if (self.innerHeight) {	//WebKit
                    obj.getHeight = function () {
                        return self.innerHeight;
                    }
                } else if (document.documentElement.clientHeight) {
                    obj.getHeight = function () {
                        return document.documentElement.clientHeight;
                    }
                } else {
                    obj.getHeight = function () {
                        return 500;
                    }
                }

                obj.move = setInterval(function () {
                    if (obj.initTop > 0) {
                        pos = obj.getTop() + obj.initTop;
                    } else {
                        pos = obj.getTop() + obj.getHeight() + obj.initTop;
                        //pos = obj.getTop() + obj.getHeight() / 2 - 15;
                    }

                    if (pos > obj.bottomLimit)
                        pos = obj.bottomLimit;
                    if (pos < obj.topLimit)
                        pos = obj.topLimit;

                    interval = obj.top - pos;
                    obj.top = obj.top - interval / 3;
                    obj.style.top = obj.top + 220 + "px";
                }, 30)
            }
            //]]>
        </script>

        <style type="text/css">
            #gotop {position: absolute; right: 0px; top: 50px; width: 100px; height: 100px;}
            a{color:black; text-decoration:none;}
        </style>

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


    <%if ((status != null) && !status.isSuccessful()) {%>
    <font color="red">There were problems processing your request:
    <ul><%Iterator errors = status.getExceptions();
        while (errors.hasNext()) {
            Exception ex = (Exception) errors.next();%>
        <li><%= ex.getMessage()%><%}%></ul></font><%}%>
    <center><h1>★이벤트 내용★</h1></center>
    <hr width="30%" size="1" color="gray"></center>
<center>
    <table>
        <tr>
        <br>
        <tr height="1" bgcolor="#ECBFD8"><td colspan="4"></td></tr>
        <tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
        <tr>
            <td>&nbsp;</td>
            <th width="120" height="35">제목</th>
            <td><%=request.getAttribute("title")%></td>
            <td>&nbsp;</td>
        </tr>
        <tr height="1" bgcolor="#dddddd"><td colspan="3"></td></tr>
        <tr>
            <td>&nbsp;</td>
            <th width="60" height="35">부가 설명</th>
            <td><%=request.getAttribute("content")%></td>
            <td>&nbsp;</td>
        </tr>
        <tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
        <tr height="1" bgcolor="#ECBFD8"><td colspan="4"></td></tr>
        <tr align="center">
            <td>&nbsp;</td><br>

        </tr>      
        </center></td></tr>
    </table>
            <br>
    <center><img src="image/upload/<%=request.getAttribute("image")%>" width="600" height="750"></center>
    <hr size="1" width="1100">
</center>
<br><br>

<div id="gotop">
    <a href="#top"><img src="image\up.jpg" height="35" width="50"></a><br>
    <img src="image\cursor1.jpg" height="50" width="50"> <br>
    <a href="#bottom"> <img src="image\down.jpg" height="35" width="50"> </a> 
</div>

<script type="text/javascript">initMoving(document.getElementById("gotop"), 50, 50, 50);</script> 

<a href="#top" name="bottom"><img src="image\totop.jpg" align="right"></a>
</body>
</html>