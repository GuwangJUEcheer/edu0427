package edu0427.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu0427.spring.service.DeptService;

@Controller
@RequestMapping("/dept")
public class DeptController {
	@Autowired
	private DeptService deptService;
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String deptList(ModelMap modelMap,Integer pageIndex,Integer pageSize) {
		/*modelMap.put("List",deptService.getDeptList());
		modelMap.put("cnt",deptService.getDeptCount());
		//WEB-INF/jsp/dept.jsp
		return "dept";*/
		modelMap.put("rs",deptService.getDeptPage(pageIndex, pageSize));
		return "dept";
	}
}
