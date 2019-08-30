package cn.news.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.news.dao.BaseDao;
import cn.news.dao.NewsDao;
import cn.news.dao.NewsDaoImpl;
import cn.news.entity.News;
import cn.news.util.PageHelper;

public class NewsServiceImpl implements NewsService {
	private NewsDao newsDao = new NewsDaoImpl();

	@Override
	public List<News> getNewsList() {
		ResultSet rs = newsDao.getNewsList();
		List<News> newsList = new ArrayList<News>();
		News news = null;
		try {
			while(rs.next()){
				news = new News();
				news.setNid(rs.getInt("nid"));
				news.setNtid(rs.getInt("ntid"));
				news.setNtitle(rs.getString("ntitle"));
				news.setNauthor(rs.getString("nauthor"));
				news.setNcreateDate(rs.getDate("ncreateDate"));
				news.setNpicpath(rs.getString("npicPath"));
				news.setNcontent(rs.getString("ncontent"));
				news.setNmodifyDate(rs.getDate("nmodifyDate"));
				news.setNsummary(rs.getString("nsummary"));
				newsList.add(news);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		BaseDao.close();
		return newsList;
	}

	@Override
	public int addNews(News news) {
		return newsDao.addNews(news);
	}

	@Override
	public News getNewsById(int nid) {
		ResultSet rs = newsDao.getNewsByNid(nid);
		News news = null;
		try {
			while(rs.next()){
				news = new News();
				news.setNid(rs.getInt("nid"));
				news.setNtid(rs.getInt("ntid"));
				news.setNtitle(rs.getString("ntitle"));
				news.setNauthor(rs.getString("nauthor"));
				news.setNcreateDate(rs.getDate("ncreateDate"));
				news.setNpicpath(rs.getString("npicPath"));
				news.setNcontent(rs.getString("ncontent"));
				news.setNmodifyDate(rs.getDate("nmodifyDate"));
				news.setNsummary(rs.getString("nsummary"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		BaseDao.close();
		return news;
	}

	@Override
	public int updNews(News news) {
		return newsDao.updNews(news);
	}

	@Override
	public int delNews(int nid) {
		return newsDao.delNews(nid);
	}

	@Override
	public int count() {
		ResultSet rs = newsDao.count();
		int count = 0;
		try {
			while(rs.next()){
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		BaseDao.close();
		return count;
	}

	@Override
	public List<News> getNewsByPage(PageHelper pageHelper) {
		ResultSet rs = newsDao.getNewsByPage(pageHelper);
		List<News> newsList = new ArrayList<News>();
		News news = null;
		try {
			while(rs.next()){
				news = new News();
				news.setNid(rs.getInt("nid"));
				news.setNtid(rs.getInt("ntid"));
				news.setNtitle(rs.getString("ntitle"));
				news.setNauthor(rs.getString("nauthor"));
				news.setNcreateDate(rs.getDate("ncreateDate"));
				news.setNpicpath(rs.getString("npicPath"));
				news.setNcontent(rs.getString("ncontent"));
				news.setNmodifyDate(rs.getDate("nmodifyDate"));
				news.setNsummary(rs.getString("nsummary"));
				newsList.add(news);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		BaseDao.close();
		return newsList;
	}

}
