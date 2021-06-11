package com.stock.service.impl;

import java.util.List;

import com.stock.dao.Interface.ILigneCommandeClientDao;
import com.stock.entities.LigneCommandeClient;
import com.stock.service.Interface.ILigneCommandeClientService;
public class LigneCommandeClientServiceImpl implements ILigneCommandeClientService{
	
	private ILigneCommandeClientDao dao;
	
	public void setDao(ILigneCommandeClientDao dao) {
		this.dao = dao;
	}
	@Override
	public LigneCommandeClient save(LigneCommandeClient entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}
	@Override
	public LigneCommandeClient update(LigneCommandeClient entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}

	@Override
	public List<LigneCommandeClient> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public List<LigneCommandeClient> selectAll(String sortField, String sort) {
		// TODO Auto-generated method stub
		return dao.selectAll(sortField, sort);
	}

	@Override
	public LigneCommandeClient getById(Long id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		dao.remove(id);
	}

	@Override
	public LigneCommandeClient findOne(String paranName, Object paramValue) {
		// TODO Auto-generated method stub
		return dao.findOne(paranName, paramValue);
	}

	@Override
	public LigneCommandeClient findOne(String[] paramNames, Object[] paramValues) {
		// TODO Auto-generated method stub
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return dao.findCountBy(paramName, paramValue);
	}
	@Override
	public List<LigneCommandeClient> getByIdCommandes(Long id) {
		// TODO Auto-generated method stub
		return dao.getByIdCommandes(id);
	}

}
