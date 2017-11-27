
<%@page import="domain.PhoneCase"%>
<%@page import="java.util.ArrayList"%>
<%@page import="domain.PhoneCaseService"%>
<%@page import="java.util.Iterator" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr"%>
<%@page import="domain.User"%>
<jsp:useBean id="status" scope="request" class="util.Status"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>��ǰ �߰�</title>
        <%  User user = (User) request.getAttribute("user");
            session.setAttribute("user", user);
            PhoneCaseService phoneCaseService = new PhoneCaseService();
            ArrayList<PhoneCase> phoneCases = phoneCaseService.getAllPhoneCase();
            session.setAttribute("phoneCases", phoneCases);            
            %>
    
    </head>
    <body>
        <table border="0px">
            <tr>
                <%if (user == null) {
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

                <td><a href="event.jsp"><img src="image\event_.jpg" height="35" width="140"></a></td> 
            </tr>
        </table>
    </center>
    <hr size="5" color="black">
    <%--���⼭���� �ڵ峻��--%>

    <%if ((status != null) && !status.isSuccessful()) {%>
    <font color="red">There were problems processing your request:
    <ul><%Iterator errors = status.getExceptions();
        while (errors.hasNext()) {
            Exception ex = (Exception) errors.next();%>
        <li><%= ex.getMessage()%><%}%></ul></font>    
        <%}%>
        <center><h1><br>���� ���̽� �ֹ� ����<br></h1></center>
    <center>
        <form action="myCaseCreate" method="post" enctype="multipart/form-data"> 
            <table>
                <tr>
                <tr><img src="image/���� �̹���.jpg" width="500" height="500"></tr>
                <br><br> 
                <tr><font color="red">*�ֹ� Ȯ���� 3�� ���� �Ա����ּž� �մϴ�.<br>
                                      *�ֹ� Ȯ���� ������ ���� �� ȯ���� �Ұ��մϴ�.</font></tr>
                    <tr height="1" bgcolor="#ECBFD8"><td colspan="4"></td></tr>
                    <tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
                    <tr>
                        <td>&nbsp;</td>
                        <th width="120" height="35">����</th>
                        <td><input name="title" size="48" maxlength="100"></td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr height="1" bgcolor="#dddddd"><td colspan="3"></td></tr>
                    <tr>
                        <td>&nbsp;</td>
                        <th width="60" height="35">���̽� Ÿ��</th>
                        <td><select name="caseType" >
                                <option name="caseType" value="unknown">-----
                                <option name="caseType" value="����">����
                                <option name="caseType" value="�ϵ�">�ϵ�
                                <option name="caseType" value="����">����</select></td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr height="1" bgcolor="#dddddd"><td colspan="3"></td></tr>
                    <tr>
                        <td>&nbsp;</td>
                        <th width="60" height="35">�ڵ��� ����</th>
                        <td><input type="text" name="phoneType"></td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr height="1" bgcolor="#dddddd"><td colspan="3"></td></tr>
                    <tr>
                        <td>&nbsp;</td>
                        <th width="60" height="35">����</th>
                        <td><select name="color" >
                                <option name="color" value="unknown">-----
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
                        <td><input type="file" name="caseImage" size="48" maxlength="50"></td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr height="1" bgcolor="#dddddd"><td colspan="3"></td></tr>
                    <tr>
                        <td>&nbsp;</td>
                        <th width="60" height="35">�ΰ� ����</th>
                        <td><textarea name="content" cols="50" rows="13"></textarea></td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
                    <tr height="1" bgcolor="#ECBFD8"><td colspan="4"></td></tr>
                    <tr align="center">
                        <td>&nbsp;</td><br>
                    <td colspan="2">
                        <input type="hidden" name="userID" value="<%=user.getId()%>">
                        <input type="submit" value="���">
                    <td>&nbsp;</td>
                    </tr>      
                </center></td></tr>
            </table>
        </form>
    </center>
</body>

</html>