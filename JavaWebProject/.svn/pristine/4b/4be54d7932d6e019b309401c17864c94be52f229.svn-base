package cn.news.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.news.entity.User;
import cn.news.service.UserService;
import cn.news.service.UserServiceImpl;

/**
 * Servlet implementation class Login
 */
@WebServlet("/doLogin")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		User user = new User();
		user.setUname(uname);
		user.setUpwd(upwd);
		UserService userService = new UserServiceImpl();
		User result = userService.login(user);
		HttpSession session = request.getSession();
		if(result != null){
			session.setAttribute("user", result);
			request.setAttribute("message", "登录成功！");
			response.sendRedirect("index.jsp");
		}else{
			request.setAttribute("message", "登录失败！");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
