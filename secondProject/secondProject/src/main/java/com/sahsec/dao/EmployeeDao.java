package com.sahsec.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.sahsec.model.Employee;

/**
 * @author Dinesh Rajput
 *
 */

public interface EmployeeDao {
	
	public void addEmployee(Employee employee);

	public List<Employee> listEmployeess();
	
	public Employee getEmployee(int empid);
	
	public void deleteEmployee(Employee employee);
}
