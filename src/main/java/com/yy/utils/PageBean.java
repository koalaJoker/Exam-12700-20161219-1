package com.yy.utils;
import java.util.List;

public class PageBean<T> {

	/**总页数*/
	private int  totalPage;
	/**总记录数*/
	private int CountPage;
	/**当前页*/
	private int currentPage=1;
	/**每页显示的条数*/
	private int maxResult=6;
	/**分页的数据*/
	private List<T> datas;
	/**路径*/
	private String url;
	
	public int getTotalPage() {
		
		return totalPage=CountPage%maxResult==0?CountPage/maxResult :CountPage/maxResult+1;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCountPage() {
		return CountPage;
	}
	public void setCountPage(int countPage) {
		CountPage = countPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getMaxResult() {
		return maxResult;
	}
	public void setMaxResult(int maxResult) {
		this.maxResult = maxResult;
	}
	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
