<%-- 
    Document   : qna
    Created on : 2017. 11. 17, 오전 2:03:20
    Author     : user
--%>
<%@page import="domain.Event"%>
<%@page import="domain.MyCase"%>
<%-- test --%>
<%@page import="java.util.ArrayList"%>
<%@page import="domain.User"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="domain.Qna"%>
<%@page import="java.util.Iterator" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
        <title>나만의 케이스 문의 목록</title>
        <% ArrayList<Event> events = (ArrayList<Event>) request.getAttribute("events");
            User user = (User) request.getAttribute("user");
            session.setAttribute("user", user);
            session.setAttribute("events", events);%>
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



    <center></br></br><img src="image\qnalist.jpg"><br><br></center>
    <center><table>
            <tr>
                <th width="60" height="35"><img src="image\boardnum.jpg" width=60 height=40"></th>
                <th width="250" height="35"><img src="image\boardtitle.jpg" width=250 height=40"></th>
                <th width="140" height="35"><img src="image\writedate.jpg" width=140 height=40"></th>
                <th width="50" height="35">삭제</th>

            </tr>
            <% if (events != null) {
                    for (int i = 0; i < events.size(); i++) {
                        Event event = events.get(i);
                        int eventID = event.getEventID();
                        String title = event.getTitle();
                        String image = event.getImage();
                        String writeDate = event.getWriteDate();
                        String content = event.getContent();
            %>
            <tr>
                <td bgcolor="#dcdcdc" height="40" align="center"><%=eventID%></td>
                <td bgcolor="#dcdcdc" height="40" align="center"><a href="updateEvent?eventID=<%=eventID%>"><%=title%></a></td>
                <td bgcolor="#dcdcdc" height="40" align="center"><%=writeDate%></td>
                <td bgcolor="#dcdcdc" height="40" align="center">
                    <form action="deleteEvent" method="post">
                        <input type="submit" value="삭제">
                    </form>
                </td> 
            </tr>
            <% }
                }%>
        </table>
        <form action="createEvent" method="post">
            <input type="image" src="image\boardwrite.jpg" value ="글쓰기" aline="absmiddle">
        </form>
    </center>
</body>
</html>