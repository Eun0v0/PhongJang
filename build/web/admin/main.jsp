<%-- 
    Document   : main
    Created on : 2017. 11. 3, ?? 12:35:30
    Author     : yukih
    modify     : ha0
--%>
<%@page import="java.net.URLEncoder"%>
<%@page import="domain.PhoneCaseService"%>
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
        <title>����-������ �� ����</title>
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
                        <input type="submit" value="��ǰ �߰�">
                    </a></td>
                <td><a OnClick="alert('�α����� ���ּ���!')" style="cursor:pointer">
                        <img src="image\order.jpg"></a>
                </td>

                <% } else {
                    session.setAttribute("user", user); %>
                <td><form action="logout" method="post">
                        <input type="image" src="image\logout.jpg" name="Submit" value ="�α׾ƿ�">
                    </form> 
                </td>
                <td><form action="create" method="post">
                        <input type="submit" value="��ǰ �߰�">
                    </form>
                </td>

                <td><form action="paymentlist" method="post">
                        <input type="image" src="image\order.jpg" name="Submit" value="��� ��������">
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
        <input type="submit" value="�˻�">
    </form>

    <hr size="5" color="black">
    <center>
        <table>
            <tr>
                <td><a href="Top-main.jsp"><img src="image\customCase3.jpg" height="35" width="140"></a></td>
                <td><img src="image\space.jpg" height="35" width="80"></td>
                
                <td><form action ="caseTypePage" method="post">
                        <input type="image" src="image\bumperCase2.jpg" name="Submit" height="35" width="140">
                        <input type="hidden" name="caseType" value="����">
                    </form></td>
                <td><img src="image\space.jpg" height="35" width="80"></td>
                
                <td><form action ="caseTypePage" method="post">
                        <input type="image" src="image\hardCase.jpg" name="Submit" height="35" width="140">
                        <input type="hidden" name="caseType" value="�ϵ�">
                    </form></td>
                <td><img src="image\space.jpg" height="35" width="80"></td>
                
                <td><form action ="caseTypePage" method="post">
                        <input type="image" src="image\jellyCase.jpg" name="Submit" height="35" width="140">
                        <input type="hidden" name="caseType" value="����">
                    </form></td>
                <td><img src="image\space.jpg" height="35" width="80"></td>
                
                <td><a href="event.jsp"><img src="image\event_.jpg" height="35" width="140"></a></td> 
            </tr>
        </table>
    </center>
    <hr size="5" color="black">

    <br><br>
    <font size="5"><center><b>&nbsp;&nbsp;BEST ITEMS<sup><font size="1" color="red">HIT!</font></sup></b></font>
        <hr width="13%" size="2" color="gray"></center><br>

    <table align="center" width ="1000" height="400" cellpadding="15">
        <tr>
            <%
                PhoneCaseService phoneCaseService = new PhoneCaseService();
                ArrayList<PhoneCase> phoneCases = phoneCaseService.getAllPhoneCase();;
                session.setAttribute("phoneCases", phoneCases);
                for (int i = 0; i < phoneCases.size(); i++) {
                    PhoneCase phoneCase = phoneCases.get(i);
                    int caseID = phoneCase.getCaseID();
                    String caseType = phoneCase.getCaseType();
                    String caseName = phoneCase.getCaseName();
                    String explanation = phoneCase.getExplanation();
                    int price = phoneCase.getPrice();
                    String imgPath = phoneCase.getImg();

                    String pcaseType = URLEncoder.encode(caseType);
                    String pcaseName = URLEncoder.encode(caseName);
                    String pexplanation = URLEncoder.encode(explanation);
            %>
            <td width="25%">
                <a href="update?caseID=<%=caseID%>"><img src = "image/upload/<%=imgPath%>" height="240" width="280" alt="<%=caseName%>" title="<%=caseName%>"/><br><br><%=caseName%>(<%=caseType%>)</a>
                <br><hr size="1" color="black">
                <img src = "image\ic_best.png"><br>
                <font size="4"><b><%=price%></b></font>
            </td>
            <% }%>
        </tr>
    </table>
    <br><br>
    <hr size="2" color="gray"><br><br>
    <font size="5"><center><b>NEW GOODS</b></font>
        <hr width="13%" size="2" color="gray"></center><br>

    <table align="center" width ="1000" height="600" cellpadding="15">
        <tr>
            <td width="25%">
                <a href="Top-2.jsp"><img src = "image\TOP2.gif"  alt="������ üũ����" title="������ üũ����"><br><br>������ üũ���� | ��� ��ġ��</a>
                <br><hr size="1" color="black">
                <img src = "image\ic_best.png"> <img src = "image\ic_new.gif"> <img src = "image\ic_sale.gif"><br>
                <font size="4"><b><s>16,000��</s>  �� 12,000��</b></font>
            </td>
            <td width="25%">
                <a href="Top-3.jsp"><img src = "image\TOP3.gif"  alt="������ ����Ƽ" title="������ ����Ƽ"><br><br>������ ����Ƽ | ������ ������</a>
                <br><hr size="1" color="black">
                <img src = "image\ic_best.png"> <img src = "image\ic_new.gif">  <img src = "image\ic_66size.gif"><br>
                <font size="4"><b>17,000��</b></font>
            </td>
            <td width="25%">
                <a href="Top-4.jsp"><img src = "image\TOP4.gif"  alt="���η��� �ĵ�" title="���η��� �ĵ�"><br><br>���η��� �ĵ�(���)</a>
                <br><hr size="1" color="black">
                <img src = "image\ic_new.gif"> <img src = "image\ic_today1.gif"> <img src = "image\ic_66size.gif"><br>
                <font size="4"><b>12,500��</b></font>
            </td>
            <td width="25%">
                <a href="Bottom-2.jsp"><img src = "image\BOTTOM2.gif"  alt="�ܿ� Ʈ���̴�����" title="�ܿ� Ʈ���̴�����"><br><br>(����)�ܿ� Ʈ���̴����� | �ݹ��� �Ѿ� ���� �򸮴�</a>
                <br><hr size="1" color="black">
                <img src = "image\ic_new.gif"> <img src = "image\ic_66size.gif"> <img src = "image\ic_sale.gif"><br>
                <font size="4"><b><s>7,000��</s> -> 5,000��</b></font>
            </td>
        </tr>
        <tr>
            <td width="25%">
                <a href="Bottom-3.jsp"><img src = "image\BOTTOM3.gif"  alt="��� ���Խ�ĿƮ" title="��� ���Խ�ĿƮ"><br><br>��� ���Խ�ĿƮ | ġ�� û��ĿƮ</a>
                <br><hr size="1" color="black">
                <img src = "image\ic_new.gif"><br>
                <font size="4"><b>11,900��</b></font>
            </td>
            <td width="25%">
                <a href="Bottom-6.jsp"><img src = "image\BOTTOM6.gif"  alt="�¸�� Ʈ���̴�����" title="�¸�� Ʈ���̴�����"><br><br>(���)�¸�� Ʈ���̴����� | �򸮴� �������� Ȩ����
                    <br><hr size="1" color="black">
                    <img src="image\ic_new.gif"> <img src="image\ic_66size.gif"> <img src="image\ic_sale.gif"><br>
                    <font size="4"><b>10,500��</b></font>
            </td>
            <td width="25%">
                <a href="Top-7.jsp"><img src = "image\OUT7.gif"  alt="���� ��Ʈ" title="���� ��Ʈ"><br><br>(����)���� ��Ʈ | �������� ������Ʈ �ƿ���
                    <br><hr size="1" color="black">
                    <img src = "image\ic_new.gif"> <img src = "image\ic_66size.gif"><br>
                    <font size="4"><b>42,900��</b></font>
            </td>
            <td width="25%">
                <a href="Top-1.html"><img src = "image\SHO1.jpg"  alt="���̷��� ����" title="���̷��� ����"><br><br>���̷��� ���� | ��Ʈ����</a>
                <br><hr size="1" color="black">
                <img src = "image\ic_new.gif"><br>
                <font size="4"><b>19,500��</b></font>
            </td>
        </tr>
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