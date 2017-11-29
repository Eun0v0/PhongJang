<%-- 
    Document   : qna
    Created on : 2017. 11. 17, 오전 2:03:20
    Author     : user
--%>
<%@page import="domain.ReplyMyCase"%>
<%@page import="domain.MyCase"%>
<%-- test --%>
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
        <meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
        <title>Q&A</title>
        <% ArrayList<MyCase> myCases = (ArrayList<MyCase>) request.getAttribute("myCases");
            User user = (User) request.getAttribute("user");
            MyCase myCase = (MyCase) request.getAttribute("myCase");
            ReplyMyCase replyMyCase = (ReplyMyCase) request.getAttribute("replyMyCase");
            
            session.setAttribute("user", user);
            session.setAttribute("myCases", myCases);
            session.setAttribute("myCase", myCase);
            session.setAttribute("replyMyCase", replyMyCase);
           
        %>
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
                        <input type="image" src="image\inventory.jpg" name="Submit" value ="로그아웃">
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

    <%if ((status != null) && !status.isSuccessful()) {%>
    <font color="red">There were problems processing your request:
    <ul><%Iterator errors = status.getExceptions();
        while (errors.hasNext()) {
            Exception ex = (Exception) errors.next();%>
        <li><%= ex.getMessage()%><%}%></ul></font>    
        <%}%>
    <center></br></br><img src="image\qnalist.jpg"><br><br></center>
    <center>
        <%  int myCaseNum = myCase.getMyCaseNum();
            String title = myCase.getTitle();

            String caseType = myCase.getCaseType();
            String phoneType = myCase.getPhoneType();
            String color = myCase.getColor();
            String content = myCase.getContent();
            String image = myCase.getImage();
            String writeDate = myCase.getWriteDate();%>
        <center><img src="image/upload/<%=image%>" width="400" height="360"></center>
        <form action="modifyMyCaseProcess" method="post" enctype="multipart/form-data">
            <table>
                <tr>
                    <tr height="1" bgcolor="#ECBFD8"><td colspan="4"></td></tr>
                    <tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
                    <tr>
                        <td>&nbsp;</td>
                        <th width="120" height="35">제목</th>
                        <td><%=title%></td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr height="1" bgcolor="#dddddd"><td colspan="3"></td></tr>
                    <tr>
                        <td>&nbsp;</td>
                        <th width="60" height="35">케이스 타입</th>
                        <td><%=caseType%></td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr height="1" bgcolor="#dddddd"><td colspan="3"></td></tr>
                    <tr>
                        <td>&nbsp;</td>
                        <th width="60" height="35">핸드폰 기종</th>
                        <td><%=phoneType%></td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr height="1" bgcolor="#dddddd"><td colspan="3"></td></tr>
                    <tr>
                        <td>&nbsp;</td>
                        <th width="60" height="35">색상</th>
                        <td><%=color%></td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr height="1" bgcolor="#dddddd"><td colspan="3"></td></tr>
                   
                    <tr height="1" bgcolor="#dddddd"><td colspan="3"></td></tr>
                    <tr>
                        <td>&nbsp;</td>
                        <th width="60" height="35">부가 설명</th>
                        <td><%=content%></td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
                    <tr height="1" bgcolor="#ECBFD8"><td colspan="4"></td></tr>
                    <tr align="center">
                        <td>&nbsp;</td><br>
                    </tr>      
                </center></td></tr>
            </table>
        </form>
    </center>
    <center>
        <hr size="2" color="black">
        <br><br>
        
        <table>
            <tr><h2>주문 내역서</h2><tr>
            <tr>
                <th width="400" height = "35">계좌번호</th>
                <th width="120" height = "35">예금 기간</th>
                <th width="120" height = "35">비고</th>
                <th width="120" height = "35">상태</th>
            </tr>
            <%
                String account = replyMyCase.getAccount();
                String dueDate = replyMyCase.getDueDate();
                String v_content = replyMyCase.getContent();
                String v_status = replyMyCase.getStatus();
            %>
            <tr>
                <td bgcolor="#dcdcdc" align="center"><%=account%></td>
                <td bgcolor="#dcdcdc" align="center"><%=dueDate%></td>
                <td bgcolor="#dcdcdc" align="center"><%=v_content%></td>
                <td bgcolor="#dcdcdc" align="center"><%=v_status%></td>
            </tr>
        </table>
    </center> 
        <br><br><br>
    <% if(user != null) { %>
        <center>
            <hr size="2" color="black">
            <form action="replyMyCase" method="post" enctype="multipart/form-data">
                <table>
                    <tr><h2>마이 케이스 주문 내역서</h2><tr>
                    <tr><td><textarea name="content" cols="60" rows="5"></textarea><td>
                        <td> <input type="file" name="image"></td>
                        
                    <input type="hidden" name="userID" value="<%=user.getId()%>">
                    <input type="hidden" name="myCaseNum" value="<%=myCaseNum%>"></tr>
                    <tr><td>가격: <select name="price" >
                                <option name="price" value="unknown">-----
                                <option name="price" value="15000">젤리 15000원
                                <option name="price" value="17000">하드 17000원
                                <option name="price" value="20000">범퍼 20000원                               
                            </select></td>
                        <td><input type="submit" value="등록"></td></tr>
                </table>
            </form>
        </center>
        <br><br><br>
    <% } %>
</body>
</html>
