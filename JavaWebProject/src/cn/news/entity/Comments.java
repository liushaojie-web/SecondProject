package cn.news.entity;
/**
 * 评论实体类
 * @author lxh
 *
 */

import java.util.Date;

public class Comments {

	/**
	 * 评论id
	 */
	private int cid;
	
	/**
	 * 评论的新闻id
	 */
	private int cnid;
	
	/**
	 * 评论内容
	 */
	private String ccontent;
	
	/**
	 * 评论时间
	 */
	private Date cdate;
	
	/**
	 * 评论ip
	 */
	private String cip;
	
	/**
	 * 评论作者
	 */
	private String cauthor;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getCnid() {
		return cnid;
	}

	public void setCnid(int cnid) {
		this.cnid = cnid;
	}

	public String getCcontent() {
		return ccontent;
	}

	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}

	public Date getCdate() {
		return cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

	public String getCip() {
		return cip;
	}

	public void setCip(String cip) {
		this.cip = cip;
	}

	public String getCauthor() {
		return cauthor;
	}

	public void setCauthor(String cauthor) {
		this.cauthor = cauthor;
	}

}
