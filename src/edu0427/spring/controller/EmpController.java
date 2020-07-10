package edu0427.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import edu0427.spring.service.EmpService;

@Controller
@RequestMapping("/emp")
public class EmpController {
	
	@Autowired
	private EmpService empService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String empList(ModelMap modelMap) {
		modelMap.put("list",empService.getEmpList());
		modelMap.put("cnt",empService.getEmpCount());
		//WEB-INF/jsp/emp.jsp
		return "emp";
	}
}
