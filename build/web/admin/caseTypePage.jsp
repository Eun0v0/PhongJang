<%-- 
    Document   : main
    Created on : 2017. 11. 3, ?? 12:35:30
    Author     : yukih
    modify     : ha0
--%>
<%@page import="domain.PhoneCaseService"%>
<%@page import="java.net.URLEncoder"%>
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
                        <input type="submit" value="상품 추가">
                    </a></td>
                <td><a OnClick="alert('로그인을 해주세요!')" style="cursor:pointer">
                        <input type="submit" value="재고 관리">
                    </a></td>
                <td><a OnClick="alert('로그인을 해주세요!')" style="cursor:pointer">
                        <img src="image\order.jpg"></a>
                </td>

                <% } else {
                    session.setAttribute("user", user); %>
                <td><form action="logout" method="post">
                        <input type="image" src="image\logout.jpg" name="Submit" value ="로그아웃">
                    </form> 
                </td>
                <td><form action="create" method="post">
                        <input type="submit" value="상품 추가">
                    </form>
                </td>
                <td><form action="manageStock" method="post">
                        <input type="submit" value="재고 관리">
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
        <% if (user != null) {%>
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
    </center>
    <hr size="5" color="black">

    <br><br>
    <%String m_caseType = (String) request.getAttribute("caseType");%>
    <font size="5"><center><b>&nbsp;&nbsp;<%=m_caseType%> 케이스<sup><font size="1" color="red">HIT!</font></sup></b></font>
        <hr width="13%" size="2" color="gray"></center><br>

    <table align="center" width ="1000" height="400" cellpadding="15">
        <tr>
            <%
                ArrayList<PhoneCase> phoneCases = (ArrayList<PhoneCase>) request.getAttribute("phoneCases");
                session.setAttribute("phoneCases", phoneCases);
                for (int i = 0; i < phoneCases.size(); i++) {
                    PhoneCase phoneCase = phoneCases.get(i);
                    int caseID = phoneCase.getCaseID();
                    String caseType = phoneCase.getCaseType();
                    String caseName = phoneCase.getCaseName();
                    String explanation = phoneCase.getExplanation();
                    int price = phoneCase.getPrice();
                    String imgPath = phoneCase.getImg();
            %>
            <td width="25%">
                <a href="detailPage?caseID=<%=caseID%>"><img src = "image/upload/<%=imgPath%>" height="240" width="280" alt="<%=caseName%>" title="<%=caseName%>"/><br><br><%=caseName%>(<%=caseType%>)</a>
                <br><hr size="1" color="black">
                <img src = "image\ic_best.png"><br>
                <font size="4"><b><%=price%>원</b></font>
            </td>
            <% }%>
    </table>
    <div id="gotop">
        <a href="#top"><img src="image\up.jpg" height="35" width="50"></a><br>
        <img src="image\cursor1.jpg" height="50" width="50"> <br>
        <a href="#bottom"> <img src="image\down.jpg" height="35" width="50"> </a> 
    </div>

    <script type="text/javascript">initMoving(document.getElementById("gotop"), 50, 50, 50);</script> 

    <a href="#top" name="bottom"><img src="image\totop.jpg" align="right"></a>

</body>
</html>