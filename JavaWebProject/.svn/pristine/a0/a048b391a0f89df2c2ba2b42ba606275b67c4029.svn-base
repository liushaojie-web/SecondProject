<%@page import="java.util.Date"%>
<%@page import="cn.news.service.NewsServiceImpl"%>
<%@page import="cn.news.service.NewsService"%>
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
		Integer nid = Integer.valueOf(request.getParameter("nid"));
		String ntitle = request.getParameter("ntitle");
		Integer ntid = Integer.valueOf(request.getParameter("ntid"));
		String nauthor = request.getParameter("nauthor");
		String nsummary = request.getParameter("nsummary");
		String ncontent = request.getParameter("ncontent");
		News news = new News();
		news.setNid(nid);
		news.setNtitle(ntitle);
		news.setNtid(ntid);
		news.setNauthor(nauthor);
		news.setNsummary(nsummary);
		news.setNcontent(ncontent);
		news.setNmodifyDate(new Date());
		NewsService newsService = new NewsServiceImpl();
		int result = newsService.updNews(news);
		if(result > 0){
			response.sendRedirect("newsList.jsp");
		}else{
			request.getRequestDispatcher("newsUpd.jsp").forward(request, response);
		}
	%>
</body>
</html>