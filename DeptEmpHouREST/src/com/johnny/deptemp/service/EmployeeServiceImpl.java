package com.johnny.deptemp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.johnny.deptemp.dao.EmployeeDAO;
import com.johnny.deptemp.entity.Employee;

@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeDAO empDAO;
	
	@Autowired // constructor injection
	EmployeeServiceImpl (EmployeeDAO empDAO) {
		this.empDAO = empDAO;
	}
	
	
//	@Autowired //setter injection
//	public void setEmpDAO(EmployeeDAO empDAO) {
//		this.empDAO = empDAO;
//	}

	@Override
	@Transactional
	public void saveEmp(Employee emp) {
		empDAO.save(emp);
	}

	@Override
	public List<Employee> loadEmpBasicInfo() {
		return empDAO.findBasicEmpInfo();
	}

	@Override
	public List<Employee> loadEmpDetails() {
		return null;
	}

	@Override
	public Employee loadEmpBasicInfoById(Integer empId) {		
		return empDAO.findBasicEmpInfoById(empId);
	}

}
