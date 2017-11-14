<%-- 
    Document   : main
    Created on : 2017. 11. 3, ?? 12:35:30
    Author     : yukih
    modify     : ha0
--%>
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
        <title>퐁장-나만의 폰 공장</title>
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
            <td><a OnClick="alert('로그인을 해주세요!')" style="cursor:pointer">
                   <img src="image\cart.jpg"></a>
            </td>
            <td><a OnClick="alert('로그인을 해주세요!')" style="cursor:pointer">
                    <img src="image\order.jpg"></a>
            </td>
            <td><a OnClick="alert('로그인을 해주세요!')" style="cursor:pointer">
                    <input type="submit" value ="MY PAGE"></a>
            </td>
                <% } else { session.setAttribute("user", user); %>
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
                    <input type="submit" value ="MY PAGE">
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

    <br><br>
    <font size="5"><center><b>&nbsp;&nbsp;BEST ITEMS<sup><font size="1" color="red">HIT!</font></sup></b></font>
        <hr width="13%" size="2" color="gray"></center><br>

    <table align="center" width ="1000" height="600" cellpadding="15">
        <td width="25%">
            <a href="Top-1.jsp"><img src = "image\TOP1.gif"  alt="컨트롤 맨투맨" title="컨트롤 맨투맨"><br><br>컨트롤 맨투맨(기모)</a>
            <br><hr size="1" color="black">
            <img src = "image\ic_best.png"><br>
            <font size="4"><b>8,500원</b></font>
        </td>
        <td width="25%">
            <a href="Top-2.jsp"><img src = "image\TOP2.gif"  alt="프리즈 체크셔츠" title="프리즈 체크셔츠"><br><br>프리즈 체크셔츠 | 기모 피치면</a>
            <br><hr size="1" color="black">
            <img src = "image\ic_best.png"> <img src = "image\ic_new.gif"> <img src = "image\ic_sale.gif"><br>
            <font size="4"><b><s>16,000원</s>  → 12,000원</b></font>
        </td>
        <td width="25%">
            <a href="Top-3.jsp"><img src = "image\TOP3.gif"  alt="오레오 폴라티" title="오레오 폴라티"><br><br>오레오 폴라티 | 목폴라 루즈핏</a>
            <br><hr size="1" color="black">
            <img src = "image\ic_best.png"> <img src = "image\ic_new.gif">  <img src = "image\ic_66size.gif"><br>
            <font size="4"><b>17,000원</b></font>
        </td>
        <td width="25%">
            <a href="Bottom-7.jsp"><img src = "image\BOTTOM7.jpg"  alt="베티 테니스스커트" title="베티 테니스스커트"><br><br>베티 테니스스커트 | 체크 치마 주름치마
                <br><hr size="1" color="black">
                <img src = "image\ic_best.png"><br>
                <font size="4"><b>16,900원</b></font>
        </td>
    </tr>
    <tr>
        <td width="25%">
            <a href="Bottom-1.jsp"><img src = "image\BOTTOM1.gif"  alt="하모니 스커트" title="하모니 스커트"><br><br>하모니 스커트 | 모직 치마 H라인</a>
            <br><hr size="1" color="black">
            <img src = "image\ic_best.png"><br>
            <font size="4"><b>8,500원</b></font>
        </td>
        <td width="25%">
            <a href="Bottom-4.jsp"><img src = "image\BOTTOM4.gif"  alt="아몬드봉봉 밴딩슬랙스" title="아몬드봉봉 밴딩슬랙스"><br><br>아몬드봉봉 밴딩슬랙스 | 면바지 기모바지 배기팬츠</a>
            <br><hr size="1" color="black">
            <img src = "image\ic_best.png"> <img src = "image\ic_66size.gif"> <img src = "image\ic_sale.gif"> <br>
            <font size="4"><b><s>12,000원</s> -> 8,900원</b></font>
        </td>
        <td width="25%">
            <a href="Outer-1.jsp"><img src = "image\OUT1.gif"  alt="교복 떡볶이코트" title="교복 떡볶이코트"><br><br>(누빔)교복 떡볶이코트 | 크림떡볶이 더블코트 아우터</a>
            <br><hr size="1" color="black">
            <img src = "image\ic_best.png"> <img src = "image\ic_new.gif"> <img src = "image\ic_sale.gif"> <img src = "image\ic_66size.gif"><br>
            <font size="4"><b><s>45,000원</s>  → 35,500원</b></font>
        </td>
        <td width="25%">
            <a href="Outer-2.jsp"><img src = "image\OUT2.gif"  alt="리얼라쿤퍼 롱패딩" title="리얼라쿤퍼 롱패딩"><br><br>리얼라쿤퍼 롱패딩 | 패딩 아우터 점퍼 야상</a>
            <br><hr size="1" color="black">
            <img src = "image\ic_best.png"> <img src = "image\ic_today1.gif"> <img src = "image\ic_sale.gif"> <img src = "image\ic_66size.gif"> <br>
            <font size="4"><b><s>65,000원</s>  → 52,000원</b></font>
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
            <a href="Top-2.jsp"><img src = "image\TOP2.gif"  alt="프리즈 체크셔츠" title="프리즈 체크셔츠"><br><br>프리즈 체크셔츠 | 기모 피치면</a>
            <br><hr size="1" color="black">
            <img src = "image\ic_best.png"> <img src = "image\ic_new.gif"> <img src = "image\ic_sale.gif"><br>
            <font size="4"><b><s>16,000원</s>  → 12,000원</b></font>
        </td>
        <td width="25%">
            <a href="Top-3.jsp"><img src = "image\TOP3.gif"  alt="오레오 폴라티" title="오레오 폴라티"><br><br>오레오 폴라티 | 목폴라 루즈핏</a>
            <br><hr size="1" color="black">
            <img src = "image\ic_best.png"> <img src = "image\ic_new.gif">  <img src = "image\ic_66size.gif"><br>
            <font size="4"><b>17,000원</b></font>
        </td>
        <td width="25%">
            <a href="Top-4.jsp"><img src = "image\TOP4.gif"  alt="폴인러브 후드" title="폴인러브 후드"><br><br>폴인러브 후드(기모)</a>
            <br><hr size="1" color="black">
            <img src = "image\ic_new.gif"> <img src = "image\ic_today1.gif"> <img src = "image\ic_66size.gif"><br>
            <font size="4"><b>12,500원</b></font>
        </td>
        <td width="25%">
            <a href="Bottom-2.jsp"><img src = "image\BOTTOM2.gif"  alt="겨울 트레이닝팬츠" title="겨울 트레이닝팬츠"><br><br>(양기모)겨울 트레이닝팬츠 | 반바지 롤업 팬츠 츄리닝</a>
            <br><hr size="1" color="black">
            <img src = "image\ic_new.gif"> <img src = "image\ic_66size.gif"> <img src = "image\ic_sale.gif"><br>
            <font size="4"><b><s>7,000원</s> -> 5,000원</b></font>
        </td>
    </tr>
    <tr>
        <td width="25%">
            <a href="Bottom-3.jsp"><img src = "image\BOTTOM3.gif"  alt="디오 데님스커트" title="디오 데님스커트"><br><br>디오 데님스커트 | 치마 청스커트</a>
            <br><hr size="1" color="black">
            <img src = "image\ic_new.gif"><br>
            <font size="4"><b>11,900원</b></font>
        </td>
        <td width="25%">
            <a href="Bottom-6.jsp"><img src = "image\BOTTOM6.gif"  alt="굿모닝 트레이닝팬츠" title="굿모닝 트레이닝팬츠"><br><br>(기모)굿모닝 트레이닝팬츠 | 츄리닝 조거팬츠 홈웨어
                <br><hr size="1" color="black">
                <img src="image\ic_new.gif"> <img src="image\ic_66size.gif"> <img src="image\ic_sale.gif"><br>
                <font size="4"><b>10,500원</b></font>
        </td>
        <td width="25%">
            <a href="Top-7.jsp"><img src = "image\OUT7.gif"  alt="오토 코트" title="오토 코트"><br><br>(누빔)오토 코트 | 지퍼점퍼 양털코트 아우터
                <br><hr size="1" color="black">
                <img src = "image\ic_new.gif"> <img src = "image\ic_66size.gif"><br>
                <font size="4"><b>42,900원</b></font>
        </td>
        <td width="25%">
            <a href="Top-1.html"><img src = "image\SHO1.jpg"  alt="아이러너 슈즈" title="아이러너 슈즈"><br><br>아이러너 슈즈 | 스트랩힐</a>
            <br><hr size="1" color="black">
            <img src = "image\ic_new.gif"><br>
            <font size="4"><b>19,500원</b></font>
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