package com.stock.service.Interface;

import java.util.List;

import com.stock.entities.Utilisateur;

public interface IUtilisateurService {
	public Utilisateur save (Utilisateur entity);
	public Utilisateur update (Utilisateur entity);
	public List<Utilisateur> selectAll();
	public List<Utilisateur> selectAll(String sortField, String sort);
	public Utilisateur getById(Long id);
	public void remove(Long id);
	public Utilisateur findOne(String paranName, Object paramValue);
	public Utilisateur findOne(String[]paramNames, Object[]paramValues);
	public int findCountBy(String paramName,String paramValue);

}
