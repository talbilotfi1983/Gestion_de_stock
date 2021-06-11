package com.stock.controlle;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/home")
public class HomeController {

	@GetMapping("")
	public String GetMapping(){
		
		return "home/home";
		
	}
	@GetMapping("/blank")
	public String BlankMapping(){
			
		return "blank/blank";
		
	}
	
	
}
