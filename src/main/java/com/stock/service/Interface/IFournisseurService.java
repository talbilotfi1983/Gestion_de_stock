package com.stock.service.Interface;

import java.util.List;

import com.stock.entities.Fournisseur;

public interface IFournisseurService {
	public Fournisseur save (Fournisseur entity);
	public Fournisseur update (Fournisseur entity);
	public List<Fournisseur> selectAll();
	public List<Fournisseur> selectAll(String sortField, String sort);
	public Fournisseur getById(Long id);
	public void remove(Long id);
	public Fournisseur findOne(String paranName, Object paramValue);
	public Fournisseur findOne(String[]paramNames, Object[]paramValues);
	public int findCountBy(String paramName,String paramValue);

}
