package com.stock.service.Interface;

import java.util.List;

import com.stock.entities.MouvementStock;

public interface IMouvementStockService {
	public MouvementStock save (MouvementStock entity);
	public MouvementStock update (MouvementStock entity);
	public List<MouvementStock> selectAll();
	public List<MouvementStock> selectAll(String sortField, String sort);
	public MouvementStock getById(Long id);
	public void remove(Long id);
	public MouvementStock findOne(String paranName, Object paramValue);
	public MouvementStock findOne(String[]paramNames, Object[]paramValues);
	public int findCountBy(String paramName,String paramValue);

}
