package cn.news.dao;

import java.sql.ResultSet;
import java.util.List;

import cn.news.entity.News;
import cn.news.util.PageHelper;

public interface NewsDao {
	//获取所有新闻
	public ResultSet getNewsList();
	//添加新闻
	public int addNews(News news);
	//删除新闻
	public int delNews(int nid);
	//根据主键查询新闻
	public ResultSet getNewsByNid(int nid);
	//修改新闻
	public int updNews(News news);
	//查询新闻总条数
	public ResultSet count();
	//分页查询新闻
	public ResultSet getNewsByPage(PageHelper pageHelper);
}
