package edu0427.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu0427.spring.dao.mapper.EmpMapper;
import edu0427.spring.service.EmpService;
import edu0427.spring.vo.EmpInfo;

@Component
public class EmpServiceImpl implements EmpService {
	
	@Autowired
	private EmpMapper empMapper;

	@Override
	public List<EmpInfo> getEmpList() {
		return empMapper.getEmpList();
	}

	@Override
	public EmpInfo getById(Integer deptno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getEmpCount() {
		return empMapper.getEmpCount();
	}

}
