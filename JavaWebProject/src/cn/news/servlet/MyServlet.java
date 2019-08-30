package cn.news.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/myServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MyServletdoGet");
		String str = 
				request.getServletContext()
				.getInitParameter("characterEncoding");
		System.out.println(str);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MyServletdoPost");
		//doGet(request, response);
	}

	//初始化
	public void init(ServletConfig config){
		System.out.println("MyServlet初始化");
		String str = 
				config.getInitParameter("characterEncoding");
		System.out.println(str);
	}
	//销毁
	public void destroy(){
		System.out.println("MyServlet销毁");
	}
}
