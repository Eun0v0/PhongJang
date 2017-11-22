<%-- 
    Document   : jelly1
    Created on : 2017. 11. 14, 오전 1:00:58
    Author     : Hayoung_2
--%>
<%--해야할 것 : 장바구니, 바로결제 버튼 바꾸기?--%>
<%-- test --%>
<script type ="text/javascript" src="smarteditor/js/HuskyEZCreator.js" charset="euc-kr"></script>
<script>
    function submitContents(elClickedObj) {
        oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);
        try {
            elClickedObj.form.submit();
        } catch (e) {
        }
    }
</script>

<%@page import="java.util.ArrayList"%>
<%@page import="domain.PhoneCase"%>
<%@page import="domain.Payment"%>
<%@page import="domain.User"%>
<%@page import="java.util.Iterator" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr"%>
<jsp:useBean id="status" scope="request" class="util.Status"/>
<%@ page import="java.sql.*" %>
<% request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title><%=request.getAttribute("caseName")%>★</title>
        <%  ArrayList<PhoneCase> phoneCases = (ArrayList<PhoneCase>) request.getAttribute("phoneCases");
            User user = (User) request.getAttribute("user");

            session.setAttribute("user", user);
            session.setAttribute("phoneCases", phoneCases);
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
            <tr><%
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
                <%  }%>

                <td><form action="myPage" method="post">
                        <%--
                            <input type="hidden" name="userID" value="<%=user.getId()%>">
                        --%>
                        &nbsp;
                        <input type="image" src="image\myPageUp_1.jpg" name="Submit" value ="MY PAGE">
                    </form>    
                </td>
                <td><a href="join.jsp"><img src="image\join.jpg"></a></td>
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

    <form action ="search.action" name="search" method="search">
        <img src="image\search.png" height="17" width="17">
        <input type="text" size="16" name="keyword" value="${keyword}">
        <input type="button" value="검색" onClick="check()">
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
                
                <td><a href="event.jsp"><img src="image\event_.jpg" height="35" width="140"></a></td> 
            </tr>
        </table>
    </center>
    <hr size="5" color="black">

    <%--여기서부터 코드내용--%>

    <br><br>
    <center>
        <h1><%=request.getAttribute("caseName")%></h1>
        <form name="take" method="post">
            <table width="1100" height="300">
                <tr>
                    <td><img src="image/upload/<%=request.getAttribute("img")%>" width="400" height="360"></td>

                    <td width="900">
                        <hr size="1"><br>
                        <div align="left"><font size="2">케이스 이름:</font></div>
                        <div align="right"><input type="hidden" name="caseName" value="<%=request.getAttribute("caseName")%>"><%=request.getAttribute("caseName")%></div>
                        <div align="left"><font size="2">케이스 타입:</font></div>
                        <div align="right"><input type="hidden" name="caseName" value="<%=request.getAttribute("caseType")%>"><%=request.getAttribute("caseType")%></div>
                        <div align="left"><font size="2">가격:</font></div>
                        <div align="right"><input type="hidden" name="caseName" value="<%=request.getAttribute("price")%>"><%=request.getAttribute("price")%></div>
                        <div align="left"><font size="2">핸드폰 기종:</font></div>
                        <div align="right"><select name="phoneType" >
                                <option name="caseType" value="unknown">-----
                                <option name="caseType" value="아이폰 6/6s">아이폰 6/6s
                                <option name="caseType" value="아이폰 6+/6s+">아이폰 6+/6s+
                                <option name="caseType" value="아이폰 7">아이폰 7
                                <option name="caseType" value="아이폰 7+">아이폰 7+
                                <option name="caseType" value="아이폰 8">아이폰 8
                            </select></div>
                        <div align="left"><font size="2">색상 선택:</font></div>
                        <div align="right"><select name="caseType" >
                                <option name="caseType" value="unknown">-----
                                <option name="caseType" value="젤리">검정
                                <option name="caseType" value="하드">하양
                                <option name="caseType" value="범퍼">핑크</select></div>
                        <hr size="1">
                <br><center>
                    <input type="image" src="image\bt_cartin.jpg" onClick='mySubmit(1)'>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="image" src="image\bt_buying.jpg" onClick='mySubmit(2)'>
                </center>
                </td>
                </tr>
            </table>
        </form>
        <hr size="1" width="1100">
    </center>
    <br><br>
    <hr size="2" color="black">
    <center>

        <td><img src="image/upload/<%=request.getAttribute("detailImg")%>"></td>

    </center>

    <div id="gotop">
        <a href="#top"><img src="image\up.jpg" height="35" width="50"></a><br>
        <img src="image\cursor1.jpg" height="50" width="50"> <br>
        <a href="#bottom"> <img src="image\down.jpg" height="35" width="50"> </a> 
    </div>

    <script type="text/javascript">initMoving(document.getElementById("gotop"), 50, 50, 50);</script> 

    <a href="#top" name="bottom"><img src="image\totop.jpg" align="right"></a>

</body>
</html>