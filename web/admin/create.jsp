<%@page import="java.util.Iterator" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr"%>
<html>
    <head><title>���� ���ε� ��</title></head>
    <body>

        <center>
        <h2>��ǰ ���</h2>

        <hr>
        <!-- action���� jsp �� servlet ���� �ϳ��� �ü� ���� -->
        <form action="createprocess" method="post" enctype="multipart/form-data">  
            <table width="1100" height="300">
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
                        <div align="left">��ǰ�̹��� : </div>
                        <div align="right"><input type="file" name="img"><br> </div>
                        <hr size="1">
                    </td>
                </tr>
            </table>
                <table>
                    
                    <td><tr><input type="submit" value="���"> &nbsp;&nbsp; <input type="reset" value="�ٽþ���"> </tr> </td>
                </table>
            <hr size="1" width="1100">
        </form>
        </center>
    </body>
</html>