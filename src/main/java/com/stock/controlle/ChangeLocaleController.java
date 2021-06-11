package com.stock.controlle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stock.utils.ApplicationUtils;

@Controller
@RequestMapping("/changeLocale")
public class ChangeLocaleController {
	private static final String REFERER = "referer";

	@RequestMapping("/{locale}")
	public String changeLocale(HttpServletRequest req, HttpServletResponse resp,
			@PathVariable(name = "locale") String locale) {
		if (!StringUtils.isEmpty(locale)) {
			ApplicationUtils.changeLocale(req, resp, locale);
		}
		String lastUrl = req.getHeader(REFERER);
		if (!StringUtils.isEmpty(lastUrl)) {
			return "redirect:"+lastUrl;
		}
		return "redirect:/home";
	}

}
