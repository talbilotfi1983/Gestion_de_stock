package com.stock.service.Interface;

import java.util.List;

import com.stock.entities.CommandeFournisseur;

public interface ICommandeFournisseurService {
	public CommandeFournisseur save (CommandeFournisseur entity);
	public CommandeFournisseur update (CommandeFournisseur entity);
	public List<CommandeFournisseur> selectAll();
	public List<CommandeFournisseur> selectAll(String sortField, String sort);
	public CommandeFournisseur getById(Long id);
	public void remove(Long id);
	public CommandeFournisseur findOne(String paranName, Object paramValue);
	public CommandeFournisseur findOne(String[]paramNames, Object[]paramValues);
	public int findCountBy(String paramName,String paramValue);

}