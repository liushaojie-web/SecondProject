<%@page import="cn.news.entity.News"%>
<%@page import="cn.news.service.NewsServiceImpl"%>
<%@page import="cn.news.service.NewsService"%>
<%@page import="cn.news.entity.Topic"%>
<%@page import="java.util.List"%>
<%@page import="cn.news.service.TopicServiceImpl"%>
<%@page import="cn.news.service.TopicService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>修改新闻</h2>
	<%
		request.setCharacterEncoding("utf-8");
		Integer nid = Integer.valueOf(request.getParameter("nid"));
		TopicService topicService = new TopicServiceImpl();
		List<Topic> topicList = topicService.getTopicList();
		NewsService newsService = new NewsServiceImpl();
		News news = newsService.getNewsById(nid);
	%>
	<form action="doNewsUpd.jsp" method="post">
		<input type="hidden" name="nid" value="<%=news.getNid()%>"/>
		新闻标题：<input type="text" name="ntitle" value="<%=news.getNtitle()%>"/><br/>
		新闻类型：<select name="ntid">
				<%for(Topic topic :topicList){ %>
					<%if(topic.getTid()==news.getNtid()){ %>
						<option value="<%=topic.getTid()%>" selected="selected"><%=topic.getTname()%></option>
					<%}else{ %>
						<option value="<%=topic.getTid()%>"><%=topic.getTname()%></option>
					<%} %>
				<%} %>
				</select><br/>
		新闻作者：<input type="text" name="nauthor" value="<%=news.getNauthor()%>"/><br/>
		新闻简介：<input type="text" name="nsummary" value="<%=news.getNsummary()%>"/><br/>
		新闻内容：<textarea rows="10" cols="50" name="ncontent"><%=news.getNcontent()%></textarea><br/>
			<input type="submit" value="修改"/>
			<input type="reset" value="重置"/>
			<a href="newsList.jsp">返回</a>
	</form>
</body>
</html>