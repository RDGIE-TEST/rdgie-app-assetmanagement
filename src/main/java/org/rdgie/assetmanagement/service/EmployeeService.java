package org.rdgie.assetmanagement.service;

import java.util.List;

import org.rdgie.assetmanagement.domain.Employee;

public interface EmployeeService {

	public Employee getEmployeeById(int employeeId);

	public void addEmployee(Employee employee);

	public void removeEmployee(int employeeId);

	public void updateEmployee(Employee employee);

	public List<Employee> listEmployees();

}