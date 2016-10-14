package com.jhvw;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import ca.bcit.infosys.employee.Credentials;

@Named("credentialbean")
@ApplicationScoped

public class UserBean extends Credentials {
	private static final long serialVersionUID = 1L;
}
