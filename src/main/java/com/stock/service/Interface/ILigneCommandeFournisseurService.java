package com.stock.service.Interface;

import java.util.List;

import com.stock.entities.LigneCommandeFournisseur;

public interface ILigneCommandeFournisseurService {
	public LigneCommandeFournisseur save (LigneCommandeFournisseur entity);
	public LigneCommandeFournisseur update (LigneCommandeFournisseur entity);
	public List<LigneCommandeFournisseur> selectAll();
	public List<LigneCommandeFournisseur> selectAll(String sortField, String sort);
	public LigneCommandeFournisseur getById(Long id);
	public void remove(Long id);
	public LigneCommandeFournisseur findOne(String paranName, Object paramValue);
	public LigneCommandeFournisseur findOne(String[]paramNames, Object[]paramValues);
	public int findCountBy(String paramName,String paramValue);
	public List<LigneCommandeFournisseur> getByIdCommandes(Long id);

}
