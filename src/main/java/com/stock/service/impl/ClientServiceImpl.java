package com.stock.service.impl;

import java.util.List;

import com.stock.dao.Interface.IClientDao;
import com.stock.entities.Client;
import com.stock.service.Interface.IClientService;

public class ClientServiceImpl implements IClientService{
	
	private IClientDao dao;
	
	public void setDao(IClientDao dao) {
		this.dao = dao;
	}
	@Override
	public Client save(Client entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}
	@Override
	public Client update(Client entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}

	@Override
	public List<Client> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public List<Client> selectAll(String sortField, String sort) {
		// TODO Auto-generated method stub
		return dao.selectAll(sortField, sort);
	}

	@Override
	public Client getById(Long id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		dao.remove(id);
	}

	@Override
	public Client findOne(String paranName, Object paramValue) {
		// TODO Auto-generated method stub
		return dao.findOne(paranName, paramValue);
	}

	@Override
	public Client findOne(String[] paramNames, Object[] paramValues) {
		// TODO Auto-generated method stub
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return dao.findCountBy(paramName, paramValue);
	}

}
