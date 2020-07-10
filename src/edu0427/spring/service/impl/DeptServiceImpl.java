package edu0427.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu0427.common.page.Pagination;
import edu0427.common.page.PaginationResult;
import edu0427.spring.dao.mapper.DeptMapper;
import edu0427.spring.service.DeptService;
import edu0427.spring.vo.DeptInfo;
@Component
public class DeptServiceImpl implements DeptService{
    @Autowired
    private DeptMapper deptMapper;
    
	public DeptInfo getById(Integer deptno) {
		// TODO Auto-generated method stub
		
		return null;
	}

	public Integer getDeptCount() {
		// TODO Auto-generated method stub
		return deptMapper.getDeptCount();
	}

	@Override
	public List<DeptInfo> getDeptList() {
		//deptdao=new DeptDAOImpl();
		return deptMapper.getDeptList();
	}

	@Override
	public PaginationResult<List<DeptInfo>> getDeptPage(Integer pageIndex, Integer pageSize) {
		// 前台传入的分页信息
		Pagination pagination=new Pagination(pageIndex,pageSize);
		Integer totalCount=getDeptCount();
		pagination.setTotalCount(totalCount);
		List<DeptInfo> list=deptMapper.getDeptPage(pagination.getCursor(), pagination.getOffset());//limit offset cursor
		pagination.setCurrentPageCount(list.size());
		PaginationResult<List<DeptInfo>> result=new PaginationResult<List<DeptInfo>>(pagination, list);
		return result;
	}


}
