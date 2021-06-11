package com.stock.service.impl;

import java.util.List;
import com.stock.dao.Interface.ICommandeClientDao;
import com.stock.entities.CommandeClient;
import com.stock.service.Interface.ICommandeClientService;
public class CommandeClientServiceImpl implements ICommandeClientService{
	
	private ICommandeClientDao dao;
	
	public void setDao(ICommandeClientDao dao) {
		
		this.dao = dao;
	}
	@Override
	public CommandeClient save(CommandeClient entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}
	@Override
	public CommandeClient update(CommandeClient entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}

	@Override
	public List<CommandeClient> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public List<CommandeClient> selectAll(String sortField, String sort) {
		// TODO Auto-generated method stub
		return dao.selectAll(sortField, sort);
	}

	@Override
	public CommandeClient getById(Long id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		dao.remove(id);
	}

	@Override
	public CommandeClient findOne(String paranName, Object paramValue) {
		// TODO Auto-generated method stub
		return dao.findOne(paranName, paramValue);
	}

	@Override
	public CommandeClient findOne(String[] paramNames, Object[] paramValues) {
		// TODO Auto-generated method stub
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return dao.findCountBy(paramName, paramValue);
	}

}
