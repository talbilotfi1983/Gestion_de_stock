package com.stock.dao.generic;

import java.util.List;

public interface IGenericDaoInterface<E> {
	public E save(E entity);
	public E update (E entity);
	public List selectAll();
	public List<E> selectAll(String sortField, String sort);
	public E getById(Long id);
	public void remove(Long id);
	public E findOne(String paranName, Object paramValue);
	public E findOne(String[]paramNames, Object[]paramValues);
	public int findCountBy(String paramName,String paramValue);
	

}
