package com.stock.dao.impl;

import org.springframework.stereotype.Service;

import com.stock.dao.Interface.ICommandeClientDao;
import com.stock.dao.generic.GenericDaoImpl;
import com.stock.entities.CommandeClient;
@Service
public class CommandeClientDaoImpl  extends GenericDaoImpl<CommandeClient> implements ICommandeClientDao {



}
