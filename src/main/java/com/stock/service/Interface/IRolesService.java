package com.stock.service.Interface;

import java.util.List;

import com.stock.entities.Role;

public interface IRolesService {
	public Role save (Role entity);
	public Role update (Role entity);
	public List<Role> selectAll();
	public List<Role> selectAll(String sortField, String sort);
	public Role getById(Long id);
	public void remove(Long id);
	public Role findOne(String paranName, Object paramValue);
	public Role findOne(String[]paramNames, Object[]paramValues);
	public int findCountBy(String paramName,String paramValue);

}
