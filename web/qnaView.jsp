<%-- 
    Document   : qnaView
    Created on : 2017. 11. 25, ���� 1:36:13
    Author     : user
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="domain.User"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="domain.Qna"%>
<%@page import="java.util.Iterator" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr"%>
<jsp:useBean id="status" scope="request" class="util.Status"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Qna</title>
        <% Qna qna = (Qna) request.getAttribute("qna");%>
        <%User user = (User) request.getAttribute("user");%>
        <%session.setAttribute("user", user);%>
        <%session.setAttribute("qna", qna);%>
    </head>
    <table border="0px">
        <tr>
            <%
                if (user == null) { %>
            <td><img src="image\login.jpg" onClick="location.assign('login.jsp')"></td>
            <td><a OnClick="alert('�α����� ���ּ���!')" style="cursor:pointer">
                    <img src="image\cart.jpg"></a>
            </td>
            <td><a OnClick="alert('�α����� ���ּ���!')" style="cursor:pointer">
                    <img src="image\order.jpg"></a>
            </td>
            <td><a OnClick="alert('�α����� ���ּ���!')" style="cursor:pointer">
                    &nbsp;
                    <input type="image" src="image\myPageUp_1.jpg" name="Submit" value ="MY PAGE"></a>
            </td>
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
            <%  }%>
            <td><form action="IDCheck" method="post">
                    <input type="image" src="image\join.jpg" name="Submit" value ="ȸ������">
                </form>    
            </td>

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

    <form action ="search" method="post">
        <img src="image\search.png" height="17" width="17">
        <input type="text" size="16" name="caseName">
        <input type="submit" value="�˻�">
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

    <%if ((status != null) && !status.isSuccessful()) {%>
    <font color="red">There were problems processing your request:
    <ul><%Iterator errors = status.getExceptions();
        while (errors.hasNext()) {
            Exception ex = (Exception) errors.next();%>
        <li><%= ex.getMessage()%><%}%></ul></font>    
        <%}%>
    <center></br></br><img src="image\qnawrite.jpg"><br></center>
    <center>
        <table>
            <tr>
                <td>
            <tr height="1" bgcolor="#ECBFD8"><td colspan="4"></td></tr>
            <tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
            <tr>
                <td>&nbsp;</td>
                <th width="120" height="35">����</th>
                <td align="center"><%=qna.getQnaTitle()%></td>
                <td>&nbsp;</td>
            </tr>
            <tr height="1" bgcolor="#dddddd"><td colspan="3"></td></tr>
            <tr>
                <td>&nbsp;</td>
                <th width="120" height="35">�ۼ���</th>
                <td align="center"><%=qna.getUserName()%></td>
                <td>&nbsp;</td>
            </tr>
            <tr height="1" bgcolor="#dddddd"><td colspan="3"></td></tr>
            <tr>
                <td>&nbsp;</td>
                <th width="60" height="35">��й�ȣ</th>
                <td align="center"><%=qna.getPassWord()%></td>
                <td>&nbsp;</td>
            </tr>
            <tr height="1" bgcolor="#dddddd"><td colspan="3"></td></tr>
            <tr>
                <td>&nbsp;</td>
                <th width="60" height="35">����</th>
                <td align="center"><%=qna.getQnaContent()%></td>
                <td>&nbsp;</td>
            </tr>
            <tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
            <tr height="1" bgcolor="#ECBFD8"><td colspan="4"></td></tr>
            <tr align="center">
                <td>&nbsp;</td><br>
            <td>&nbsp;</td>
            </tr>      
    </center>
</table>
<form action="updateQna"  method="post">
    <input type="hidden" name ="qnaNum" value="<%=qna.getQnaNum()%>">
    <input type="hidden" name ="qnaTitle" value="<%=qna.getQnaTitle()%>">
    <input type="hidden" name ="userName" value="<%=qna.getUserName()%>">
    <input type="hidden" name ="password" value="<%=qna.getPassWord()%>">
    <input type="hidden" name ="qnaContent" value="<%=qna.getQnaContent()%>">
    <input type="submit" value="�����ϱ�">
</form>
</center>
</body>
</html>