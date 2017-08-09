package com.johnny.deptemp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.johnny.deptemp.entity.Employee;
import com.johnny.deptemp.service.DepartmentService;
import com.johnny.deptemp.service.EmployeeService;

@Controller
public class EmpController {
	
	private EmployeeService empService;
	private DepartmentService deptService;
	
//	@Autowired
//	public EmpController(EmployeeService empService, DepartmentService deptService) {
//		this.empService = empService;
//		this.deptService = deptService;
//	}
	
	@Autowired
	public void setEmpService(EmployeeService empService) {
		this.empService = empService;
	}

	@Autowired
	public void setDeptService(DepartmentService deptService) {
		this.deptService = deptService;
	}

	@RequestMapping(value="showAddEmp")
	public String showAddEmp(HttpServletRequest request) {
		request.getServletContext().setAttribute("allEmp", empService.loadEmpBasicInfo());
		request.getServletContext().setAttribute("allDept", deptService.loadDeptBasicInfo());
		return "addEmployee";
	}

	@RequestMapping(value="/emp",method=RequestMethod.GET)
	@ResponseBody
	public List<Employee> getEmpBasicInfo() {
		return empService.loadEmpBasicInfo();
	}
	
	@RequestMapping(value="/emp/{empId}", method=RequestMethod.GET)
	@ResponseBody
	public Employee getEmpById(@PathVariable(value="empId") Integer empId) {
		return empService.loadEmpBasicInfoById(empId);
	}
	
	@RequestMapping(value="/empNames",method=RequestMethod.GET)
	@ResponseBody
	public List<String> getEmpNames() {
		return empService.getEmpNames();
	}
	
}
