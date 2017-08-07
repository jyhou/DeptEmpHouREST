package com.johnny.deptemp.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="department")
public class Department implements Serializable{

	private static final long serialVersionUID = 134813908883019720L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="dept_id")
	private Integer deptId;
	
	@Column(name="dept_name", length=100)
	private String deptName;
	
	@Column(name="dept_email", length=150)
	private String deptEmail;
	
	@OneToMany(mappedBy="empDept",fetch=FetchType.EAGER)
//	@OneToMany(mappedBy="empDept",fetch=FetchType.LAZY)
//	@OneToMany(mappedBy="empDept")
//	@JsonIgnore //affects the REST response as if there is no getter for deptEmpList
	@JsonManagedReference
	private List<Employee> deptEmpList;
	
	public Department(){};

	public Department(Integer deptId, String deptName, String deptEmail) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptEmail = deptEmail;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptEmail() {
		return deptEmail;
	}

	public void setDeptEmail(String deptEmail) {
		this.deptEmail = deptEmail;
	}

	public List<Employee> getDeptEmpList() {
		return deptEmpList;
	}

	public void setDeptEmpList(List<Employee> deptEmpList) {
		this.deptEmpList = deptEmpList;
	}
	
}
