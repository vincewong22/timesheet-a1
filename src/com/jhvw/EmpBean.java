package com.jhvw;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import ca.bcit.infosys.employee.Employee;

@Named("empbean")
@ApplicationScoped

public class EmpBean extends Employee {

	
	private static final long serialVersionUID = 1L;

}
