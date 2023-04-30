package com.infi.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infi.model.Employee;

@Repository
public class DaoImpl implements DaoI {

	@Autowired
	private SessionFactory sf;

	@Override
	public void addEmp(Employee employee) {
		Session session = sf.openSession();
		session.save(employee);
		session.beginTransaction().commit();
		System.out.println("Employee save");

	}

	@Override
	public List<Employee> getEmployee() {
		Session session = sf.openSession();
		String hql = "from Employee";
		Query<Employee> query = session.createQuery(hql);
		List<Employee> emplist = query.getResultList();
		return emplist;
	}

	@Override
	public Employee loginByUnameNadPass(String uname, String pass) {
		Session session = sf.openSession();
		String hql = "from Employee where uname='" + uname + "' and pass='" + pass + "' ";
		Query<Employee> query = session.createQuery(hql);
		Employee emp = query.getSingleResult();
		return emp;
	}

	@Override
	public List<Employee> deleteById(int empId) {

		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		String hql = "delete from Employee where empId=" + empId;
		Query<Employee> query = session.createQuery(hql);
		query.executeUpdate();
		t.commit();
		List<Employee> empList = getEmployee();
		return empList;
	}

	@Override
	public Employee editById(int empId) {
		Session session = sf.openSession();
		Employee E = session.get(Employee.class, empId);
		return E;
	}

	@Override
	public void updateEmp(Employee employee) {
		Session session = sf.openSession();
		session.update(employee);
		session.beginTransaction().commit();
	}

}
