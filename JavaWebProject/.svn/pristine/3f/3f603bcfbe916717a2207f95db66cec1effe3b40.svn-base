package cn.news.dao;

import java.sql.ResultSet;

import cn.news.entity.User;

public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public ResultSet login(User user) {
		getConnection();
		String sql = "select * from news_users where uname=? and upwd=?";
		return executeQuery(sql, user.getUname(),user.getUpwd());
	}

}
