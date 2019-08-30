package cn.news.util;
/**
 * 分页工具类
 * @author lxh
 *
 */
public class PageHelper {
	private int totalCount;//总条数
	private int pageSize = 5;//每页条数
	private int totalPageNo = 1;//当前页码
	private int totalPageCount;//总页面数
	private int startNo;//起始位置
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		if(totalCount%pageSize==0){
			totalPageCount = totalCount/pageSize;
		}else{
			totalPageCount = totalCount/pageSize + 1;
		}
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPageNo() {
		return totalPageNo;
	}
	public void setTotalPageNo(int totalPageNo) {
		this.totalPageNo = totalPageNo;
		startNo = (totalPageNo-1)*pageSize;
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	public int getStartNo() {
		return startNo;
	}
	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}
	
}
