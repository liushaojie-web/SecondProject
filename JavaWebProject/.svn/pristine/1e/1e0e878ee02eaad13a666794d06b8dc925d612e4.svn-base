package cn.news.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.news.dao.BaseDao;
import cn.news.dao.TopicDao;
import cn.news.dao.TopicDaoImpl;
import cn.news.entity.Topic;

public class TopicServiceImpl implements TopicService {
	
	private TopicDao topicDao = new TopicDaoImpl();

	@Override
	public List<Topic> getTopicList() {
		ResultSet rs = topicDao.getTopicList();
		List<Topic> topicList = new ArrayList<Topic>();
		Topic topic = null;
		try {
			while(rs.next()){
				topic = new Topic();
				topic.setTid(rs.getInt("tid"));
				topic.setTname(rs.getString("tname"));
				topicList.add(topic);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		BaseDao.close();
		return topicList;
	}
	
	
}
