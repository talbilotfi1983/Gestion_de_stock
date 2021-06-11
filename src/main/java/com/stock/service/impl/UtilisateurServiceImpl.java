package com.stock.service.impl;

import java.util.List;

import com.stock.dao.Interface.IUtilisateurDao;
import com.stock.entities.Utilisateur;
import com.stock.service.Interface.IUtilisateurService;

public class UtilisateurServiceImpl implements IUtilisateurService{
	
	private IUtilisateurDao dao;
	
	public void setDao(IUtilisateurDao dao) {
		this.dao = dao;
	}
	@Override
	public Utilisateur save(Utilisateur entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}
	@Override
	public Utilisateur update(Utilisateur entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}

	@Override
	public List<Utilisateur> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public List<Utilisateur> selectAll(String sortField, String sort) {
		// TODO Auto-generated method stub
		return dao.selectAll(sortField, sort);
	}

	@Override
	public Utilisateur getById(Long id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		dao.remove(id);
	}

	@Override
	public Utilisateur findOne(String paranName, Object paramValue) {
		// TODO Auto-generated method stub
		return dao.findOne(paranName, paramValue);
	}

	@Override
	public Utilisateur findOne(String[] paramNames, Object[] paramValues) {
		// TODO Auto-generated method stub
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return dao.findCountBy(paramName, paramValue);
	}

}
