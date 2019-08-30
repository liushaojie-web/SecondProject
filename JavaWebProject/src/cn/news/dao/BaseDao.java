package cn.news.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import cn.news.util.ConfigManager;
/**
 * 数据库连接工具类
 * @author lxh
 *
 */
public class BaseDao {
	private static Connection conn;
	private static Statement state;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	//获取数据库连接
	public void getConnection() {
		String driver = ConfigManager.getInstance().getString("driver");
		String url = ConfigManager.getInstance().getString("url");
		String username = ConfigManager.getInstance().getString("username");
		String password = ConfigManager.getInstance().getString("password");
		try {
			// 1.加载驱动
			//Class.forName(driver);
			// 2.DriverManager创建连接
			//conn = DriverManager.getConnection(url, username, password);
		
			//初始化上下文--全局
			Context context = new InitialContext(); 
			DataSource ds = 
			(DataSource) context.lookup("java:comp/env/jdbc/news");
			conn = ds.getConnection();
/*		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
*/		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}

	// 查
	public ResultSet executeQuery(String sql,Object... params) {
		try {
			// 3.通过statement对象执行sql
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i+1, params[i]);
			}
			// 4.结果为ResultSet
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			return rs;
		}
	}

	// 增删改
	public int executeUpdate(String sql,Object... params) {
		int result = 0;
		try {
			// 3.通过statement对象执行sql
			//state = conn.createStatement();
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i+1, params[i]);
			}
			// 4.返回结果为int受影响的行数
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			return result;
		}
	}

	// 释放资源
	public static void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
