package com.tarena.entity.page;
/**
 * 分页类
 * @author Administrator
 *
 */
public class Page {
	//-----分页时需要输入的条件-------
	//当前页，由用户点击页码输入，默认为第1页
	private int page = 1;
	
	//每页最大行数，固定值
	private int pageSize = 5;
	
	//页面动态创建页码时需要的值
	private int totalPage = 1;
	
	//计算总页数所依赖的条件
	private int rows;//总行数
	
	//----分页SQL所需要的条件----
	private int begin;//起始行
	private int end;//终止行
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		if(rows % pageSize == 0){
			//如果可以整除，则总页数就是相除结果
			totalPage=rows/pageSize;
		}else{
			//不能整除，则总页数是相除结果+1
			totalPage=rows/pageSize+1;
		}
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getBegin() {
		begin=(page-1)*pageSize;
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	public int getEnd() {
		end = page*pageSize+1;
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	

	
}
