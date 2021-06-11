package com.stock.service.impl;

import java.util.List;

import com.stock.dao.Interface.IRoleDao;
import com.stock.entities.Role;
import com.stock.service.Interface.IRolesService;

public class RoleServiceImpl implements IRolesService{
	
	private IRoleDao dao;
	
	public void setDao(IRoleDao dao) {
		this.dao = dao;
	}
	@Override
	public Role save(Role entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}
	@Override
	public Role update(Role entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}

	@Override
	public List<Role> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public List<Role> selectAll(String sortField, String sort) {
		// TODO Auto-generated method stub
		return dao.selectAll(sortField, sort);
	}

	@Override
	public Role getById(Long id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		dao.remove(id);
	}

	@Override
	public Role findOne(String paranName, Object paramValue) {
		// TODO Auto-generated method stub
		return dao.findOne(paranName, paramValue);
	}

	@Override
	public Role findOne(String[] paramNames, Object[] paramValues) {
		// TODO Auto-generated method stub
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return dao.findCountBy(paramName, paramValue);
	}

}
