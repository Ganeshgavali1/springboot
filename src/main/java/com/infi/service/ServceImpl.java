package com.infi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infi.dao.DaoI;
import com.infi.model.Employee;

@Service
public class ServceImpl implements ServiceI {

	@Autowired
	private DaoI dao;

	@Override
	public void addEmp(Employee employee) {
		dao.addEmp(employee);
	}

	@Override
	public List<Employee> getEmployee() {
		List<Employee> emplist = dao.getEmployee();
		return emplist;
	}

	@Override
	public Employee loginByUnameNadPass(String uname, String pass) {
		Employee emp = dao.loginByUnameNadPass(uname, pass);
		return emp;
	}

	@Override
	public List<Employee> deleteById(int empId) {
		List<Employee> e = dao.deleteById(empId);
		return e;
	}

	@Override
	public Employee editById(int empId) {
		return dao.editById(empId);
	}

	@Override
	public void updateEmp(Employee employee) {
		dao.updateEmp(employee);
	}

}
