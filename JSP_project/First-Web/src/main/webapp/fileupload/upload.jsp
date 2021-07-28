<%@page import="java.io.File"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 사용자가 전송한 데이터, 파일 저장
	// view로 파일의 경로 전달
	// 지정된 경로의 이미지를 출력
	
	// 사용자 폼 데이터
	String title = null;
	String newFile = null;
	
	// 1. multipart 여부 확인
	boolean isMultpart = ServletFileUpload.isMultipartContent(request);
	
	if(isMultpart) {
		// 2. 파일을 저장할 factory 객체 생성
		DiskFileItemFactory factory = new DiskFileItemFactory();
	
		// 3. 요청 처리(form안에 있는 input들을 분리)를 위해서 ServletFileUpload 생성
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		// 4. 사용자 요청을 파싱(분리: 원하는 형태로 분리 input > FileItem)
		// FileItem > input 데이터를 저장하는 객체
		List<FileItem> items = upload.parseRequest(request);
		
		Iterator<FileItem> itr = items.iterator();
		
		while(itr.hasNext()) {
			FileItem item = itr.next();
			// text, checkbox, hidden, password, file
			
			
			// file과 file 이외의 폼을 구분
			if(item.isFormField()) {
				// 일반 input type 처리
				// 파라미터 이름, 해당 폼의 데이터(문자열)
				String paramName = item.getFieldName();
				if(paramName.equals("title")) {
					String paramValue = item.getString("utf-8");
					title = paramValue;
					
					out.println("title : "+title+"<br>");
					
				} else if(paramName.equals("title2")) {
					//
				}
				
			} else {
				// type=file 처리
				String uploadUri = "/upload";
				String dir = request.getSession().getServletContext().getRealPath(uploadUri);
				
				File saveDir = new File(dir);
				
				if(!saveDir.exists()) {
					saveDir.mkdir();
					System.out.println("새 폴더 생성");
				}
				
				out.println(dir);
						
				String paramName = item.getFieldName();
				if(paramName.equals("photo")) {
					
					String userFileName = item.getName();
					String contentType = item.getContentType();
					long fileSize = item.getSize();
					
					out.println("fileName : "+userFileName+"<br>");
					out.println("contentType : "+contentType+"<br>");
					out.println("fileSize : "+fileSize+"<br>");
					
					//파일을 쓰기 위한 조건
					if(userFileName != null && fileSize > 0) {
						File savePath = new File(dir, userFileName);
						item.write(savePath);
						System.out.println("데이터 저장 완료");
						newFile = userFileName;
					}
					
				} else if(paramName.equals("file")) {
					//
				}
			}
		}
	}
	
	request.setAttribute("title", title);
	request.setAttribute("photo", newFile);
%>
<jsp:forward page="upload_view.jsp"></jsp:forward>