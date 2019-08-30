<%@page import="cn.news.service.NewsService"%>
<%@page import="cn.news.service.NewsServiceImpl"%>
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
		Integer nid = Integer.valueOf(request.getParameter("nid"));
		NewsService newsService = new NewsServiceImpl();
		int result = newsService.delNews(nid);
		if(result > 0){
			request.setAttribute("message", "删除成功！");
		}else{
			request.setAttribute("message", "删除失败！");
		}
		request.getRequestDispatcher("newsList.jsp").forward(request, response);
	%>
</body>
</html>