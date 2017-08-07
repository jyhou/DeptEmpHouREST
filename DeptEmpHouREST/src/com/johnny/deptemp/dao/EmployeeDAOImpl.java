package com.johnny.deptemp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.johnny.deptemp.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
	
	@PersistenceContext
	EntityManager em;

	@Override
	public void save(Employee emp) {
		em.persist(emp);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findBasicEmpInfo() {
		Query query = em.createQuery("Select Object(e) From Employee e");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findEmpDetails() {
		Query query = em.createQuery("SELECT Object(e) FROM Employee e Left Join FETCH e.empDept empDept");
		return query.getResultList();
	}

	@Override
	public Employee findBasicEmpInfoById(Integer empId) {
		return em.find(Employee.class, empId);
	}

}
