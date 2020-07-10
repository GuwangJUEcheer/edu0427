package edu0427.common.page;

public class Pagination {
private Integer pageIndex;
//页码
private Integer pageSize;
//数量
private Integer totalCount;
//数据
private Integer totalCountPage;
//页数 (totalCount+pageSize-1)/pageSize
private Integer currentPageCount;
//return list size
private Integer cursor;
public Pagination(Integer pageIndex, Integer pageSize) {
	if(null==pageIndex||null==pageSize) {
		this.pageIndex=1;
		this.pageSize=10;
	}else{
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
	}
}
public Integer getTotalCount() {
	return totalCount;
}
public void setTotalCount(Integer totalCount) {
	this.totalCount = totalCount;
}
public Integer getTotalCountPage(){
	if(null==totalCountPage){
		totalCountPage=(totalCount+pageSize-1)/pageSize;
	}
	return totalCountPage;
}
public void setTotalCountPage(Integer totalCountPage) {
	this.totalCountPage = totalCountPage;
}
public Integer getCurrentPageCount() {
	return currentPageCount;
}
public void setCurrentPageCount(Integer currentPageCount) {
	this.currentPageCount = currentPageCount;
}
public Integer getCursor(){
	//数据库下面查询的第一个数
if(null==cursor) {
	cursor=(pageIndex-1)*pageSize;
}
	return cursor;
}
public void setCursor(Integer cursor) {
	this.cursor = cursor;
}
public  Integer getOffset() {
	if(null==offset) {
		offset=pageSize;
	}
	return offset;
}
public void setOffset(Integer offset) {
	this.offset = offset;
}
public Integer getPageIndex() {
	return pageIndex;
}
public void setPageIndex(Integer pageIndex) {
	this.pageIndex = pageIndex;
}
public Integer getPageSize() {
	return pageSize;
}
public void setPageSize(Integer pageSize) {
	this.pageSize = pageSize;
}
private Integer offset;
}