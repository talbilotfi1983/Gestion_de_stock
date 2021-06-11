package com.stock.service.impl;

import java.util.List;

import com.stock.dao.Interface.ILigneVenteDao;
import com.stock.entities.LigneVente;
import com.stock.service.Interface.ILigneVenteService;
public class LigneVenteServiceImpl implements ILigneVenteService{
	
	private ILigneVenteDao dao;
	
	public void setDao(ILigneVenteDao dao) {
		this.dao = dao;
	}
	@Override
	public LigneVente save(LigneVente entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}
	@Override
	public LigneVente update(LigneVente entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}

	@Override
	public List<LigneVente> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public List<LigneVente> selectAll(String sortField, String sort) {
		// TODO Auto-generated method stub
		return dao.selectAll(sortField, sort);
	}

	@Override
	public LigneVente getById(Long id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		dao.remove(id);
	}

	@Override
	public LigneVente findOne(String paranName, Object paramValue) {
		// TODO Auto-generated method stub
		return dao.findOne(paranName, paramValue);
	}

	@Override
	public LigneVente findOne(String[] paramNames, Object[] paramValues) {
		// TODO Auto-generated method stub
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return dao.findCountBy(paramName, paramValue);
	}


}
