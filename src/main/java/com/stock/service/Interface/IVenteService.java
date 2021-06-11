package com.stock.service.Interface;

import java.util.List;

import com.stock.entities.Vente;

public interface IVenteService {
	public Vente save (Vente entity);
	public Vente update (Vente entity);
	public List<Vente> selectAll();
	public List<Vente> selectAll(String sortField, String sort);
	public Vente getById(Long id);
	public void remove(Long id);
	public Vente findOne(String paranName, Object paramValue);
	public Vente findOne(String[]paramNames, Object[]paramValues);
	public int findCountBy(String paramName,String paramValue);

}
