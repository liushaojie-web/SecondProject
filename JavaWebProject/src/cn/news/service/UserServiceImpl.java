package cn.news.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.news.dao.BaseDao;
import cn.news.dao.UserDao;
import cn.news.dao.UserDaoImpl;
import cn.news.entity.User;

public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl();
	
	@Override
	public User login(User user) {
		ResultSet rs = userDao.login(user);
		User result = null;
		try {
			while(rs.next()){
				result = new User();
				result.setUid(rs.getInt("uid"));
				result.setUname(rs.getString("uname"));
				result.setUpwd(rs.getString("upwd"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		BaseDao.close();
		return result;
	}

}
