package com.sahsec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sahsec.dao.EmployeeDao;
import com.sahsec.model.Employee;

/**
 * @author Dinesh Rajput
 *
 */
@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Transactional
	public void addEmployee(Employee employee) {
		employeeDao.addEmployee(employee);
	}
	
	@Transactional
	public List<Employee> listEmployeess() {
		return employeeDao.listEmployeess();
	}

	@Transactional
	public Employee getEmployee(int empid) {
		return employeeDao.getEmployee(empid);
	}
	
	@Transactional
	public void deleteEmployee(Employee employee) {
		employeeDao.deleteEmployee(employee);
	}

}
