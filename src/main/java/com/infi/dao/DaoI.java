package com.infi.dao;

import java.util.List;

import com.infi.model.Employee;

public interface DaoI {

	public void addEmp(Employee employee);

	public List<Employee> getEmployee();

	public Employee loginByUnameNadPass(String uname, String pass);

	public List<Employee> deleteById(int empid);

	public Employee editById(int empId);
	
	public void updateEmp(Employee employee);

}
