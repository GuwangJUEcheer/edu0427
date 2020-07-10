package edu0427.spring.service;
import java.util.List;
import edu0427.spring.vo.EmpInfo;

public interface EmpService {
	List<EmpInfo> getEmpList();
	EmpInfo  getById(Integer empno);
	Integer getEmpCount();
}
