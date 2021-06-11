package com.stock.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

public class ApplicationUtils {
	private ApplicationUtils() {}
	public static void changeLocale(HttpServletRequest req, HttpServletResponse resp, String locale) {
		LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(req);
		localeResolver.setLocale(req, resp, StringUtils.parseLocaleString(locale));
		
	}
}
