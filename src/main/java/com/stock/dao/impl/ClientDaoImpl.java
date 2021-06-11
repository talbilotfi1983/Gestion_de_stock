package com.stock.dao.impl;

import org.springframework.stereotype.Service;

import com.stock.dao.Interface.IClientDao;
import com.stock.dao.generic.GenericDaoImpl;
import com.stock.entities.Client;
@Service
public class ClientDaoImpl  extends GenericDaoImpl<Client> implements IClientDao {



}
