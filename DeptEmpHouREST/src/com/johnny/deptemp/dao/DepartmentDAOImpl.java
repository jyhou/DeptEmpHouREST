package com.johnny.deptemp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.johnny.deptemp.entity.Department;


@Repository
public class DepartmentDAOImpl implements DepartmentDAO{
	
	@PersistenceContext
	EntityManager em;

	@Override
	public void save(Department dept) {
		if (dept.getDeptId() == null) {
			em.persist(dept);
		} else {
			em.merge(dept);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> findDeptDetails() {
		Query query = em.createQuery("SELECT Object(d) from Department d LEFT JOIN FETCH d.deptEmpList deptEmpList");
//		Query query = em.createQuery("SELECT Object(d) from Department d");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> findBasicDeptInfo() {
		Query query = em.createQuery("SELECT Object(d) from Department d");
		return query.getResultList();
	}

	@Override
	public Department findBasicDeptInfoById(Integer deptId) {
		return em.find(Department.class, deptId);
	}

}
