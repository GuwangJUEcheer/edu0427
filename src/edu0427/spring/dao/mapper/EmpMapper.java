package edu0427.spring.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestMapping;

import edu0427.spring.vo.EmpInfo;

public interface EmpMapper {
		@Select("select * from emp")
		@RequestMapping("empInfoResult")
		List<EmpInfo> getEmpList();
		
		EmpInfo  getById(Integer empno);
		
		@Select("select count(*) as cnt from emp") 
		Integer getEmpCount();
	
}
