<%-- 
    Document   : cart.jsp
    Created on : 2017. 11. 9, 오후 9:34:45
    Author     : yukih
--%>
<%@page import="domain.Qna"%>
<%-- test --%>
<%@page import="java.util.ArrayList"%>
<%@page import="domain.Cart"%>
<%@page import="domain.User"%>
<%@page import="java.util.Iterator" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr"%>
<jsp:useBean id="status" scope="request" class="util.Status"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>내 정보</title>
        <%User user = (User) request.getAttribute("user");
            Qna qna = (Qna) request.getAttribute("qna");
            session.setAttribute("user", user);%>
    </head>
    <body>
         <table border="0px">
            <tr>
                <% if (user == null) {
                        session.setAttribute("user", user); %>
                <td><img src="image\login.jpg" onClick="location.assign('login.jsp')"></td>
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
                <% } else {
                    session.setAttribute("user", user);%>
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
                        &nbsp;
                        <input type="image" src="image\myPageUp_1.jpg" name="Submit" value ="MY PAGE">
                    </form>    
                </td>

                <%  }%>
                <td><form action="IDCheck" method="post">
                        <input type="image" src="image\join.jpg" name="Submit" value ="회원가입">
                    </form>    
                </td>

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
    <center> <div align="middle"> <img src="image\banner2.jpg" onClick="location.assign('main.jsp')"> </div> </center>
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
                <% if (user != null) {%>
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

    <center></br></br><img src="image\qnawrite.jpg"><br></center>
    <center>
        <br><br>
        <%if ((status != null) && !status.isSuccessful()) {%>
        <font color="red">오류 발생!!!:
        <ul><%Iterator errors = status.getExceptions();
            while (errors.hasNext()) {
                Exception ex = (Exception) errors.next();%>
            <li><%= ex.getMessage()%><%}%></ul></font>    
            <%}%>
    </center>
    
    <center>
        <form action="updateQnaProcess" method="post">
            <table>
                <tr>
                    <td>
                <tr height="1" bgcolor="#ECBFD8"><td colspan="4"></td></tr>
                <tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
                <tr>
                    <td>&nbsp;</td>
                    <th width="120" height="35">제목</th>
                    <td><textarea name ="qnaTitle" size="48" maxlength="100"><%=qna.getQnaTitle()%></textarea></td>
                    <td>&nbsp;</td>
                </tr>
                <tr height="1" bgcolor="#dddddd"><td colspan="3"></td></tr>
                <tr>
                    <td>&nbsp;</td>
                    <th width="120" height="35">작성자</th>
                    <td><%=qna.getUserName()%></td>
                    <td>&nbsp;</td>
                </tr>
                <tr height="1" bgcolor="#dddddd"><td colspan="3"></td></tr>
                <tr>
                    <td>&nbsp;</td>
                    <th width="60" height="35">내용</th>
                    <td><textarea name="qnaContent" cols="50" rows="13"><%=qna.getQnaContent()%></textarea></td>
                    <td>&nbsp;</td>
                </tr>
                <tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
                <tr height="1" bgcolor="#ECBFD8"><td colspan="4"></td></tr>
                <tr height="1" bgcolor="#dddddd"><td colspan="3"></td></tr>
                <tr>
                    <td>&nbsp;</td>
                    <th width="60" height="35">비밀번호</th>
                    <td><input type=password name="passWord" size="48" maxlength="50"></td>
                    <td>&nbsp;</td>
                </tr>
                <tr align="center">
                    <td>&nbsp;</td><br>
                <td colspan="2">
                    <input type="submit" value="수정">
                <td>&nbsp;</td>
                </tr> 
            </table>
        </form>
    </center>
</body>
</html>
