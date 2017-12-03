<%-- 
    Document   : qnaView
    Created on : 2017. 11. 25, 오후 1:36:13
    Author     : user
--%>
<%@page import="domain.QnaReply"%>
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
        <%Qna qna = (Qna) request.getAttribute("qna");
            ArrayList<QnaReply> qnaReplys = (ArrayList<QnaReply>) request.getAttribute("qnaReplys");
            QnaReply qnaReply = null;
            User user = (User) request.getAttribute("user");
            session.setAttribute("user", user);
            session.setAttribute("qnaReplys", qnaReplys);

            session.setAttribute("qna", qna);%>

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
            <% }%>

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
                <th width="120" height="35">제목</th>
                <td align="center"><%=qna.getQnaTitle()%></td>
                <td>&nbsp;</td>
            </tr>
            <tr height="1" bgcolor="#dddddd"><td colspan="3"></td></tr>
            <tr>
                <td>&nbsp;</td>
                <th width="120" height="35">작성자</th>
                <td align="center"><%=qna.getUserName()%></td>
                <td>&nbsp;</td>
            </tr>
            <tr height="1" bgcolor="#dddddd"><td colspan="3"></td></tr>
            <tr>
                <td>&nbsp;</td>
                <th width="60" height="35">내용</th>
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
<center>
    <hr size="2" color="black">
    <br><br>

    <table>
        <tr><h2>댓글 내용</h2><tr>
        <tr>
            <th width="120" height = "35">ID</th>
            <th width="120" height = "35">작성일</th>
            <th width="400" height = "35">내용</th>
        </tr>
        <%  if (qnaReplys != null) {
                for (int i = 0; i < qnaReplys.size(); i++) {
                    qnaReply = qnaReplys.get(i);
                    String userID = qnaReply.getUserID();
                    String content = qnaReply.getContent();
                    String writeDate = qnaReply.getWriteDate();
        %>
        <tr>
            <td bgcolor="#dcdcdc" align="center"><%=userID%></td>
            <td bgcolor="#dcdcdc" align="center"><%=writeDate%></td>
            <td bgcolor="#dcdcdc" align="center"><%=content%></td>

            <%  if (user.getId().equals(qnaReply.getUserID())) {%>
            <td bgcolor="#dcdcdc" align="center">
                <form action="deleteQnaReply" method="post">
                    <input type="hidden" name = "userID" value="<%=qnaReply.getUserID()%>">
                    <input type="hidden" name = "qnaNum" value="<%=qna.getQnaNum()%>">
                    <input type="submit" value="삭제">
                </form>
            </td>
            <% }%>

        </tr>
        <% }
            }%>
    </table>
</center> 
<br><br><br>
<hr size="2" color="black">
<form action="qnaReply" method="post">
    <table>
        <tr><h2>댓글 작성</h2><tr>
        <tr>
            <td><textarea name="content" cols="100" rows="5"></textarea></td>
            <td><input type="hidden" name="userID" value="<%=user.getId()%>"></td>
            <td><input type="hidden" name="qnaNum" value="<%=qna.getQnaNum()%>"></td>
            <td><input type="submit" value="등록"></td>

        </tr>
    </table>
</form>

</center>
</body>
</html>
