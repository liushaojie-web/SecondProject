<%@page import="java.io.File"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.FileItemFactory"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="cn.news.service.NewsServiceImpl"%>
<%@page import="cn.news.service.NewsService"%>
<%@page import="java.util.Date"%>
<%@page import="cn.news.entity.News"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
// 		String ntitle = request.getParameter("ntitle");
// 		Integer ntid = Integer.valueOf(request.getParameter("ntid"));
// 		String nauthor = request.getParameter("nauthor");
// 		String nsummary = request.getParameter("nsummary");
// 		String ncontent = request.getParameter("ncontent");
// 		News news = new News();
// 		news.setNtitle(ntitle);
// 		news.setNtid(ntid);
// 		news.setNauthor(nauthor);
// 		news.setNsummary(nsummary);
// 		news.setNcontent(ncontent);
// 		news.setNcreateDate(new Date());
		News news = new News();
		//判断是否是通过multipart/form-data方式提交
		if(ServletFileUpload.isMultipartContent(request)){
			//图片的保存路径
			String uploadFilePath
			 = application.getRealPath("upload/");
			//判断路径是否存在，不存在创建
			File saveFile = new File(uploadFilePath);
			if(!saveFile.exists()){
				saveFile.mkdirs();
			}
			//创建FileItemFactory对象
			FileItemFactory factory = 
					new DiskFileItemFactory();
			//创建ServletFileUpload对象
			ServletFileUpload upload =
					new ServletFileUpload(factory);
			//获取FileItem的集合
			List<FileItem> items = 
					upload.parseRequest(request);
			for(FileItem item : items){
				//判断是普通表单元素还是文件表单元素
				if(item.isFormField()){
					//获取表单元素的name属性值
					if(item.getFieldName().equals("ntitle")){
						news.setNtitle(item.getString("UTF-8"));
					}else if(item.getFieldName().equals("ntid")){
						news.setNtid(Integer.parseInt(item.getString("UTF-8")));
					}else if(item.getFieldName().equals("nauthor")){
						news.setNauthor(item.getString("UTF-8"));
					}else if(item.getFieldName().equals("nsummary")){
						news.setNsummary(item.getString("UTF-8"));
					}else if(item.getFieldName().equals("ncontent")){
						news.setNcontent(item.getString("UTF-8"));
					}
				}else{
					//获取文件名称
					String fileName = item.getName();
					if(fileName != null && !fileName.equals("")){
						//创建文件，用于写
						File file = new File(uploadFilePath,fileName);
						item.write(file);
						news.setNpicpath(fileName);
					}
				}
			}
		}
		news.setNcreateDate(new Date());
		NewsService newsService = new NewsServiceImpl();
		int result = newsService.addNews(news);
		if(result > 0){
			response.sendRedirect("newsList.jsp");
		}else{
			request.getRequestDispatcher("newsAdd.jsp").forward(request, response);
		}
	%>
</body>
</html>