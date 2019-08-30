<%@page import="cn.news.entity.News"%>
<%@page import="cn.news.service.NewsServiceImpl"%>
<%@page import="cn.news.service.NewsService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		News news = newsService.getNewsById(nid);
		request.setAttribute("news", news);
	%>
	<div style="text-align:center;"><h1>${news.ntitle }</h1></div>
	<div style="text-align:center;">发表时间:${news.ncreateDate }&nbsp;&nbsp;&nbsp;&nbsp;作者:${news.nauthor }</div>
	<div>简介:${news.nsummary }</div>
	<div>&nbsp;&nbsp;&nbsp;&nbsp;${news.ncontent }</div>
	<div style="text-align:center;"><a href="<%=request.getContextPath()%>/newsList.jsp">返回</a></div>
</body>
</html>