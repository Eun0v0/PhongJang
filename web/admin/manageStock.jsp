<%-- 
    Document   : login
    Created on : 2017. 11. 3, ?? 4:28:19
    Author     : yukih
--%>
<%@page import="domain.CaseColorService"%>
<%@page import="domain.CaseColor"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.io.File"%>
<%-- test --%>

<%@page import="domain.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="domain.PhoneCase"%>
<%@page import="java.util.Iterator" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
        <title>Product List</title>
        <% ArrayList<PhoneCase> phoneCases = (ArrayList<PhoneCase>) request.getAttribute("phoneCases");
        ArrayList<CaseColor> caseColors = new ArrayList<CaseColor>();
        CaseColorService caseColorService = new CaseColorService();
        CaseColor v_caseColor = null;
         User user = (User) request.getAttribute("user");
         session.setAttribute("user", user);
         session.setAttribute("phoneCases", phoneCases);%>

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
                <td><a href="Top-main.jsp"><img src="image\customCase3.jpg" height="35" width="140"></a></td>
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
        
    <center> <h2></br>재고 관리 페이지 입니다.</h2> 
        <hr width="28%" size="1" color="gray"><br></center>
    <center> 
        <form action ="manageSearch" method="post">
            <img src="image\search.png" height="17" width="17">
            <input type="text" size="16" name="caseName">
            <input type="submit" value="검색">
        </form>
        
        <table>
            <tr>
                <th width="200" height = "35"><img src="image\adminCasename2.jpg" width=200 height=40"></th>
                <th width="200" height = "35"><img src="image\stock.jpg" width=200 height=40"></th>
                <th width="60" height = "35"><img src="image\deletePink2.jpg" width=60 height=40"></th>
            </tr>
            <%
                for (int i = 0; i < phoneCases.size(); i++) {
                    PhoneCase phoneCase = phoneCases.get(i);
                    int stock = phoneCase.getStock();
                    int caseID = phoneCase.getCaseID();
                    String caseType = phoneCase.getCaseType();
                    String caseName = phoneCase.getCaseName();
                    String explanation = phoneCase.getExplanation();
                    int price = phoneCase.getPrice();
                    String imgPath = phoneCase.getImg();
                    caseColors = caseColorService.getCaseColor(caseName);
            %>      
            <tr>
                <td  bgcolor="#dcdcdc" align="center"><%=caseName%></td>
                <td  bgcolor="#dcdcdc" align="center"><form action = "stockChange" method = "post">
                        <select name="caseColor" width="10">
                                <option name="caseColor" value="unknown">-----
                                    <%for (int j = 0; j < caseColors.size(); j++) {
                                            v_caseColor = caseColors.get(j);
                                            String caseColor = v_caseColor.getCaseColor();%>
                                <option name="caseColor" value="<%=caseColor%>"><%=caseColor%>
                                    <% }%>
                            </select>
                            <br>
                            <input type="text" name="stock"><br>
                        <input type="hidden" name="caseName" value="<%=caseName%>"> <input type ="submit" value="재고 수정">
                    </form></td>
                <td  bgcolor="#dcdcdc" align="center">
                    <form action="deleteCase" method="post">
                        <input type="hidden" name="caseID" value="<%=caseID%>">
                        <input type="image" src="image\delete.jpg" name="Submit" value ="삭제" aline="absmiddle">
                    </form>
                </td>
            </tr>
            <% }%>
        </table>
        <br><br><br>
    </center>
</body>
</html>
