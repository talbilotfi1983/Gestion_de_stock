package com.stock.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.stock.dao.Interface.ILigneCommandeFournisseurDao;
import com.stock.dao.generic.GenericDaoImpl;
import com.stock.entities.LigneCommandeClient;
import com.stock.entities.LigneCommandeFournisseur;

@Service
public class LigneCommandeFournisseurDaoImpl extends GenericDaoImpl<LigneCommandeFournisseur> implements ILigneCommandeFournisseurDao {
	@SuppressWarnings("unchecked")
	@Override
	public List<LigneCommandeFournisseur> getByIdCommandes(Long id) {
		String queryString = "select lc from "+ 
	LigneCommandeClient.class.getSimpleName()+ 
	" lc where lc.commandeClient.id =:x";
		Query query  = em.createQuery(queryString);
		query.setParameter("x", id);
		return query.getResultList();
	}

}
