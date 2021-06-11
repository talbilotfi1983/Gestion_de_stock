package com.stock.service.impl;

import java.util.List;

import com.stock.dao.Interface.IMouvementStockDao;
import com.stock.entities.MouvementStock;
import com.stock.service.Interface.IMouvementStockService;

public class MouvementStockServiceImpl implements IMouvementStockService{
	
	private IMouvementStockDao dao;
	
	public void setDao(IMouvementStockDao dao) {
		this.dao = dao;
	}
	@Override
	public MouvementStock save(MouvementStock entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}
	@Override
	public MouvementStock update(MouvementStock entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}

	@Override
	public List<MouvementStock> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public List<MouvementStock> selectAll(String sortField, String sort) {
		// TODO Auto-generated method stub
		return dao.selectAll(sortField, sort);
	}

	@Override
	public MouvementStock getById(Long id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		dao.remove(id);
	}

	@Override
	public MouvementStock findOne(String paranName, Object paramValue) {
		// TODO Auto-generated method stub
		return dao.findOne(paranName, paramValue);
	}

	@Override
	public MouvementStock findOne(String[] paramNames, Object[] paramValues) {
		// TODO Auto-generated method stub
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return dao.findCountBy(paramName, paramValue);
	}

}
