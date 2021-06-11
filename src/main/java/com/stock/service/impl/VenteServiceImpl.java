package com.stock.service.impl;

import java.util.List;

import com.stock.dao.Interface.IVenteDao;
import com.stock.entities.Vente;
import com.stock.service.Interface.IVenteService;

public class VenteServiceImpl implements IVenteService{
	
	private IVenteDao dao;
	
	public void setDao(IVenteDao dao) {
		this.dao = dao;
	}
	@Override
	public Vente save(Vente entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}
	@Override
	public Vente update(Vente entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}

	@Override
	public List<Vente> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public List<Vente> selectAll(String sortField, String sort) {
		// TODO Auto-generated method stub
		return dao.selectAll(sortField, sort);
	}

	@Override
	public Vente getById(Long id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		dao.remove(id);
	}

	@Override
	public Vente findOne(String paranName, Object paramValue) {
		// TODO Auto-generated method stub
		return dao.findOne(paranName, paramValue);
	}

	@Override
	public Vente findOne(String[] paramNames, Object[] paramValues) {
		// TODO Auto-generated method stub
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return dao.findCountBy(paramName, paramValue);
	}

}
