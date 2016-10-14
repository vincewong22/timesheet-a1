package com.jhvw;

import javax.inject.Inject;

import ca.bcit.infosys.employee.Credentials;
import ca.bcit.infosys.employee.Employee;

public class ControllerBean {

	@Inject private Credentials credentialBean;
	@Inject private Employee employee;
	
	
	
}
