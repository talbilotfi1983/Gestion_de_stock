package com.stock.service.impl;

import java.util.List;

import com.stock.dao.Interface.IFournisseurDao;
import com.stock.entities.Fournisseur;
import com.stock.service.Interface.IFournisseurService;

public class FournisseurServiceImpl implements IFournisseurService{
	
	private IFournisseurDao dao;
	
	public void setDao(IFournisseurDao dao) {
		this.dao = dao;
	}
	@Override
	public Fournisseur save(Fournisseur entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}
	@Override
	public Fournisseur update(Fournisseur entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}

	@Override
	public List<Fournisseur> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public List<Fournisseur> selectAll(String sortField, String sort) {
		// TODO Auto-generated method stub
		return dao.selectAll(sortField, sort);
	}

	@Override
	public Fournisseur getById(Long id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		dao.remove(id);
	}

	@Override
	public Fournisseur findOne(String paranName, Object paramValue) {
		// TODO Auto-generated method stub
		return dao.findOne(paranName, paramValue);
	}

	@Override
	public Fournisseur findOne(String[] paramNames, Object[] paramValues) {
		// TODO Auto-generated method stub
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return dao.findCountBy(paramName, paramValue);
	}

}
