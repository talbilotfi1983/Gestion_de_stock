package com.stock.dao.impl;

import org.springframework.stereotype.Service;

import com.stock.dao.Interface.ICategoryDao;
import com.stock.dao.generic.GenericDaoImpl;
import com.stock.entities.Category;
@Service
public class CategoryDaoImpl  extends GenericDaoImpl<Category> implements ICategoryDao {



}
