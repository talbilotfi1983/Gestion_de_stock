package com.stock.service.impl;

import java.io.InputStream;

import com.stock.dao.Interface.IFlickrDao;
import com.stock.service.Interface.IFlickrService;



public class FlickrServiceImpl implements IFlickrService{
	private IFlickrDao dao;

	@Override
	public String savePhoto(InputStream stream, String fileName) throws Exception {
		// TODO Auto-generated method stub
		return dao.savePhoto(stream, fileName);
	}

	public void setDao(IFlickrDao dao) {
		this.dao = dao;
	}

}
