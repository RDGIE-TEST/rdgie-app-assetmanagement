package org.rdgie.assetmanagement.DAO;

import java.util.List;

import org.rdgie.assetmanagement.domain.User;

public interface UserDAO {

	public void addUser(User user);

	public User checkUser(User user);
	
	public List<User> listUsers();


	

	

}
