package com.holodniysvitanok.productmanager.dao;

import java.util.List;

import com.holodniysvitanok.productmanager.entity.User;

public interface UserDAO {
	
	List<User> getAllUsers(int count);
	
	User getUser(long id);
	
	void saveOrUpdate(User user);

	void deleteUser(User user);
}
