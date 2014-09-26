package org.rdgie.assetmanagement.DAO.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.rdgie.assetmanagement.DAO.EmployeeDAO;
import org.rdgie.assetmanagement.domain.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(EmployeeDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		Session session = this.sessionFactory.getCurrentSession();
		Employee e = (Employee) session.load(Employee.class, new Integer(
				employeeId));
		logger.info("Employee loaded successfully, Employee details=" + e);
		return e;
	}

	@Override
	public void addEmployee(Employee employee) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(employee);
		logger.info("Employee saved successfully, Employee Details=" + employee);
	}

	@Override
	public void removeEmployee(int employeeId) {
		Session session = this.sessionFactory.getCurrentSession();
		Employee e = (Employee) session.load(Employee.class, new Integer(
				employeeId));
		if (null != e) {
			session.delete(e);
		}
		logger.info("Employee deleted successfully, Employee details=" + e);
	}

	@Override
	public void updateEmployee(Employee employee) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(employee);
		logger.info("Employee updated successfully, Employee Details="
				+ employee);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> listEmployees() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(Employee.class);
		
		List<Employee> employeeList = cr.list();
		for (Employee e : employeeList) {
			logger.info("Employee List::" + e);
		}
		return employeeList;
	}

}
