package com.holodniysvitanok.productmanager.dao;

import java.util.List;

import com.holodniysvitanok.productmanager.entity.Firm;

public interface FirmDAO {

	List<Firm> getAllFirm(int count);
	
	Firm getFirm(long id);
	
	void saveOrUpdate(Firm firm);

	void deleteFirm(Firm firm);
	
}
