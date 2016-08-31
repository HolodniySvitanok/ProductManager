package com.holodniysvitanok.productmanager.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.holodniysvitanok.productmanager.dao.FirmDAO;
import com.holodniysvitanok.productmanager.entity.Firm;

@Repository
public class FirmDAOImpl implements FirmDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Firm> getAllFirm(int count) {
		Session session = sessionFactory.getCurrentSession();
		List<Firm> list = session.createCriteria(Firm.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).setMaxResults(count).list();
		return list;
	}

	@Override
	@Transactional
	public Firm getFirm(long id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Firm firm = (Firm) currentSession.get(Firm.class, id);
		return firm;
	}

	@Override
	@Transactional
	public void saveOrUpdate(Firm firm) {
		Session session  = sessionFactory.getCurrentSession();
		session.saveOrUpdate(firm);
	}

	@Override
	@Transactional
	public void deleteFirm(Firm firm) {
		Session session  = sessionFactory.getCurrentSession();
		session.remove(firm);
	}

}
