<%-- 
    Document   : qna
    Created on : 2017. 11. 17, ���� 2:03:20
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
                <%  User user = (User) request.getAttribute("user");
                    if (user == null) {
                        session.setAttribute("user", user); %>
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
                <td><form action="IDCheck" method="post">
                        <input type="image" src="image\join.jpg" name="Submit" value ="ȸ������">
                    </form>    
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
        <input type="submit" value="�˻�">
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
                <td><a OnClick="alert('�α����� ���ּ���!')" style="cursor:pointer">
                        <input type="image" src="image\customCase3.jpg" name="Submit" height="35" width="140"></a></td>
                <% } %>        
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
                        <th width="120" height="35">����</th>
                        <td><textarea name="title" size="20"><%=title%></textarea></td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr height="1" bgcolor="#dddddd"><td colspan="3"></td></tr>
                    <tr>
                        <td>&nbsp;</td>
                        <th width="60" height="35">���̽� Ÿ��</th>
                        <td><select name="caseType" >
                                <option name="caseType" value="<%=caseType%>"><%=caseType%>
                                <option name="caseType" value="����">����
                                <option name="caseType" value="�ϵ�">�ϵ�
                                <option name="caseType" value="����">����</select></td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr height="1" bgcolor="#dddddd"><td colspan="3"></td></tr>
                    <tr>
                        <td>&nbsp;</td>
                        <th width="60" height="35">�ڵ��� ����</th>
                        <td><textarea name="phoneType" size="20"><%=phoneType%></textarea></td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr height="1" bgcolor="#dddddd"><td colspan="3"></td></tr>
                    <tr>
                        <td>&nbsp;</td>
                        <th width="60" height="35">����</th>
                        <td><select name="color" >
                                <option name="color" value="<%=color%>"><%=color%>
                                <option name="color" value="ȭ��Ʈ">ȭ��Ʈ
                                <option name="color" value="���Ϸ�����">���Ϸ�����
                                <option name="color" value="ü������">ü������
                                <option name="color" value="������">������
                                <option name="color" value="������">������
                                <option name="color" value="���ο�">���ο�
                                <option name="color" value="�׷���">�׷���
                                <option name="color" value="���󿻷ο�">���󿻷ο�
                                <option name="color" value="����ũ�������">����ũ�������
                                <option name="color" value="�׸�">�׸�
                                <option name="color" value="ĵ����ũ">ĵ����ũ
                                <option name="color" value="���ǽ����">���ǽ����
                                <option name="color" value="��ġ">��ġ
                                <option name="color" value="����">����
                                <option name="color" value="��ũ">��ũ
                                <option name="color" value="���׸�">���׸�
                                <option name="color" value="���">���
                                <option name="color" value="����Ʈ��Ʈ">����Ʈ��Ʈ
                                <option name="color" value="���̺�">���̺�
                                <option name="color" value="��">��
                            </select></td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr height="1" bgcolor="#dddddd"><td colspan="3"></td></tr>
                    <tr>
                        <td>&nbsp;</td>
                        <th width="60" height="35">���̽� �̹���</th>
                        <td><input type="file" name="caseImage" size="48" maxlength="50"><%=image%></td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr height="1" bgcolor="#dddddd"><td colspan="3"></td></tr>
                    <tr>
                        <td>&nbsp;</td>
                        <th width="60" height="35">�ΰ� ����</th>
                        <td><textarea name="content" cols="50" rows="13"><%=content%></textarea></td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
                    <tr height="1" bgcolor="#ECBFD8"><td colspan="4"></td></tr>
                    <tr align="center">
                        <td>&nbsp;</td><br>
                    <td colspan="2">
                        <input type="hidden" name="userID" value="<%=user.getId()%>">
                        <input type="hidden" name="myCaseNum" value="<%=myCaseNum%>">
                        
                        <input type="submit" value="����">
                    <td>&nbsp;</td>
                    </tr>      
                </center>
            </table>
        </form>
    </center>
    <center>
        <hr size="2" color="black">
        <br><br>
        
        <table>
            <tr><h2>�ֹ� ������</h2><tr>
            <tr>
                <th width="400" height = "35">���¹�ȣ</th>
                <th width="120" height = "35">���� �Ⱓ</th>
                <th width="120" height = "35">���</th>
                <th width="120" height = "35">����</th>
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
</body>
</html>
