package com.stock.service.impl;

import java.util.List;
import com.stock.dao.Interface.ICommandeFournisseurDao;
import com.stock.entities.CommandeFournisseur;
import com.stock.service.Interface.ICommandeFournisseurService;
public class CommandeFournisseurServiceImpl implements ICommandeFournisseurService{
	
	private ICommandeFournisseurDao dao;
	
	public void setDao(ICommandeFournisseurDao dao) {
		this.dao = dao;
	}
	@Override
	public CommandeFournisseur save(CommandeFournisseur entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}
	@Override
	public CommandeFournisseur update(CommandeFournisseur entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}

	@Override
	public List<CommandeFournisseur> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public List<CommandeFournisseur> selectAll(String sortField, String sort) {
		// TODO Auto-generated method stub
		return dao.selectAll(sortField, sort);
	}

	@Override
	public CommandeFournisseur getById(Long id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		dao.remove(id);
	}

	@Override
	public CommandeFournisseur findOne(String paranName, Object paramValue) {
		// TODO Auto-generated method stub
		return dao.findOne(paranName, paramValue);
	}

	@Override
	public CommandeFournisseur findOne(String[] paramNames, Object[] paramValues) {
		// TODO Auto-generated method stub
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return dao.findCountBy(paramName, paramValue);
	}

}
