package com.stock.dao.Interface;

import java.io.InputStream;

public interface IFlickrDao {
	public String savePhoto(InputStream stream,String fileName) throws Exception;

}
