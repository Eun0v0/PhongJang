<%-- 
    Document   : update
    Created on : 2017. 11. 12, 오후 8:13:24
    Author     : yukih
--%>
<%-- test --%>
<%@page import="java.util.Iterator" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr"%>
<%@page import="domain.PhoneCase"%>
<%@page import="domain.User"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<jsp:useBean id="status" scope="request" class="util.Status"/>
<html>
    <head>
        
        <title>Update Form</title>
        <%  ArrayList<PhoneCase> phoneCases = (ArrayList<PhoneCase>) request.getAttribute("phoneCases");
  
            User user = (User)request.getAttribute("user");
            int caseID = (int)request.getAttribute("caseID");
           
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
    <center>
        <h2>제품 수정 페이지 입니다.</h2>
    </center>
    
            <%if ((status != null) && !status.isSuccessful()) {%>
        <font color="red">There were problems processing your request:
        <ul><%Iterator errors = status.getExceptions();
            while (errors.hasNext()) {
                Exception ex = (Exception) errors.next();%>
            <li><%= ex.getMessage()%><%}%></ul></font><%}%>
        <center>
        <h1>케이스 상세 페이지 작성</h1>
        
        <form action="updateprocess" method="post">
            <table width="1100" height="300">
                <hr size="1" width="1100">
                <tr><td width="900"><br>
                        케이스 번호:</td><td>
                    <%=caseID%></tr>
                <tr><td width="900">케이스 타입:</td><td>
                        <select name="caseType" >
                                <option name="caseType" value="<%=request.getAttribute("caseType")%>"><%=request.getAttribute("caseType")%>
                                <option name="caseType" value="젤리">젤리
                                <option name="caseType" value="하드">하드
                                <option name="caseType" value="범퍼">범퍼</select>
                        
                <tr><td width="900">케이스 이름:</td><td>
                        <textarea name="caseName" size="20"><%=request.getAttribute("caseName")%></textarea>
                       
                <tr><td width="900">설명:</td><td>
                        <textarea name = "explanation" size="50"><%= request.getAttribute("explanation")%></textarea>
                        
                <tr><td width="900">가격:</td><td>
                        <textarea name="price" size="5"><%=request.getAttribute("price")%></textarea>
                        <hr size="1">
            </table>
            <hr size="1" width="1100">
            <input type="hidden" name="caseID" value="<%=caseID%>">
            <input type="submit" value="Submit">
        </form>
        
        
         <div id="gotop">
        <a href="#top"><img src="image\up.jpg" height="35" width="50"></a><br>
        <img src="image\cursor1.jpg" height="50" width="50"> <br>
        <a href="#bottom"> <img src="image\down.jpg" height="35" width="50"> </a> 
    </div>

    <script type="text/javascript">initMoving(document.getElementById("gotop"), 50, 50, 50);</script> 

    <a href="#top" name="bottom"><img src="image\totop.jpg" align="right"></a>
    </body>
</html>