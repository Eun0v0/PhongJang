<%-- 
    Document   : main
    Created on : 2017. 11. 3, ?? 12:35:30
    Author     : yukih
    modify     : ha0
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="domain.PhoneCase"%>
<%@page import="domain.User"%>
<%@page session="false" import="java.util.Iterator" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr"%>
<jsp:useBean id="status" scope="request" class="util.Status"/>
<%@ page import="java.sql.*" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Phong Jang</title>
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
<<<<<<< HEAD
        <%  String name = "";
    if (name == null || name.equals("")) { %>
        <img src="image\login.jpg" onClick="location.assign('login.jsp')">
        <% } 
    else { %>
        <img src="image\logout.jpg" onClick="location.assign('logout.jsp')">
        <%  }%>
        <a href="cart_list.jsp"><img src="image\cart.jpg"></a>
        <a href="order_list.jsp"><img src="image\order.jpg"></a>
        <a href="join.jsp"><img src="image\join.jpg"></a>
        <a href="board\board-list.jsp"><img src="image\q&a.jpg"></a>

    <center> <div align="middle"> <img src="image\banner.jpg" onClick="location.assign('main.jsp')"> </div> </center>

        <hr size="5" color="black">
=======
        <table border="0px">
        <tr>
            <%  User user = (User) request.getAttribute("user");
            if (user == null) { %>
            <td><img src="image\login.jpg" onClick="location.assign('login.jsp')"></td>
            <td><td><a href="cart.jsp"><img src="image\cart.jpg"></a></td>
                <% } else { session.setAttribute("user", user); %>
            <td><img src="image\logout.jpg" onClick="location.assign('logout.jsp')"></td>
            <td><form action="cart" method="post">
                    <input type="hidden" name="userID" value="<%=user.getId()%>">
                    <input type="image" src="image\cart.jpg" name="Submit" value ="Àå¹Ù±¸´Ï">
                </form> </td>
                <%  }%>
            
            <td><a href="order_list.jsp"><img src="image\order.jpg"></a></td>
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
    <hr size="5" color="black">
>>>>>>> parent of 99d5e4d... ì˜ì¨©ì˜ ê²€ìƒ‰uië§Œë“¤ê¸°
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

    <br><br>
    <font size="5"><center><b>&nbsp;&nbsp;BEST ITEMS<sup><font size="1" color="red">HIT!</font></sup></b></font>
        <hr width="13%" size="2" color="gray"></center><br>

    <table align="center" width ="1000" height="600" cellpadding="15">
        <td width="25%">
            <a href="Top-1.jsp"><img src = "image\TOP1.gif"  alt="ÄÁÆ®·Ñ ¸ÇÅõ¸Ç" title="ÄÁÆ®·Ñ ¸ÇÅõ¸Ç"><br><br>ÄÁÆ®·Ñ ¸ÇÅõ¸Ç(±â¸ð)</a>
            <br><hr size="1" color="black">
            <img src = "image\ic_best.png"><br>
            <font size="4"><b>8,500¿ø</b></font>
        </td>
        <td width="25%">
            <a href="Top-2.jsp"><img src = "image\TOP2.gif"  alt="ÇÁ¸®Áî Ã¼Å©¼ÅÃ÷" title="ÇÁ¸®Áî Ã¼Å©¼ÅÃ÷"><br><br>ÇÁ¸®Áî Ã¼Å©¼ÅÃ÷ | ±â¸ð ÇÇÄ¡¸é</a>
            <br><hr size="1" color="black">
            <img src = "image\ic_best.png"> <img src = "image\ic_new.gif"> <img src = "image\ic_sale.gif"><br>
            <font size="4"><b><s>16,000¿ø</s>  ¡æ 12,000¿ø</b></font>
        </td>
        <td width="25%">
            <a href="Top-3.jsp"><img src = "image\TOP3.gif"  alt="¿À·¹¿À Æú¶óÆ¼" title="¿À·¹¿À Æú¶óÆ¼"><br><br>¿À·¹¿À Æú¶óÆ¼ | ¸ñÆú¶ó ·çÁîÇÍ</a>
            <br><hr size="1" color="black">
            <img src = "image\ic_best.png"> <img src = "image\ic_new.gif">  <img src = "image\ic_66size.gif"><br>
            <font size="4"><b>17,000¿ø</b></font>
        </td>
        <td width="25%">
            <a href="Bottom-7.jsp"><img src = "image\BOTTOM7.jpg"  alt="º£Æ¼ Å×´Ï½º½ºÄ¿Æ®" title="º£Æ¼ Å×´Ï½º½ºÄ¿Æ®"><br><br>º£Æ¼ Å×´Ï½º½ºÄ¿Æ® | Ã¼Å© Ä¡¸¶ ÁÖ¸§Ä¡¸¶
                <br><hr size="1" color="black">
                <img src = "image\ic_best.png"><br>
                <font size="4"><b>16,900¿ø</b></font>
        </td>
    </tr>
    <tr>
        <td width="25%">
            <a href="Bottom-1.jsp"><img src = "image\BOTTOM1.gif"  alt="ÇÏ¸ð´Ï ½ºÄ¿Æ®" title="ÇÏ¸ð´Ï ½ºÄ¿Æ®"><br><br>ÇÏ¸ð´Ï ½ºÄ¿Æ® | ¸ðÁ÷ Ä¡¸¶ H¶óÀÎ</a>
            <br><hr size="1" color="black">
            <img src = "image\ic_best.png"><br>
            <font size="4"><b>8,500¿ø</b></font>
        </td>
        <td width="25%">
            <a href="Bottom-4.jsp"><img src = "image\BOTTOM4.gif"  alt="¾Æ¸óµåºÀºÀ ¹êµù½½·¢½º" title="¾Æ¸óµåºÀºÀ ¹êµù½½·¢½º"><br><br>¾Æ¸óµåºÀºÀ ¹êµù½½·¢½º | ¸é¹ÙÁö ±â¸ð¹ÙÁö ¹è±âÆÒÃ÷</a>
            <br><hr size="1" color="black">
            <img src = "image\ic_best.png"> <img src = "image\ic_66size.gif"> <img src = "image\ic_sale.gif"> <br>
            <font size="4"><b><s>12,000¿ø</s> -> 8,900¿ø</b></font>
        </td>
        <td width="25%">
            <a href="Outer-1.jsp"><img src = "image\OUT1.gif"  alt="±³º¹ ¶±ººÀÌÄÚÆ®" title="±³º¹ ¶±ººÀÌÄÚÆ®"><br><br>(´©ºö)±³º¹ ¶±ººÀÌÄÚÆ® | Å©¸²¶±ººÀÌ ´õºíÄÚÆ® ¾Æ¿ìÅÍ</a>
            <br><hr size="1" color="black">
            <img src = "image\ic_best.png"> <img src = "image\ic_new.gif"> <img src = "image\ic_sale.gif"> <img src = "image\ic_66size.gif"><br>
            <font size="4"><b><s>45,000¿ø</s>  ¡æ 35,500¿ø</b></font>
        </td>
        <td width="25%">
            <a href="Outer-2.jsp"><img src = "image\OUT2.gif"  alt="¸®¾ó¶óÄïÆÛ ·ÕÆÐµù" title="¸®¾ó¶óÄïÆÛ ·ÕÆÐµù"><br><br>¸®¾ó¶óÄïÆÛ ·ÕÆÐµù | ÆÐµù ¾Æ¿ìÅÍ Á¡ÆÛ ¾ß»ó</a>
            <br><hr size="1" color="black">
            <img src = "image\ic_best.png"> <img src = "image\ic_today1.gif"> <img src = "image\ic_sale.gif"> <img src = "image\ic_66size.gif"> <br>
            <font size="4"><b><s>65,000¿ø</s>  ¡æ 52,000¿ø</b></font>
        </td>
    </tr>
</table>

<br><br>
<hr size="2" color="gray"><br><br>
<font size="5"><center><b>NEW GOODS</b></font>
    <hr width="13%" size="2" color="gray"></center><br>

<table align="center" width ="1000" height="600" cellpadding="15">
    <tr>
        <td width="25%">
            <a href="Top-2.jsp"><img src = "image\TOP2.gif"  alt="ÇÁ¸®Áî Ã¼Å©¼ÅÃ÷" title="ÇÁ¸®Áî Ã¼Å©¼ÅÃ÷"><br><br>ÇÁ¸®Áî Ã¼Å©¼ÅÃ÷ | ±â¸ð ÇÇÄ¡¸é</a>
            <br><hr size="1" color="black">
            <img src = "image\ic_best.png"> <img src = "image\ic_new.gif"> <img src = "image\ic_sale.gif"><br>
            <font size="4"><b><s>16,000¿ø</s>  ¡æ 12,000¿ø</b></font>
        </td>
        <td width="25%">
            <a href="Top-3.jsp"><img src = "image\TOP3.gif"  alt="¿À·¹¿À Æú¶óÆ¼" title="¿À·¹¿À Æú¶óÆ¼"><br><br>¿À·¹¿À Æú¶óÆ¼ | ¸ñÆú¶ó ·çÁîÇÍ</a>
            <br><hr size="1" color="black">
            <img src = "image\ic_best.png"> <img src = "image\ic_new.gif">  <img src = "image\ic_66size.gif"><br>
            <font size="4"><b>17,000¿ø</b></font>
        </td>
        <td width="25%">
            <a href="Top-4.jsp"><img src = "image\TOP4.gif"  alt="ÆúÀÎ·¯ºê ÈÄµå" title="ÆúÀÎ·¯ºê ÈÄµå"><br><br>ÆúÀÎ·¯ºê ÈÄµå(±â¸ð)</a>
            <br><hr size="1" color="black">
            <img src = "image\ic_new.gif"> <img src = "image\ic_today1.gif"> <img src = "image\ic_66size.gif"><br>
            <font size="4"><b>12,500¿ø</b></font>
        </td>
        <td width="25%">
            <a href="Bottom-2.jsp"><img src = "image\BOTTOM2.gif"  alt="°Ü¿ï Æ®·¹ÀÌ´×ÆÒÃ÷" title="°Ü¿ï Æ®·¹ÀÌ´×ÆÒÃ÷"><br><br>(¾ç±â¸ð)°Ü¿ï Æ®·¹ÀÌ´×ÆÒÃ÷ | ¹Ý¹ÙÁö ·Ñ¾÷ ÆÒÃ÷ Ãò¸®´×</a>
            <br><hr size="1" color="black">
            <img src = "image\ic_new.gif"> <img src = "image\ic_66size.gif"> <img src = "image\ic_sale.gif"><br>
            <font size="4"><b><s>7,000¿ø</s> -> 5,000¿ø</b></font>
        </td>
    </tr>
    <tr>
        <td width="25%">
            <a href="Bottom-3.jsp"><img src = "image\BOTTOM3.gif"  alt="µð¿À µ¥´Ô½ºÄ¿Æ®" title="µð¿À µ¥´Ô½ºÄ¿Æ®"><br><br>µð¿À µ¥´Ô½ºÄ¿Æ® | Ä¡¸¶ Ã»½ºÄ¿Æ®</a>
            <br><hr size="1" color="black">
            <img src = "image\ic_new.gif"><br>
            <font size="4"><b>11,900¿ø</b></font>
        </td>
        <td width="25%">
            <a href="Bottom-6.jsp"><img src = "image\BOTTOM6.gif"  alt="±Â¸ð´× Æ®·¹ÀÌ´×ÆÒÃ÷" title="±Â¸ð´× Æ®·¹ÀÌ´×ÆÒÃ÷"><br><br>(±â¸ð)±Â¸ð´× Æ®·¹ÀÌ´×ÆÒÃ÷ | Ãò¸®´× Á¶°ÅÆÒÃ÷ È¨¿þ¾î
                <br><hr size="1" color="black">
                <img src="image\ic_new.gif"> <img src="image\ic_66size.gif"> <img src="image\ic_sale.gif"><br>
                <font size="4"><b>10,500¿ø</b></font>
        </td>
        <td width="25%">
            <a href="Top-7.jsp"><img src = "image\OUT7.gif"  alt="¿ÀÅä ÄÚÆ®" title="¿ÀÅä ÄÚÆ®"><br><br>(´©ºö)¿ÀÅä ÄÚÆ® | ÁöÆÛÁ¡ÆÛ ¾çÅÐÄÚÆ® ¾Æ¿ìÅÍ
                <br><hr size="1" color="black">
                <img src = "image\ic_new.gif"> <img src = "image\ic_66size.gif"><br>
                <font size="4"><b>42,900¿ø</b></font>
        </td>
        <td width="25%">
            <a href="Top-1.html"><img src = "image\SHO1.jpg"  alt="¾ÆÀÌ·¯³Ê ½´Áî" title="¾ÆÀÌ·¯³Ê ½´Áî"><br><br>¾ÆÀÌ·¯³Ê ½´Áî | ½ºÆ®·¦Èú</a>
            <br><hr size="1" color="black">
            <img src = "image\ic_new.gif"><br>
            <font size="4"><b>19,500¿ø</b></font>
        </td>
    </tr>
</table>

<div id="gotop">
    <a href="#top"><img src="image\up.jpg" height="35" width="50"></a><br>
    <img src="image\cursor.jpg" height="50" width="50"> <br>
    <a href="#bottom"> <img src="image\down.jpg" height="35" width="50"> </a> 
</div>

<script type="text/javascript">initMoving(document.getElementById("gotop"), 50, 50, 50);</script> 

<a href="#top" name="bottom"><img src="image\totop.jpg" align="right"></a>

</body>
</html>