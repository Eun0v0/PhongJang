<%-- 
    Document   : cart.jsp
    Created on : 2017. 11. 9, ���� 9:34:45
    Author     : yukih
--%>
<%-- test --%>
<%@page import="java.util.ArrayList"%>
<%@page import="domain.Cart"%>
<%@page import="domain.User"%>
<%@page import="java.util.Iterator" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>�� ����</title>
        <%User user = (User) request.getAttribute("user");%>
        <%session.setAttribute("user", user);%>
    </head>
    <body>
        <table border="0px">
            <tr>
                <%
                    if (user == null) { %>
                <td><img src="image\login.jpg" onClick="location.assign('login.jsp')"></td>
                <td><td><a href="cart.jsp"><img src="image\cart.jpg"></a></td>
                        <% } else {
                            session.setAttribute("user", user);%>
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
                <td><form action="myPage" method="post">
                    <input type="hidden" name="userID" value="<%=user.getId()%>">
                    &nbsp;
                    <input type="image" src="image\myPageUp_1.jpg" name="Submit" value ="MY PAGE">
                </form>    
                </td>
                  
            </td>
                    <%  }%>

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
        <input type="button" value="�˻�" onClick="check()">
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

    <br>
    <center> <img src="image\myInfoTitle.jpg" width=150 height=60"> </center>
    <center> <br>
    <!--<h2><%= user.getName()%> ������ ȸ�� ���� �Դϴ�.</h2>-->

        <table>
            
            <form action="updateMyInfo" method="post">
            <table>
                
                <tr><td><img src="image\name.jpg" width=120 height=35">&nbsp;</td><td>
                        <textarea name="userName" size="20"><%=request.getAttribute("userName")%></textarea>
                <tr><td><img src="image\id.JPG" width=120 height=35">&nbsp;</td><td>
                        <%=request.getAttribute("userID")%>
                <tr><td><img src="image\phone.jpg" width=120 height=35">&nbsp;</td><td>
                        <textarea name="phoneNumber" size="20"><%=request.getAttribute("phoneNumber")%></textarea>
                <tr><td><img src="image\address.jpg" width=120 height=35">&nbsp;</td><td>
                        <textarea name = "address" size="50"><%= request.getAttribute("address")%></textarea>
            </table>
            
            <table><tr>
                    <td><input type="image" src="image\modify.jpg" width="170" height="50" name="Submit" value ="�����ϱ�">&nbsp;</td>
        </form> 
            
        <form action="myPage" method="post">
            <input type="hidden" name="userID" value="<%=user.getId()%>">
            &nbsp;&nbsp;&nbsp;&nbsp;
            <td><input type="image" src="image\back.jpg" width="170" height="50" name="Submit" value ="MY PAGE"></td>
        </form> 
        </tr>
             </table>
    </center>
    </body>
</html>