package com.stock.service.impl;

import java.util.List;

import com.stock.dao.Interface.IArticleDao;
import com.stock.entities.Article;
import com.stock.service.Interface.IArticleService;

public class ArticleServiceImpl implements IArticleService{
	
	private IArticleDao dao;
	
	public void setDao(IArticleDao dao) {
		this.dao = dao;
	}
	@Override
	public Article save(Article entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}
	@Override
	public Article update(Article entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}

	@Override
	public List<Article> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public List<Article> selectAll(String sortField, String sort) {
		// TODO Auto-generated method stub
		return dao.selectAll(sortField, sort);
	}

	@Override
	public Article getById(Long id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		dao.remove(id);
	}

	@Override
	public Article findOne(String paranName, Object paramValue) {
		// TODO Auto-generated method stub
		return dao.findOne(paranName, paramValue);
	}

	@Override
	public Article findOne(String[] paramNames, Object[] paramValues) {
		// TODO Auto-generated method stub
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return dao.findCountBy(paramName, paramValue);
	}

}
