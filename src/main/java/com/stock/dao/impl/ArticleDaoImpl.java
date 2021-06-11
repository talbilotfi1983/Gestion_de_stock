package com.stock.dao.impl;

import org.springframework.stereotype.Service;

import com.stock.dao.Interface.IArticleDao;
import com.stock.dao.generic.GenericDaoImpl;
import com.stock.entities.Article;
@Service
public class ArticleDaoImpl  extends GenericDaoImpl<Article> implements IArticleDao {



}
