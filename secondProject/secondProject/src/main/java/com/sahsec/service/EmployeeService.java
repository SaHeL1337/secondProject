package com.sahsec.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sahsec.model.Employee;

/**
 * @author Dinesh Rajput
 *
 */

public interface EmployeeService {
	
	public void addEmployee(Employee employee);

	public List<Employee> listEmployeess();
	
	public Employee getEmployee(int empid);
	
	public void deleteEmployee(Employee employee);
}
