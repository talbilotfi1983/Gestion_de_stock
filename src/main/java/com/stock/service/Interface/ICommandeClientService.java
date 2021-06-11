package com.stock.service.Interface;

import java.util.List;

import com.stock.entities.CommandeClient;

public interface ICommandeClientService {
	public CommandeClient save (CommandeClient entity);
	public CommandeClient update (CommandeClient entity);
	public List<CommandeClient> selectAll();
	public List<CommandeClient> selectAll(String sortField, String sort);
	public CommandeClient getById(Long id);
	public void remove(Long id);
	public CommandeClient findOne(String paranName, Object paramValue);
	public CommandeClient findOne(String[]paramNames, Object[]paramValues);
	public int findCountBy(String paramName,String paramValue);

}
