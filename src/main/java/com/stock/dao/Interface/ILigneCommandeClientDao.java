package com.stock.dao.Interface;

import java.util.List;

import com.stock.dao.generic.IGenericDaoInterface;
import com.stock.entities.LigneCommandeClient;

public interface ILigneCommandeClientDao extends IGenericDaoInterface<LigneCommandeClient>{
	public List<LigneCommandeClient> getByIdCommandes(Long id);
}
