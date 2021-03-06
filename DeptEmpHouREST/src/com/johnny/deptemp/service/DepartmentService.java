package com.johnny.deptemp.service;

import java.util.List;

import com.johnny.deptemp.entity.Department;

public interface DepartmentService {
	public void saveDept(Department dept);
	public List<Department> loadDeptDetails();
	public List<Department> loadDeptBasicInfo();
	public Department loadDeptBasicInfoById(Integer deptId);
	public List<String> loadDeptWithEmpNames();
	public void insertDept(Department dept);
}
