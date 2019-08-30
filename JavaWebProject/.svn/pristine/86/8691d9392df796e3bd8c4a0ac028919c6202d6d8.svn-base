<%@page import="cn.news.util.PageHelper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cn.news.entity.News"%>
<%@page import="java.util.List"%>
<%@page import="cn.news.service.NewsServiceImpl"%>
<%@page import="cn.news.service.NewsService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.12.4.min.js"></script>
</head>
<body>
	<%
		NewsService newsService = new NewsServiceImpl();
		//List<News> newsList = newsService.getNewsList();
		request.setCharacterEncoding("UTF-8");
		String pageIndex = 
				request.getParameter("pageIndex");
		if(pageIndex == null){
			pageIndex = "1";
		}
		int totalPageNo = Integer.parseInt(pageIndex);
		PageHelper pageHelper = new PageHelper();
		List<News> newsList = new ArrayList<News>();
		int totalCount = newsService.count();
		if(totalCount != 0){
			pageHelper.setPageSize(5);
			pageHelper.setTotalCount(totalCount);
			if(totalPageNo == 0){
				totalPageNo = 1;
			}
			if(totalPageNo == pageHelper.getTotalPageCount()){
				totalPageNo = pageHelper.getTotalPageCount();
			}
			pageHelper.setTotalPageNo(totalPageNo);
			newsList = newsService.getNewsByPage(pageHelper);
		}
	%>
	<h2>新闻列表</h2>
	<div>
		<a href="newsAdd.jsp">添加新闻</a>
	</div>
	<table>
		<thead>
			<tr>
				<th>新闻标题</th>
				<th>发表时间</th>
				<th>新闻作者</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<% for(News news : newsList){ %>
				<tr>
					<td><a href="<%=request.getContextPath()%>/newsDetail.jsp?nid=<%=news.getNid()%>"><%=news.getNtitle() %></a></td>
					<td><%=news.getNcreateDate() %></td>
					<td><%=news.getNauthor() %></td>
					<td>
						<a href="newsUpd.jsp?nid=<%=news.getNid()%>">修改</a>
						<a id="newsDel" href="newsDel.jsp?nid=<%=news.getNid()%>">删除</a>
					</td>
				</tr>
			<%} %>
		</tbody>
	</table>
	<%if(pageHelper.getTotalPageNo() != 1){ %>
		<a href="<%=request.getContextPath()%>/newsList.jsp?pageIndex=1">首页</a>
		<a href="<%=request.getContextPath()%>/newsList.jsp?pageIndex=<%=pageHelper.getTotalPageNo()-1%>">上一页</a>
	<%} %>
	<%for(int i=1;i<=pageHelper.getTotalPageCount();i++){ %>
		<a href="<%=request.getContextPath()%>/newsList.jsp?pageIndex=<%=i %>"><%=i %></a>
	<%} %>
	<%if(pageHelper.getTotalPageNo() != pageHelper.getTotalPageCount()){ %>
		<a href="<%=request.getContextPath()%>/newsList.jsp?pageIndex=<%=pageHelper.getTotalPageNo()+1%>">下一页</a>
		<a href="<%=request.getContextPath()%>/newsList.jsp?pageIndex=<%=pageHelper.getTotalPageCount()%>">末页</a>
	<%} %>
	<form action="<%=request.getContextPath()%>/newsList.jsp">
		<select name="pageIndex">
			<%for(int i=1;i<=pageHelper.getTotalPageCount();i++){ %>
				<%if(i == pageHelper.getTotalPageNo()){ %>
					<option value="<%=i %>" selected="selected"><%=i %></option>
				<%} %>
				<%if(i != pageHelper.getTotalPageNo()){ %>
					<option value="<%=i %>"><%=i %></option>
				<%} %>
			<%} %>
		</select>
		<input type="submit" value="跳转" />
	</form>
	
</body>
</html>