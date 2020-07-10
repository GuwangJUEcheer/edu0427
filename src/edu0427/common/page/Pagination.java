package edu0427.common.page;

public class Pagination {
private Integer pageIndex;
//ҳ��
private Integer pageSize;
//����
private Integer totalCount;
//����
private Integer totalCountPage;
//ҳ�� (totalCount+pageSize-1)/pageSize
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
	//���ݿ������ѯ�ĵ�һ����
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