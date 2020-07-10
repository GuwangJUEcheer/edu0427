package edu0427.spring.dao;

import java.util.List;

import edu0427.spring.vo.DeptInfo;

public interface DeptDAO {
	List<DeptInfo> getDeptList();
	DeptInfo  getById(Integer deptno);
	Integer getDeptCount();
}
