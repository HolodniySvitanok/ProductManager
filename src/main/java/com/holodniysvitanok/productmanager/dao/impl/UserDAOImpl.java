package com.holodniysvitanok.productmanager.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.holodniysvitanok.productmanager.dao.UserDAO;
import com.holodniysvitanok.productmanager.entity.User;

@Repository
public class UserDAOImpl implements UserDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<User> getAllUsers(int count) {
		Session session = sessionFactory.getCurrentSession();
		List<User> list = session.createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).setMaxResults(count).list();
		return list;
	}

	@Override
	@Transactional
	public User getUser(long id) {
		Session session = sessionFactory.getCurrentSession();
		User user = session.get(User.class, id);
		return user;
	}

	@Override
	@Transactional
	public void saveOrUpdate(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);
	}

	@Override
	@Transactional
	public void deleteUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.remove(user);
	}
	
	
	
}
