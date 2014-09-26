package org.rdgie.assetmanagement.service.impl;


import java.util.List;

import org.rdgie.assetmanagement.DAO.UserDAO;
import org.rdgie.assetmanagement.domain.User;
import org.rdgie.assetmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDAO userDAO;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	@Transactional
	public void addUser(User user) {
		this.userDAO.addUser(user);
	}

	@Override
	@Transactional
	public User checkUser(User user) {
		
		return userDAO.checkUser(user);
	}

	@Override
	@Transactional
	public List<User> listUsers() {
		return this.userDAO.listUsers();
	}


}


