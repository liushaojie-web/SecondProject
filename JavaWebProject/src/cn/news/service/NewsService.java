package cn.news.service;

import java.util.List;

import cn.news.entity.News;
import cn.news.util.PageHelper;

//业务逻辑层
public interface NewsService {
	public List<News> getNewsList();
	
	public int addNews(News news);
	
	public News getNewsById(int nid);
	
	public int updNews(News news);
	
	public int delNews(int nid);
	
	public int count();
	
	public List<News> getNewsByPage(PageHelper pageHelper);
}
