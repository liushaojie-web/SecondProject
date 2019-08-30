package cn.news.dao;

import java.sql.ResultSet;

import cn.news.entity.User;

public interface UserDao {
	
	public ResultSet login(User user);
}
