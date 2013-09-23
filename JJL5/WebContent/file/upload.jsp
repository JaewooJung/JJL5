<%@page import="java.io.File"%>
<%@page import="java.util.HashMap"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.FileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! 
long currTime = 0;
int count = 0;

synchronized private String getNewFileName() {
	long millis = System.currentTimeMillis();
	if (currTime != millis) {
		count = 0;
	}
	return "file_" + millis + "_" + (++count);
}
%>    
<%
boolean isMultipart = ServletFileUpload.isMultipartContent(request);

// 1. Client가 보낸 각 파트 데이터를 어디에 저장할 것인가?
FileItemFactory factory = new DiskFileItemFactory();

// 2. Client가 보낸 각 파트 데이터를 분리하여 위에서 정의한 저장소를 이용하여 객체를 생성
ServletFileUpload uploadHandler = new ServletFileUpload(factory);

// 3. 요청을 분석하라!
List<FileItem> partList = uploadHandler.parseRequest(request);

// 4. FileItem 객체로부터 파라미터 값이나 파일 데이터를 꺼낸다.
for(FileItem item : partList) {
	if (item.isFormField()) { // 일반 파라미터
		pageContext.setAttribute(item.getFieldName(), item.getString("UTF-8"));
	
	} else { // 파일 업로드
		String newFileName = this.getNewFileName();
		pageContext.setAttribute(item.getFieldName(), newFileName);
		String savedPath = application.getRealPath("/file/" + newFileName);
		item.write(new File(savedPath));
	}
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>파일 업로드 결과</title>
</head>
<body>
멀티파트: <%=isMultipart %><br>
이름: ${name}<br>
나이: ${age}<br>

사진1: ${photo1}<br>
<img src="${photo1}"><br>

사진2: ${photo2}<br>
<img src="${photo2}"><br>
</body>
</html>









