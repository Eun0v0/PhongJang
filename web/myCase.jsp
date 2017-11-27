
<%@page import="domain.PhoneCase"%>
<%@page import="java.util.ArrayList"%>
<%@page import="domain.PhoneCaseService"%>
<%@page import="java.util.Iterator" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr"%>
<%@page import="domain.User"%>
<jsp:useBean id="status" scope="request" class="util.Status"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>상품 추가</title>
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

                <td><a href="event.jsp"><img src="image\event_.jpg" height="35" width="140"></a></td> 
            </tr>
        </table>
    </center>
    <hr size="5" color="black">
    <%--여기서부터 코드내용--%>

    <%if ((status != null) && !status.isSuccessful()) {%>
    <font color="red">There were problems processing your request:
    <ul><%Iterator errors = status.getExceptions();
        while (errors.hasNext()) {
            Exception ex = (Exception) errors.next();%>
        <li><%= ex.getMessage()%><%}%></ul></font>    
        <%}%>
        <center><h1><br>마이 케이스 주문 문의<br></h1></center>
    <center>
        <form action="myCaseCreate" method="post" enctype="multipart/form-data"> 
            <table>
                <tr>
                <tr><img src="image/색상 이미지.jpg" width="500" height="500"></tr>
                <br><br> 
                <tr><font color="red">*주문 확정후 3일 내로 입금해주셔야 합니다.<br>
                                      *주문 확정후 디자인 변경 및 환불이 불가합니다.</font></tr>
                    <tr height="1" bgcolor="#ECBFD8"><td colspan="4"></td></tr>
                    <tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
                    <tr>
                        <td>&nbsp;</td>
                        <th width="120" height="35">제목</th>
                        <td><input name="title" size="48" maxlength="100"></td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr height="1" bgcolor="#dddddd"><td colspan="3"></td></tr>
                    <tr>
                        <td>&nbsp;</td>
                        <th width="60" height="35">케이스 타입</th>
                        <td><select name="caseType" >
                                <option name="caseType" value="unknown">-----
                                <option name="caseType" value="젤리">젤리
                                <option name="caseType" value="하드">하드
                                <option name="caseType" value="범퍼">범퍼</select></td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr height="1" bgcolor="#dddddd"><td colspan="3"></td></tr>
                    <tr>
                        <td>&nbsp;</td>
                        <th width="60" height="35">핸드폰 기종</th>
                        <td><input type="text" name="phoneType"></td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr height="1" bgcolor="#dddddd"><td colspan="3"></td></tr>
                    <tr>
                        <td>&nbsp;</td>
                        <th width="60" height="35">색상</th>
                        <td><select name="color" >
                                <option name="color" value="unknown">-----
                                <option name="color" value="화이트">화이트
                                <option name="color" value="아일랜드블루">아일랜드블루
                                <option name="color" value="체리블러썸">체리블러썸
                                <option name="color" value="에어리블루">에어리블루
                                <option name="color" value="오렌지">오렌지
                                <option name="color" value="옐로우">옐로우
                                <option name="color" value="그레이">그레이
                                <option name="color" value="레몬옐로우">레몬옐로우
                                <option name="color" value="베이크드오렌지">베이크드오렌지
                                <option name="color" value="그린">그린
                                <option name="color" value="캔디핑크">캔디핑크
                                <option name="color" value="라피스블루">라피스블루
                                <option name="color" value="피치">피치
                                <option name="color" value="레드">레드
                                <option name="color" value="핑크">핑크
                                <option name="color" value="딥그린">딥그린
                                <option name="color" value="블루">블루
                                <option name="color" value="라이트민트">라이트민트
                                <option name="color" value="네이비">네이비
                                <option name="color" value="블랙">블랙
                            </select></td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr height="1" bgcolor="#dddddd"><td colspan="3"></td></tr>
                    <tr>
                        <td>&nbsp;</td>
                        <th width="60" height="35">케이스 이미지</th>
                        <td><input type="file" name="caseImage" size="48" maxlength="50"></td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr height="1" bgcolor="#dddddd"><td colspan="3"></td></tr>
                    <tr>
                        <td>&nbsp;</td>
                        <th width="60" height="35">부가 설명</th>
                        <td><textarea name="content" cols="50" rows="13"></textarea></td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
                    <tr height="1" bgcolor="#ECBFD8"><td colspan="4"></td></tr>
                    <tr align="center">
                        <td>&nbsp;</td><br>
                    <td colspan="2">
                        <input type="hidden" name="userID" value="<%=user.getId()%>">
                        <input type="submit" value="등록">
                    <td>&nbsp;</td>
                    </tr>      
                </center></td></tr>
            </table>
        </form>
    </center>
</body>

</html>