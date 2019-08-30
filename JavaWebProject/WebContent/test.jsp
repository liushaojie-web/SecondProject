<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="cn.news.entity.User"%>
<%@page import="cn.news.service.NewsServiceImpl"%>
<%@page import="cn.news.entity.News"%>
<%@page import="cn.news.dao.NewsDaoImpl"%>
<%@page import="cn.news.dao.NewsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String username = "<h1>zs</h1>"; 
		request.setAttribute("username", username);
		User user = new User();
		request.setAttribute("user", user);
		List<String> strs = new ArrayList<String>();
		strs.add(0, "zs1");
		strs.add(1, "ls1");
		strs.add(2, "ww1");
		request.setAttribute("strs", strs);
		Date date = new Date();
		request.setAttribute("date", date);
	%>
	<c:remove var="username" scope="request"/>
	<c:set var="username1" value="ww" scope="request"/>
	<c:set value="zl" target="${user }" property="uname"/>
	<c:out value="${username }" 
		default="ls" escapeXml="true"/><br/>
	<c:out value="${username }" 
		default="ls" escapeXml="false"/><br/>
	<c:out value="${username1 }" 
		default="ls" escapeXml="false"/><br/>
	<c:out value="${user.uname }" 
		default="ls" escapeXml="false"/><br/>
	<c:forEach items="${strs }" var="str" 
					varStatus="status">
		<c:if test="${status.index%2==0 }" var="test">
			<c:out value="${status.count }"/>&nbsp;&nbsp;
			<c:out value="${str }"/><br/>
		</c:if>
		<c:if test="${status.index%2!=0 }" var="test">
			<c:out value="${status.index }"/>&nbsp;&nbsp;
			<c:out value="${str }"/><br/>
		</c:if>
	</c:forEach>
	<c:import url="top.jsp"></c:import><br/>
	<c:out value="${date }"/><br/>
	<fmt:formatDate value="${date }"
		 pattern="yyyy-MM-dd HH:mm:ss"/>
</body>
</html>