package com.johnny.deptemp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.johnny.deptemp.dao.DepartmentDAO;
import com.johnny.deptemp.entity.Department;

@Transactional(readOnly=true)
@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	private DepartmentDAO deptDAO;
	
//	@Autowired // field injection
//	DepartmentDAO deptDAO;
	
	@Autowired // constructor injection
	public DepartmentServiceImpl(DepartmentDAO deptDAO) {
		super();
		this.deptDAO = deptDAO;
	}
	
//	@Autowired // setter injection
//	public void setDeptDAO(DepartmentDAO deptDAO) {
//		this.deptDAO = deptDAO;
//	}

	@Override
	@Transactional
	public void saveDept(Department dept) {
		deptDAO.save(dept);
	}



	@Override
	public List<Department> loadDeptDetails() {
		return deptDAO.findDeptDetails();
	}

	@Override
	public List<Department> loadDeptBasicInfo() {
		return deptDAO.findBasicDeptInfo();
	}

	@Override
	public Department loadDeptBasicInfoById(Integer deptId) {
		return deptDAO.findBasicDeptInfoById(deptId);
	}
	
	@Override
	public List<String> loadDeptWithEmpNames() {
		return deptDAO.findDeptWithEmpNames();
	}
	
	@Override
	public void insertDept(Department dept) {
		deptDAO.insert(dept);
	}
	
}
