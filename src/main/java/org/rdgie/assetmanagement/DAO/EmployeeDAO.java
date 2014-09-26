package org.rdgie.assetmanagement.DAO;

import java.util.List;

import org.rdgie.assetmanagement.domain.Employee;


public interface EmployeeDAO {

	public Employee getEmployeeById(int employeeId);
	public void addEmployee(Employee employee);
	public void removeEmployee(int employeeId);
	public void updateEmployee(Employee employee);
	public List<Employee> listEmployees();
	
	
}
