package com.stock.service.impl;

import java.util.List;

import com.stock.dao.Interface.ICategoryDao;
import com.stock.entities.Category;
import com.stock.service.Interface.ICategoryService;
public class CategoryServiceImpl implements ICategoryService{

	private ICategoryDao dao;
	
	public void setDao(ICategoryDao dao) {
		this.dao = dao;
	}
	@Override
	public Category save(Category entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}
	@Override
	public Category update(Category entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}

	@Override
	public List<Category> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public List<Category> selectAll(String sortField, String sort) {
		// TODO Auto-generated method stub
		return dao.selectAll(sortField, sort);
	}

	@Override
	public Category getById(Long id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		dao.remove(id);
	}

	@Override
	public Category findOne(String paranName, Object paramValue) {
		// TODO Auto-generated method stub
		return dao.findOne(paranName, paramValue);
	}

	@Override
	public Category findOne(String[] paramNames, Object[] paramValues) {
		// TODO Auto-generated method stub
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return dao.findCountBy(paramName, paramValue);
	}
}
