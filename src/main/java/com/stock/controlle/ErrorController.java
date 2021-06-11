package com.stock.controlle;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/403")
public class ErrorController {
	private static final String REFERER = "referer";
	@GetMapping("")
	public String error(Model model,HttpServletRequest req) {
		String lastUrl = req.getHeader(REFERER);
		if(!StringUtils.isEmpty(lastUrl)) {
			model.addAttribute("backUrl", lastUrl);
		}
		return "errors/403";
	}

}