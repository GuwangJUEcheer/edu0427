package edu0427.spring.dao;

import java.util.List;

import edu0427.spring.vo.EmpInfo;

public interface EmpDAO {
	List<EmpInfo> getEmpList();
	EmpInfo  getById(Integer deptno);
	Integer getEmpCount();

}
