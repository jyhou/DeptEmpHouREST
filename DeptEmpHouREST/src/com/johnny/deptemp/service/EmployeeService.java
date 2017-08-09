package com.johnny.deptemp.service;

import java.util.List;

import com.johnny.deptemp.entity.Employee;

public interface EmployeeService {
	public void saveEmp(Employee emp);
	public List<Employee> loadEmpBasicInfo();
	public List<Employee> loadEmpDetails();
	public Employee loadEmpBasicInfoById(Integer empId);
	public List<String> getEmpNames();
}
