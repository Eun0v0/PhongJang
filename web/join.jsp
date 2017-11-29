<%-- 
    Document   : join
    Created on : 2017. 11. 4, ?? 6:34:30
    Author     : yukih
--%>
<%@page import="domain.UserService"%>
<%-- test --%>
<%@page import="domain.User"%>
<%@page import="java.util.ArrayList"%>
<%@page session="false" import="java.util.Iterator" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr"%>
<jsp:useBean id="status" scope="request" class="util.Status"/>
<html>
    <head><title>회원가입</title>
        <% ArrayList<User> users = (ArrayList<User>) request.getAttribute("users");
           UserService userService = new UserService();
             
        %>
        <script>
            function ResetForm(){
                document.frm.reset();
            }
        </script>
           
    </head>
    <body>

        <table>
            <%  String name = "";
                if (name == null || name.equals("")) { %>
            <td><img src="image\login.jpg" onClick="location.assign('login.jsp')"></td>
                <% } else { %>
            <td><img src="image\logout.jpg" onClick="location.assign('logout.jsp')"></td>
                <%  }%>
            <td><a OnClick="alert('로그인을 해주세요!')" style="cursor:pointer">
                    <img src="image\cart.jpg"></a>
            </td>

            <td><a OnClick="alert('로그인을 해주세요!')" style="cursor:pointer">
                    <img src="image\order.jpg"></a>
            </td>
            <td><a OnClick="alert('로그인을 해주세요!')" style="cursor:pointer">
                    &nbsp;
                    <input type="image" src="image\myPageUp_1.jpg" name="Submit" value ="MY PAGE"></a>
            </td>
            <td><a href="join.jsp"><img src="image\join.jpg"></a></td>
            <td><form action="qnaList" methoe="post">
                        <input type="image" src="image\q&a.jpg" name="Submit" value="Q&A">
                    </form>
                </td>
        </table>

    <center> <div align="middle"> <img src="image\banner2.jpg" onClick="location.assign('main.jsp')"> </div> </center>
    <form action ="search" method="post">
        <img src="image\search.png" height="17" width="17">
        <input type="text" size="16" name="caseName">
        <input type="submit" value="검색">
    </form>

    <hr size="5" color="black">
    <center>
        <table>
            <tr>
                <% User user = (User) request.getAttribute("user");
                    if (user != null) {%>
                <td><form action="myCase" method="post">
                        <input type="image" src="image\customCase3.jpg" name="Submit" height="35" width="140">
                    </form></td>
                    <% } else {%>
                <td><a OnClick="alert('로그인을 해주세요!')" style="cursor:pointer">
                        <input type="image" src="image\customCase3.jpg" name="Submit" height="35" width="140"></a></td>
                        <% } %>        
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
        <br><br><img src="image\joinTitle.jpg" height="60" width="150"><br><br>
        <%if ((status != null) && !status.isSuccessful()) {%>
        <font color="red">오류 발생!!!:
        <ul><%Iterator errors = status.getExceptions();
            while (errors.hasNext()) {
                Exception ex = (Exception) errors.next();%>
            <li><%= ex.getMessage()%><%}%></ul></font>    
            <%}%>
    </center>
    <form action="join" method="post" name="join">
        <center> <br>
            
            <table>
                <tr>
                    <td><img src="image\id.JPG" width=150 height=35"></td>
                    <td><input type="text" name="userID" size="24"></td>
                        <%--<td><form action="idOverlapCheck" method="post">
                                <input type="text" name="userID" size="24">
                                <input type="button" name ="confirm_id" value="중복 체크">
                            </form></td>--%>
                    </td></tr>
                <tr>
                    <td><img src="image\password.JPG" width=150 height=35"></td>
                    <td><input type="password" name="password" size="24"></td></tr>
                <tr>
                    <td><img src="image\name.jpg" width=150 height=35"></td>
                    <td><input type="text" name="userName" size="24"></td></tr>
                <tr>
                    <td><img src="image\phone.jpg" width=150 height=35"></td>
                    <td><input type="text" name="phoneNumber" size="24"></td></tr>
                <tr>
                    <td><img src="image\address.jpg" width=150 height=35"></td>
                    <td><input type="text" name="address" size="50"></td></tr>
                <tr><td><img src="image\white.jpg" height = 35></td></tr>
            </table>
            <input type="image" src="image\joinbutton.jpg" name="Submit">
            
            <input type="image" src="image\clearbutton.jpg" onClick ="join.reset();return false;" aline="absmiddle">
        </center>
    </form>

</body>
</html>