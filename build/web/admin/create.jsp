
<%@page import="java.util.Iterator" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr"%>
<%@page import="domain.User"%>
<jsp:useBean id="status" scope="request" class="util.Status"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>��ǰ �߰�</title>
        <%  User user = (User) request.getAttribute("user");
            session.setAttribute("user", user);%></head>
    <body>
        <table border="0px">
            <tr>
                <% if (user == null) { %>
                <td><img src="image\login.jpg" onClick="location.assign('login.jsp')"></td>
                <td><a OnClick="alert('�α����� ���ּ���!')" style="cursor:pointer">
                        <input type="image" src="image\adminAdd2.jpg" name="Submit" value ="�α׾ƿ�">
                    </a></td>
                <td><a OnClick="alert('�α����� ���ּ���!')" style="cursor:pointer">
                        <input type="image" src="image\inventory.jpg" name="Submit" value ="�α׾ƿ�">
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
                        <input type="image" src="image\adminAdd2.jpg" name="Submit" value ="�α׾ƿ�">
                    </form>
                </td>
                <td><form action="manageStock" method="post">
                        <input type="image" src="image\inventory.jpg" name="Submit" value ="�α׾ƿ�">
                    </form>
                </td>
                <td><form action="paymentlist" method="post">
                        <input type="image" src="image\order.jpg" name="Submit" value="��� ��������">
                    </form> 
                </td>

                <%  }%>

                <td><form action ="eventList" method="post">
                        <input type="image" src="image\event_.jpg" name="Submit" height="35" width="140">
                    </form></td> 
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
    <%--���⼭���� �ڵ峻��--%>

    <center> <h2></br>��ǰ �߰� ������ �Դϴ�.</h2> </center>
        <%if ((status != null) && !status.isSuccessful()) {%>
    <font color="red">There were problems processing your request:
    <ul><%Iterator errors = status.getExceptions();
        while (errors.hasNext()) {
            Exception ex = (Exception) errors.next();%>
        <li><%= ex.getMessage()%><%}%></ul></font><%}%>
    <form action="createprocess" name ="createprocess" method="post" enctype="multipart/form-data"> 
        <center>
            <table width="1100" height="300">
                <tr height="1" bgcolor="#ECBFD8"><td colspan="4"></td></tr>
                <tr>
                    <td width="900">
                        <hr size="1"><br>
                        <div align="left"><font size="2">���̽� �̸�</font></div>
                        <div align="right"><input type="text" name="caseName" size="40" padding="10px"></div>
                        <div align="left"><font size="2">���̽� Ÿ��</font></div>
                        <div align="right"><select name="caseType" >
                                <option name="caseType" value="unknown">-----
                                <option name="caseType" value="����">����
                                <option name="caseType" value="�ϵ�">�ϵ�
                                <option name="caseType" value="����">����</select></div>
                        <div align="left"><font size="2">����</font></div>
                        <div align="right"><input type="text" name="price" size="10" padding="10px">��</div>
                        <div align="left"><font size="2">����</font></div>
                        <div align="right"><textarea name="explanation" cols="65" rows="4"></textarea></div>
                        <div align="left"><font size="2">�ڵ��� ����</font></div>
                        <div align="right">
                            <input type="checkbox" name="phoneType" value="iphone 6/6s">iphone 6/6s
                            <input type="checkbox" name="phoneType" value="iphone 6+/6s+">iphone 6+/6s+
                            <input type="checkbox" name="phoneType" value="iphone7">iphone7
                            <input type="checkbox" name="phoneType" value="iphone7+">iphone7+
                            <input type="checkbox" name="phoneType" value="iphone8">iphone8
                            <input type="checkbox" name="phoneType" value="iphone8+">iphone8+
                        </div>
                        <div align="right">
                            <input type="checkbox" name="phoneType" value="GalaxyS7">GalaxyS7
                            <input type="checkbox" name="phoneType" value="GalaxyS7 Edge">GalaxyS7 Edge
                            <input type="checkbox" name="phoneType" value="GalaxyS8">GalaxyS8
                            <input type="checkbox" name="phoneType" value="Galaxy Note8">Galaxy Note8
                            <input type="checkbox" name="phoneType" value="GalaxyA7">GalaxyA7
                            <input type="checkbox" name="phoneType" value="GalaxyA8">GalaxyA8
                        </div>
                        <div align="right">
                            <input type="checkbox" name="phoneType" value="LG V20">LG V20
                            <input type="checkbox" name="phoneType" value="LG V30">LG V30
                            <input type="checkbox" name="phoneType" value="LG G5">LG G5
                            <input type="checkbox" name="phoneType" value="LG G6">LG G6
                        </div>
                        <div align="left"><font size="2">����(���̽� ����)</font></div>
                            <% for (int i = 0; i < 10; i++) {%>
                        <div align="right"><%=i + 1%>: <input type="text" name="color" size="10" padding="10px"></div>                        
                            <% }%>
                        <div align="left">��ǰ ���� �̹��� : </div>
                        <div align="right"><input type="file" name="img"><br> </div>
                        <div align="left">��ǰ �� �̹��� : </div>
                        <div align="right"><input type="file" name="detailImg"><br> </div>
                        <br>
                        <hr size="1">
                    </td>
                </tr>
                <tr height="1" bgcolor="#ECBFD8"><td colspan="4"></td></tr>
            </table>
            <table></br>
                <td><tr>
                <input type="image" src="image\adminAdd3.jpg" name="submit" value ="����ϱ�" aline="absmiddle">
                &nbsp;&nbsp;
                <input type="image" src="image\adminReset.jpg" name="reset" value ="�ٽþ���" aline="absmiddle" onclick="createprocess.reset()">
                &nbsp;&nbsp;</tr> </td>
            </table>
            <hr size="1" width="1100">
        </center>
    </form>
</body>

</html>