package com.stock.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Service;
import com.stock.dao.Interface.ILigneCommandeClientDao;
import com.stock.dao.generic.GenericDaoImpl;
import com.stock.entities.LigneCommandeClient;

@Service
public class LigneCommandeClientDaoImpl extends GenericDaoImpl<LigneCommandeClient> implements ILigneCommandeClientDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<LigneCommandeClient> getByIdCommandes(Long id) {
		String queryString = "select lc from "+ 
	LigneCommandeClient.class.getSimpleName()+ 
	" lc where lc.commandeClient.id =:x";
		
	System.out.println(queryString);
		Query query  = em.createQuery(queryString);
		query.setParameter("x", id);
		List<LigneCommandeClient> lc = query.getResultList();
		
		lc.forEach(System.out::println);
		return lc;
	}

}
