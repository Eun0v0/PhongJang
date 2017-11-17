
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import ="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>

<%
	String filename = "";
	String realFolder=application.getRealPath("/smarteditor/smartImages");//���댄�由ъ��댁������寃쎈�
	Calendar c = Calendar.getInstance();
	int year = c.get(Calendar.YEAR);
	int month = c.get(Calendar.MONTH)+1;
	realFolder +="/"+year+"/"+month;
	if(!new File(realFolder).isDirectory()){
		new File(realFolder).mkdirs();
	}
	
	//��������������대�瑜�吏�����
	String saveFolder="smartImages";
	String encType="utf-8";//�몄������
	int maxSize = 1*1024*1024;//理�� �����������ш린 1Mb
	String id="";
	
	ServletContext context =getServletContext();
	//��� jsp���吏�� ���댄�由ъ��댁���� ���寃쎈�瑜�援ы���
	//realFolder= context.getRealPath(saveFolder);
	//out.println("the realpath is :" + realFolder + "<br>"); 
	
	try{
		MultipartRequest multi = null;
		//������대���肄ㅽ����瑜������� 洹������������
		//��������紐�� 媛��怨���� 媛�껜, ������ ���寃쎈�, 理�������� ��� �ш린, 遺��肄��,湲곕낯蹂댁� ���
		multi = new MultipartRequest(request, realFolder,maxSize, encType, new DefaultFileRenamePolicy());
		id = multi.getParameter("id");
		//Form�����誘명� 紐⑸���媛���⑤�
		Enumeration params =multi.getParameterNames();
	
		//���誘명�瑜�異�����
		while(params.hasMoreElements()){
			String name =(String)params.nextElement();//������ ���誘명� �대�
			String value = multi.getParameter(name);//������ ���誘명�媛�
			//out.println(name +" = " +value + "<br>");
		}
	
		
	
		//������ ��� ��낫瑜�媛����異�����
		Enumeration files = multi.getFileNames();
	
	 	//��� ��낫媛����硫�
		while(files.hasMoreElements()){
			//input ��렇�������file ����렇��name ���媛�: ���誘명� �대�
			String name =(String)files.nextElement();
			
			//������������� �대�
			filename = multi.getFilesystemName(name);
			
			//������������� �대�
			String original = multi.getOriginalFileName(name);
			
			//�����������댁� ���
			String type = multi.getContentType(name);
			
			//�������� �����file ����렇�� name ���媛�� �댁��������媛�껜 ���
			File file = multi.getFile(name);
	
	
			//out.println("���誘명� �대� : " +name +"<br>");
			//out.println("�ㅼ� ��� �대� : " +original +"<br>");
			//out.println("������대� : " +filename +"<br>");
			//out.println("��� ��� : " +type +"<br>");
	
			if(file!=null){
				//out.println("�ш린 : " +file.length());
				//out.println("<br>");
			}
		}
	}catch(IOException ioe){
		System.out.println(ioe);
	}catch(Exception ex){
		System.out.println(ex);
	}
%>
<html>
<head><title>   </title></head>
<body>
<script type="text/javascript">

try{
    parent.parent.insertIMG('<%=id%>','<%=year+"/"+month+"/"+filename%>');
    parent.parent.oEditors.getById['<%=id%>'].exec("SE_TOGGLE_IMAGEUPLOAD_LAYER");
} catch(e){
	alert(e);
}
</script>
</body>
</html>


