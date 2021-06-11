package com.stock.service.Interface;

import java.io.InputStream;

public interface IFlickrService {
	public String savePhoto(InputStream stream,String fileName) throws Exception;
}
