package cn.news.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.news.entity.News;
import cn.news.util.PageHelper;

public class NewsDaoImpl extends BaseDao implements NewsDao {

	@Override
	public ResultSet getNewsList() {
		getConnection();
		String sql = "select * from news";
		return executeQuery(sql);
	}

	@Override
	public int addNews(News news) {
		getConnection();
		String sql = "insert into news(ntid,ntitle,nauthor,ncreateDate,ncontent,nsummary,npicpath)" + " values(?,?,?,?,?,?,?)";
		int result = executeUpdate(sql, news.getNtid(), news.getNtitle(), news.getNauthor(), news.getNcreateDate(),
				news.getNcontent(), news.getNsummary(),news.getNpicpath());
		close();
		return result;
	}

	@Override
	public int delNews(int nid) {
		getConnection();
		String sql = "delete from news where nid=?";
		int result = executeUpdate(sql, nid);
		close();
		return result;
	}

	@Override
	public ResultSet getNewsByNid(int nid) {
		getConnection();
		String sql = "select * from news where nid=?";
		return executeQuery(sql, nid);
	}

	@Override
	public int updNews(News news) {
		getConnection();
		String sql = "update news set ntid=?,ntitle=?,nauthor=?,nsummary=?,ncontent=?,nmodifyDate=? where nid=?";
		int result = executeUpdate(sql, news.getNtid(), news.getNtitle(), news.getNauthor(), news.getNsummary(),
				news.getNcontent(), news.getNmodifyDate(), news.getNid());
		close();
		return result;
	}

	@Override
	public ResultSet count() {
		getConnection();
		String sql = "select count(1) from news";
		return executeQuery(sql);
	}

	@Override
	public ResultSet getNewsByPage(PageHelper pageHelper) {
		getConnection();
		String sql = "select * from news limit ?,?";
		return executeQuery(sql, 
					pageHelper.getStartNo(),
					pageHelper.getPageSize());
	}

}
