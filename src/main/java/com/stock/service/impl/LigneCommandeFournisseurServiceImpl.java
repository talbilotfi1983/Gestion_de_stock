package com.stock.service.impl;

import java.util.List;

import com.stock.dao.Interface.ILigneCommandeFournisseurDao;
import com.stock.entities.LigneCommandeFournisseur;
import com.stock.service.Interface.ILigneCommandeFournisseurService;
public class LigneCommandeFournisseurServiceImpl implements ILigneCommandeFournisseurService{
	
	private ILigneCommandeFournisseurDao dao;
	
	public void setDao(ILigneCommandeFournisseurDao dao) {
		this.dao = dao;
	}
	@Override
	public LigneCommandeFournisseur save(LigneCommandeFournisseur entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}
	@Override
	public LigneCommandeFournisseur update(LigneCommandeFournisseur entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}

	@Override
	public List<LigneCommandeFournisseur> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public List<LigneCommandeFournisseur> selectAll(String sortField, String sort) {
		// TODO Auto-generated method stub
		return dao.selectAll(sortField, sort);
	}

	@Override
	public LigneCommandeFournisseur getById(Long id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		dao.remove(id);
	}

	@Override
	public LigneCommandeFournisseur findOne(String paranName, Object paramValue) {
		// TODO Auto-generated method stub
		return dao.findOne(paranName, paramValue);
	}

	@Override
	public LigneCommandeFournisseur findOne(String[] paramNames, Object[] paramValues) {
		// TODO Auto-generated method stub
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return dao.findCountBy(paramName, paramValue);
	}
	@Override
	public List<LigneCommandeFournisseur> getByIdCommandes(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


}
