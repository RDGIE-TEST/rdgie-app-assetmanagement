package org.rdgie.assetmanagement.DAO.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.rdgie.assetmanagement.DAO.UserDAO;
import org.rdgie.assetmanagement.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(UserDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
		logger.info("User saved successfully, User Details=" + user);
	}

	@Override
	public User checkUser(User user) {

		Session session = sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(User.class);
		@SuppressWarnings("unchecked")
		List<User> users = cr.list();

		User foundUser = null;

		for (User u : users) {

			if (u.equals(user))
				foundUser = u;
		}
		return foundUser;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> listUser = session.createQuery("from user").list();
		for (User u : listUser) {
			logger.info("User List::" + u);
		}
		return listUser;
	}

}
