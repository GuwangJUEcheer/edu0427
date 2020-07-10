package edu0427.spring.service;

import java.util.List;

import edu0427.common.page.PaginationResult;
import edu0427.spring.vo.DeptInfo;

public interface DeptService {

	List<DeptInfo> getDeptList();
	DeptInfo  getById(Integer deptno);
	Integer getDeptCount();
 PaginationResult<List<DeptInfo>> getDeptPage(Integer pageIndex,Integer pageSize);
}
