package com.jhvw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import ca.bcit.infosys.employee.Credentials;
import ca.bcit.infosys.employee.Employee;
import ca.bcit.infosys.employee.EmployeeList;

@Named("employees")
@ApplicationScoped

public class EmpList implements EmployeeList {

	private static final long serialVersionUID = 1L;

	// private Map<Integer, Employee> userList = new
	// HashMap<Integer,Employee>();
	private ArrayList<Employee> employees = new ArrayList<Employee>();

	private Map<String, String> loginCombos = new HashMap<String, String>();

	private String errorMsg;

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public void setLoginCombos(Map<String, String> loginCombos) {
		this.loginCombos = loginCombos;
	}

	@Override
	public List<Employee> getEmployees() {
		return employees;
	}

	@Override
	public Employee getEmployee(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> getLoginCombos() {
		// TODO Auto-generated method stub
		return loginCombos;
	}

	@Override
	public Employee getCurrentEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getAdministrator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean verifyUser(Credentials credential) {
		// Set<Entry<String, String>> set = loginCombos.entrySet();
		String password = loginCombos.get(credential.getUserName());
		if (password == null) {
			errorMsg = "user doesn't exist";
			return false;
		} else if (credential.getPassword().equalsIgnoreCase(password)) {
			errorMsg = "access granted";
			return true;
		} else {
			errorMsg = "password was incorrect for user: " + credential.getUserName();
			return false;

		}
	}

	public String loginAction(Credentials credential) {
		if (verifyUser(credential))
			return "success";
		else
			return "failure";
	}

	@Override
	public String logout(Employee employee) {
		// TODO Auto-generated method stub
		// all reset values
		return "logout";
	}

	@Override
	public void deleteEmpoyee(Employee userToDelete) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addEmployee(Employee newEmployee) {
		// TODO Auto-generated method stub
		// Set<Employee> employeeSet = new TreeSet<Employee>(new
		// EmployeeComparator());
		boolean flag = false;
		errorMsg="";
		for (Employee e : employees) {
			
			if (e.getEmpNumber() == newEmployee.getEmpNumber())
				errorMsg = "duplicate id found, please enter a unique employee number";
			if (e.getUserName().equalsIgnoreCase(newEmployee.getUserName())) {
				errorMsg += "dulicate username found, please enter a unique username";
				flag = true;
			}
		}

		if (!flag) {
			employees.add(new Employee(newEmployee.getName(), newEmployee.getEmpNumber(), newEmployee.getUserName()));
			loginCombos.put(newEmployee.getUserName(), "password");
			// displayList = new ArrayList<Employee>(userList.values());
			errorMsg = null;
		}
	}
}
