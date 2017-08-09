package com.johnny.deptemp.dao;

import java.util.List;

import com.johnny.deptemp.entity.Department;

public interface DepartmentDAO {
	
	void save(Department dept);
	List<Department> findDeptDetails();
	List<Department> findBasicDeptInfo();
	Department findBasicDeptInfoById(Integer deptId);
	List<String> findDeptWithEmpNames();
	void insert(Department dept);

}
