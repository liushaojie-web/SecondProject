<%@page import="cn.news.entity.User"%>
<%@page import="cn.news.service.UserServiceImpl"%>
<%@page import="cn.news.service.UserService"%>
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String uname = 
			request.getParameter("uname");
		String upwd = 
			request.getParameter("upwd");
		User user = new User();
		user.setUname(uname);
		user.setUpwd(upwd);
		UserService userService = new UserServiceImpl();
		User result = userService.login(user);
		if(result != null){
			session.setAttribute("user", result);
			request.setAttribute("message", "登录成功！");
			//转发
			/* request.getRequestDispatcher("index.jsp")
							.forward(request, response); */
	%>
		<jsp:forward page="index.jsp"/>
	<%
		}else{
			request.setAttribute("message", "登录失败！");
			//重定向
			response.sendRedirect("login.jsp");
		}
	%>
	
	
	
	
	
	
	
	
</body>
</html>