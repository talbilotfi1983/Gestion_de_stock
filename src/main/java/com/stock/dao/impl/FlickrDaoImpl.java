package com.stock.dao.impl;
import java.io.InputStream;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.AuthInterface;
import com.flickr4java.flickr.auth.Permission;
import com.flickr4java.flickr.uploader.UploadMetaData;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.model.OAuth1Token;

import com.stock.dao.Interface.IFlickrDao;



@Service

public class FlickrDaoImpl implements IFlickrDao {
private Flickr flickr;
private UploadMetaData uploadMetaData =new UploadMetaData();
private String apiKey="10544f338d03d2aa2f63dbadac95057b";
private String sharedSecret="3e0a2e86116291cf";

private void connect() {
	
	flickr = new Flickr(apiKey,sharedSecret,new REST());
	Auth auth = new Auth();
	auth.setPermission(Permission.READ);
	//https://www.flickr.com/services/apps/create/noncommercial/?
	auth.setToken("72157714246709538-416559924bcb0250");
	auth.setTokenSecret("722e68d2ae7984ab");
	RequestContext requestContext = RequestContext.getRequestContext();
	requestContext.setAuth(auth);
	flickr.setAuth(auth);
			
			
}
	@Override
	public String savePhoto(InputStream photo, String title){
		// TODO Auto-generated method stub
		
		connect();
		uploadMetaData.setTitle(title);
		String photoId;
		try {
			photoId = flickr.getUploader().upload(photo,uploadMetaData);
			return flickr.getPhotosInterface().getPhoto(photoId).getMedium640Url();
		} catch (FlickrException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public void auth() {
		
		flickr = new Flickr(apiKey,sharedSecret,new REST());
		System.out.println("ok1");
		AuthInterface authenInterface = flickr.getAuthInterface();
		Scanner scanner = new Scanner(System.in);
		OAuth1RequestToken requestToken = authenInterface.getRequestToken();
		System.out.println("token : " +requestToken);
		String url = authenInterface.getAuthorizationUrl(requestToken, Permission.DELETE);
		
		System.out.println("url : " +url);
		
		System.out.println("Ok >> : ");

		String tokenKey = scanner.nextLine();
        scanner.close();
        OAuth1Token  reqToken = authenInterface.getAccessToken(requestToken, tokenKey);
		System.out.println("Auth Success");
		Auth auth = null;
		try {
			auth =authenInterface.checkToken(reqToken);
			
		}catch (FlickrException e){
			e.printStackTrace();
			
		}
			
		System.out.println("token: "+reqToken.getToken());
		System.out.println("Secret: "+reqToken.getTokenSecret());
		System.out.println("nsid: "+auth.getUser().getId());
		System.out.println("RealName: "+auth.getUser().getRealName());
		System.out.println("UserName: "+auth.getUser().getUsername());
		System.out.println("Permission: "+auth.getPermission().getType());
		
		
	}

}
