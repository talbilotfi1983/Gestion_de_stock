package com.stock.controlle;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LoginController{

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login(Model model, Locale locale) {
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(new Date());
		model.addAttribute("serverTime", formattedDate);
		
		return "login/login";
		}
	@GetMapping("/failedLogin")
	public String failedLogin(Model model) {
		return "errors/403";
		}

}