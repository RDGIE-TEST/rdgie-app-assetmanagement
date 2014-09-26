package org.rdgie.assetmanagement.service.impl;

import java.util.List;

import org.rdgie.assetmanagement.DAO.EmployeeDAO;
import org.rdgie.assetmanagement.domain.Employee;
import org.rdgie.assetmanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDAO employeeDAO;

	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Override
	@Transactional
	public Employee getEmployeeById(int employeeId) {
		return this.employeeDAO.getEmployeeById(employeeId);
	}

	@Override
	@Transactional
	public void addEmployee(Employee e) {
		this.employeeDAO.addEmployee(e);
	}

	@Override
	@Transactional
	public void removeEmployee(int employeeId) {
		this.employeeDAO.removeEmployee(employeeId);
	}

	@Override
	@Transactional
	public void updateEmployee(Employee e) {
		this.employeeDAO.updateEmployee(e);
	}

	@Override
	@Transactional
	public List<Employee> listEmployees() {
		return this.employeeDAO.listEmployees();
	}

}
