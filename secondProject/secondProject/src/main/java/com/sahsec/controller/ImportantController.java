package com.sahsec.controller;


 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class ImportantController {
 
	@RequestMapping("/test")
	public ModelAndView someFunction(String username) {
 
		String message = "I greet you too " + username;
		return new ModelAndView("test", "message", message);
	}
} 