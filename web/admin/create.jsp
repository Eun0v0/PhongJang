<%@page import="java.util.Iterator" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr"%>
<html>
    <head><title>파일 업로드 폼</title></head>
    <body>

        <center>
        <h2>상품 등록</h2>

        <hr>
        <!-- action에는 jsp 나 servlet 둘중 하나가 올수 있음 -->
        <form action="createprocess" method="post" enctype="multipart/form-data">  
            <table width="1100" height="300">
                <tr>
                    <td width="900">
                        <hr size="1"><br>
                        <div align="left"><font size="2">케이스 이름</font></div>
                        <div align="right"><input type="text" name="caseName" size="40" padding="10px"></div>
                        <div align="left"><font size="2">케이스 타입</font></div>
                        <div align="right"><select name="caseType" >
                                <option name="caseType" value="unknown">-----
                                <option name="caseType" value="젤리">젤리
                                <option name="caseType" value="하드">하드
                                <option name="caseType" value="범퍼">범퍼</select></div>
                        <div align="left"><font size="2">가격</font></div>
                        <div align="right"><input type="text" name="price" size="10" padding="10px">원</div>
                        <div align="left"><font size="2">설명</font></div>
                        <div align="right"><textarea name="explanation" cols="65" rows="4"></textarea></div>
                        <div align="left">상품이미지 : </div>
                        <div align="right"><input type="file" name="img"><br> </div>
                        <hr size="1">
                    </td>
                </tr>
            </table>
                <table>
                    
                    <td><tr><input type="submit" value="등록"> &nbsp;&nbsp; <input type="reset" value="다시쓰기"> </tr> </td>
                </table>
            <hr size="1" width="1100">
        </form>
        </center>
    </body>
</html>