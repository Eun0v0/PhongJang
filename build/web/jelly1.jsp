<%-- 
    Document   : jelly1
    Created on : 2017. 11. 14, ���� 1:00:58
    Author     : Hayoung_2
--%>
<%--�ؾ��� �� : ��ٱ���, �ٷΰ��� ��ư �ٲٱ�?--%>
<%-- test --%>
<%@page import="java.util.ArrayList"%>
<%@page import="domain.PhoneCase"%>
<%@page import="domain.Payment"%>
<%@page import="domain.User"%>
<%@page import="java.util.Iterator" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr"%>
<jsp:useBean id="status" scope="request" class="util.Status"/>
<%@ page import="java.sql.*" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>�� ���������� ���̽�</title>
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
            <%  User user = (User) request.getAttribute("user");
            if (user == null) { %>
            <td><img src="image\login.jpg" onClick="location.assign('login.jsp')"></td>
            <td><a OnClick="alert('�α����� ���ּ���!')" style="cursor:pointer">
                   <img src="image\cart.jpg"></a>
            </td>
            <td><a OnClick="alert('�α����� ���ּ���!')" style="cursor:pointer">
                    <img src="image\order.jpg"></a>
            </td>
                <% } else { session.setAttribute("user", user); %>
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
            <% if (user != null) { %>
            <center> <div align="middle">
                <form action="main" method="post">
                    <input type="hidden" name="userID" value="<%=user.getId()%>">
                    <input type="image" src="image\banner.jpg" name="Submit">
                </form>
            </div> </center>
            <% } else {%>
            <center> <div align="middle"> <img src="image\banner2.jpg" onClick="location.assign('main.jsp')"> </div> </center>
            <% } %>
            
            <form action ="search.action" name="search" method="search">
                <img src="image\search.png" height="17" width="17">
                <input type="text" size="16" name="keyword" value="${keyword}">
                <input type="button" value="�˻�" onClick="check()">
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

    <%--���⼭���� �ڵ峻��--%>

    <br><br>
<form name="myForm" method="post">
<table width="1100" height="300">
<tr>
<td><img src="image\BOTTOM1-5.jpg" width="600" height="360"></td>
<td width="900">
<hr size="1"><img src="image\ic_best.png"><br>
<label for="g_name">�� ���������� ���̽�</label>
<hr size="1"><br>
<div align="left"><font size="2">���Ű�</font></div>
<label for="g_price"><div align="right"><font size="4"><b>13,500��</b></font></div></label>
<div align="left"><font size="2">�ڵ��� ����</font></div>
<div align="right">
<input type="text" name="phone" size="8" list="phone">
<datalist id="phone">
<option value="������ 6/6s"></option>
<option value="������ 6+/6s+"></option>
<option value="������ 7"></option>
<option value="������ 7+"></option>
<option value="������ 8"></option>
<option value="������ 8+"></option>
</datalist>
<div align="left"><font size="2">����</font></div>
<div align="right">
<input type="text" name="color" size="8" list="color">
<datalist id="color">
<option value="ȭ��Ʈ"></option>
<option value="��"></option>
<option value="����"></option>
<option value="��ũ"></option>
<option value="���ο�"></option>
<option value="����"></option>
</datalist>
</div>
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
<center><font size="4" face="10x10">
<font color="orange">*�� ���������ܿ� ���������ܿ� ���������ܿ� ���� ��~~!</font>
<br><br><b><u>-comment-</u></b><br><br>
�� ���� �� ���� ��ų���<br>
�� �������� �� oh ���϶� ����<br>
like ����ó�� ������ my heart<br>
��� ������ ����<br>
<br><br>
<font size="5"><b>������ ����<br><br></b></font>
<font size="4" color="gray"><b>������ 6/6s (plus), ������ 7 (plus), ������ 8 (plus)</b></font><br><br>

<img src="image\BOTTOM1-1.jpg">

</center></font>

<%--���� ��� �ֱ�--%>

<hr size="2" color="black">

<div id="gotop">
    <a href="#top"><img src="image\up.jpg" height="35" width="50"></a><br>
    <img src="image\cursor1.jpg" height="50" width="50"> <br>
    <a href="#bottom"> <img src="image\down.jpg" height="35" width="50"> </a> 
</div>

<script type="text/javascript">initMoving(document.getElementById("gotop"), 50, 50, 50);</script> 

<a href="#top" name="bottom"><img src="image\totop.jpg" align="right"></a>

</body>
</html>