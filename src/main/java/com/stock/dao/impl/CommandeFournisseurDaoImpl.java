package com.stock.dao.impl;

import org.springframework.stereotype.Service;

import com.stock.dao.Interface.ICommandeFournisseurDao;
import com.stock.dao.generic.GenericDaoImpl;
import com.stock.entities.CommandeFournisseur;
@Service
public class CommandeFournisseurDaoImpl  extends GenericDaoImpl<CommandeFournisseur> implements ICommandeFournisseurDao{

}
