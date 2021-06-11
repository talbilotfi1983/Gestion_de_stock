package com.stock.dao.Interface;

import java.util.List;

import com.stock.dao.generic.IGenericDaoInterface;
import com.stock.entities.LigneCommandeClient;
import com.stock.entities.LigneCommandeFournisseur;

public interface ILigneCommandeFournisseurDao extends IGenericDaoInterface<LigneCommandeFournisseur>{

	public List<LigneCommandeFournisseur> getByIdCommandes(Long id);
}
