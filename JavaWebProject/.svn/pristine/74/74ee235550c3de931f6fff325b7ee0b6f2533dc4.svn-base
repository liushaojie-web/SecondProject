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
<script type="text/javascript" 
	src="<%=request.getContextPath()%>/ckeditor/ckeditor.js"></script>
</head>
<body>
	<h2>添加新闻</h2>
	<%
		TopicService topicService = new TopicServiceImpl();
		List<Topic> topicList = topicService.getTopicList();
	%>
	<form action="doNewsAdd.jsp" method="post" enctype="multipart/form-data">
		新闻标题：<input type="text" name="ntitle" /><br/>
		新闻类型：<select name="ntid">
				<%for(Topic topic :topicList){ %>
					<option value="<%=topic.getTid()%>"><%=topic.getTname()%></option>
				<%} %>
				</select><br/>
		新闻作者：<input type="text" name="nauthor" /><br/>
		新闻简介：<input type="text" name="nsummary" /><br/>
		新闻图片：<input type="file" name="npicpath" /><br/>
		新闻内容：<textarea rows="10" cols="50" name="ncontent"></textarea><br/>
			<input type="submit" value="添加"/>
			<input type="reset" value="清空"/>
			<a href="newsList.jsp">返回</a>
	</form>
</body>	
</html>