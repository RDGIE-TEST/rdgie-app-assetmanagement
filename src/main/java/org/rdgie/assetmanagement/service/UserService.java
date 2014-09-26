package org.rdgie.assetmanagement.service;

import java.util.List;

import org.rdgie.assetmanagement.domain.User;

public interface UserService {

	public void addUser(User user);

	public User checkUser(User user);

	public List<User> listUsers();

}
