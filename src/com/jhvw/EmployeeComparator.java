package com.jhvw;

import java.util.Comparator;

import ca.bcit.infosys.employee.Employee;

public class EmployeeComparator implements Comparator<Employee>{

	    public int compare(Employee e1, Employee e2){
	        return e1.getUserName().compareTo(e2.getUserName());
	    }
	
}
