package cn.news.dao;

import java.sql.ResultSet;

public class TopicDaoImpl extends BaseDao implements TopicDao {

	@Override
	public ResultSet getTopicList() {
		getConnection();
		String sql = "select * from topic";
		return executeQuery(sql);
	}

}
