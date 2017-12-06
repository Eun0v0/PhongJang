<%-- 
    Document   : update
    Created on : 2017. 11. 12, 오후 8:13:24
    Author     : yukih
--%>
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

        <title><%=request.getAttribute("caseName")%> 수정 페이지</title>
        <%  ArrayList<PhoneCase> phoneCases = (ArrayList<PhoneCase>) request.getAttribute("phoneCases");

            User user = (User) request.getAttribute("user");
            int caseID = (int) request.getAttribute("caseID");
            ArrayList<PhoneType> phoneTypes = (ArrayList<PhoneType>) request.getAttribute("phoneTypes");
            PhoneType v_phoneType;
            ArrayList<CaseColor> caseColors = (ArrayList<CaseColor>) request.getAttribute("caseColors");
            CaseColor v_caseColor;
            String caseName = (String) request.getAttribute("caseName");

            ArrayList<Review> reviews = (ArrayList<Review>) request.getAttribute("reviews");

            session.setAttribute("user", user);
            session.setAttribute("phoneCases", phoneCases);
            session.setAttribute("phoneTypes", phoneTypes);
            session.setAttribute("caseColors", caseColors);
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
                        <input type="image" src="image\adminAdd2.jpg" name="Submit" value ="로그아웃">
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
                        <input type="image" src="image\adminAdd2.jpg" name="Submit" value ="로그아웃">
                    </form>
                </td>
                <td><form action="manageStock" method="post">
                        <input type="image" src="image\inventory.jpg" name="Submit" value ="로그아웃">
                    </form>
                </td>
                <td><form action="paymentlist" method="post">
                        <input type="image" src="image\order.jpg" name="Submit" value="모든 결제내역">
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
    <center> <div align="middle"> <img src="image\banner2.jpg" onClick="location.assign('admin/main.jsp')"> </div> </center>
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
                
                <td><form action="myCaseList" method="post">
                        <input type="hidden" name="userID" value="<%=user.getId()%>">
                        <input type="image" src="image\customCase3.jpg" height="35" width="140">
                        &nbsp;&nbsp;&nbsp;
                    </form></td>
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
    <center>
        <table width="1100" height="100">
            <tr>
                <td width="900"><div align="center"><h2><%=caseName%></h2></div> 
                    <div align="right"><form action="deleteCase" method="post">
                            <input type="hidden" name="caseID" value="<%=caseID%>">
                            <input type="hidden" name="caseName" value="<%=caseName%>">

                            <input type="image" src="image/trash.JPG" value="삭제" width="30" height="40">
                        </form></div>
                </td>
            </tr>
        </table>
    </center>

    <%if ((status != null) && !status.isSuccessful()) {%>
    <font color="red">There were problems processing your request:
    <ul><%Iterator errors = status.getExceptions();
        while (errors.hasNext()) {
            Exception ex = (Exception) errors.next();%>
        <li><%= ex.getMessage()%><%}%></ul></font><%}%>
    <center>
        <form action="updateprocess" method="post" enctype="multipart/form-data">
            <table width="1100" height="200">
                <tr>
                    <td><img src="image/upload/<%=request.getAttribute("img")%>" width="400" height="360"></td>
                    <td width="900">
                        <div align="left"><font size="2">케이스 번호:</font></div>
                        <div align="right"><input type="hidden" name="caseID" value="<%=caseID%>"><%=caseID%></div>
                        <div align="left"><font size="2">케이스 타입:</font></div>
                        <div align="right"><select name="caseType" >
                                <option name="caseType" value="<%=request.getAttribute("caseType")%>"><%=request.getAttribute("caseType")%>
                                <option name="caseType" value="젤리">젤리
                                <option name="caseType" value="하드">하드
                                <option name="caseType" value="범퍼">범퍼</select></div>

                        <div align="left"><font size="2">케이스 이름:</font></div>
                        <div align="right"><textarea name="caseName" cols="20" rows="3"><%=request.getAttribute("caseName")%></textarea></div>

                        <div align="left"><font size="2">설명:</font></div>
                        <div align="right"><textarea name = "explanation" cols="20" rows="5"><%= request.getAttribute("explanation")%></textarea></div>

                        <div align="left"><font size="2">가격:</font></div>
                        <div align="right"><textarea name="price" cols="20" rows="3"><%=request.getAttribute("price")%></textarea></div>
                        <div align="right"><select name="phoneType" >
                                <option name="phoneType" value="unknown">-----
                                    <%for (int i = 0; i < phoneTypes.size(); i++) {
                                        v_phoneType = phoneTypes.get(i);
                                        String phoneType = v_phoneType.getPhoneType();%>
                                <option name="phoneType" value="<%=phoneType%>"><%=phoneType%>
                                    <% }%>
                            </select></div>
                        <div align="right"><select name="caseColor" >
                                <option name="caseColor" value="unknown">-----
                                    <%for (int i = 0; i < caseColors.size(); i++) {
                                        v_caseColor = caseColors.get(i);
                                        String caseColor = v_caseColor.getCaseColor();%>
                                <option name="caseColor" value="<%=caseColor%>"><%=caseColor%>
                                    <% }%>
                            </select></div>
                        <div align="left"><font size="2">상품 메인 이미지:</font></div>
                        <div align="right"><input type="file" name="img"> <%=request.getAttribute("img")%></div>
                        <div align="left"><font size="2">상품 상세 이미지:</font></div>
                        <div align="right"><input type="file" name="detailImg"> <%=request.getAttribute("detailImg")%></div>        
                        <hr size="1">
                <br><center>
                    <input type="hidden" name="caseID" value="<%=caseID%>">
                    <input type="image" src="image/update.jpg" value="수정하기">
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
        <table>
            <td><img src="image/upload/<%=request.getAttribute("detailImg")%>"></td>
        </table>
    </center>
    <center>
        <hr size="2" color="black">
        <br><br>

        <table>
            <tr><h2>한줄 리뷰★</h2><tr>
            <tr>
                <th width="170" height = "35">별점</th>
                <th width="120" height = "35">리뷰</th>
                <th width="120" height = "35">ID</th>
            </tr>
            <%for (int i = 0; i < reviews.size(); i++) {
                    Review v_review = reviews.get(i);
                    String grade = v_review.getGrade();
                    String content = v_review.getContent();
                    String writeDate = v_review.getWriteDate();
                    String w_userID = v_review.getUserID();
            %>
            <tr>
                <td bgcolor="#dcdcdc" align="center"><%=grade%> <br> <%=writeDate%></td>
                <td bgcolor="#dcdcdc" align="center"><%=content%></td>
                <td bgcolor="#dcdcdc" align="center"><%=w_userID%></td>
                <td bgcolor="#dcdcdc" align ="center">

                    <% if (w_userID.equals(user.getId())) {%>
                    <form action="deleteReview" method="post">
                        <input type="hidden" name="replyNum" value="<%=v_review.getReplyNum()%>">
                        <input type="hidden" name="userID" value="<%=user.getId()%>">
                        <input type="hidden" name="caseID" value="<%=request.getAttribute("caseID")%>">
                        <input type="image" src="image\delete.jpg" name="Submit" value ="삭제" aline="absmiddle">
                    </form></td>
                    <% } %> 
            </tr>
            <% } %>
        </table>
    </center> 
    <br><br><br>
    <% if (user != null) {%>
    <center>
        <hr size="2" color="black">
        <form action="wrtieReview" method="post">
            <table>
                <tr><h2>리뷰 작성★</h2><tr>
                <tr><td><textarea name="content" cols="100" rows="5"></textarea><td>
                    <td><select name="grade" >
                            <option name="grade" value="unknown">-----
                            <option name="grade" value="★">★
                            <option name="grade" value="★★">★★
                            <option name="grade" value="★★★">★★★
                            <option name="grade" value="★★★★">★★★★
                            <option name="grade" value="★★★★★">★★★★★
                        </select></td>
                <input type="hidden" name="userID" value="<%=user.getId()%>">
                <input type="hidden" name="caseID" value="<%=request.getAttribute("caseID")%>">
                <td><input type="submit" value="등록"></td>    
                </tr>
            </table>
        </form>
    </center>
    <br><br><br>
    <% }%>
    <div id="gotop">
        <a href="#top"><img src="image\up.jpg" height="35" width="50"></a><br>
        <img src="image\cursor1.jpg" height="50" width="50"> <br>
        <a href="#bottom"> <img src="image\down.jpg" height="35" width="50"> </a> 
    </div>

    <script type="text/javascript">initMoving(document.getElementById("gotop"), 50, 50, 50);</script> 

    <a href="#top" name="bottom"><img src="image\totop.jpg" align="right"></a>
</body>
</html>