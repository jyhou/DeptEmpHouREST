package com.johnny.deptemp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.johnny.deptemp.entity.Department;
import com.johnny.deptemp.service.DepartmentService;

@Controller
//@RestController
public class DeptController {
	
//	@Autowired // does not give errors when used with constructor injection
	private DepartmentService deptService;
	
//	@Autowired
//	DepartmentService deptService;
	
	@Autowired
	public DeptController(DepartmentService deptService) {
		this.deptService = deptService;
	}
	
	@RequestMapping(value="/showAddDept")
	public String showAddDept(HttpServletRequest request) {
		request.getServletContext().setAttribute("allDept", deptService.loadDeptBasicInfo());
		return "addDepartment";
	}
	

	@RequestMapping(value="/dept", method=RequestMethod.GET)
	@ResponseBody
	public List<Department> getDeptBasicInfo(HttpServletRequest request) {
		return deptService.loadDeptBasicInfo();
	}
	
	@RequestMapping(value="/dept/{deptId}",method=RequestMethod.GET)
	@ResponseBody
	public Department getDeptBasicInfoById(@PathVariable(value="deptId") Integer deptId){
		return deptService.loadDeptBasicInfoById(deptId);
	}
	
	@RequestMapping(value="/deptDetails",method=RequestMethod.GET)
	@ResponseBody
	public List<Department> getDeptDetail() {
		return deptService.loadDeptDetails();
	}

}
