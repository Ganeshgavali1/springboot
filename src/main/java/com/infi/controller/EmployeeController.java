package com.infi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.infi.model.Employee;
import com.infi.service.ServiceI;

@Controller
public class EmployeeController {

	@Autowired
	private ServiceI ser;

	@RequestMapping("/")
	public String openIndex() {

		return "index";
	}

	@RequestMapping("/reg")
	public String openReg() {

		return "register";
	}

	@RequestMapping(value = "/addData", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute Employee employee) {
		ser.addEmp(employee);
		return "index";
	}

	@RequestMapping("/get")
	public String getEmp(Model model) {
		List<Employee> emplist = ser.getEmployee();
		model.addAttribute("data", emplist);
		return "success";
	}

	@RequestMapping("/login")
	public String login(@RequestParam String uname, @RequestParam String pass, Model model) {
		Employee emp = ser.loginByUnameNadPass(uname, pass);
		List<Employee> emplist = new ArrayList<>();
		emplist.add(emp);
		model.addAttribute("data", emplist);
		return "success";
	}

	@RequestMapping("/delete")
	public String deleteById(@RequestParam("empId") int empId, Model model) {
		List<Employee> emplist = ser.deleteById(empId);
		model.addAttribute("data", emplist);
		return "success";
	}

	@RequestMapping("/edit")
	public String edit(@RequestParam int empId, Model model) {
		Employee e = ser.editById(empId);
		model.addAttribute("data", e);
		return "edit";
	}

	@RequestMapping("/update")
	public String update(@ModelAttribute Employee employee, Model model) {
		ser.updateEmp(employee);
		List<Employee> empList = ser.getEmployee();
		model.addAttribute("data", empList);
		return "success";

	}
}
