package com.sahsec.controller;


 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class HelloWorldController {
 
	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {
 
		String message = "Please insert your credentials";
		return new ModelAndView("welcome", "message", message);
	}
	
	@RequestMapping("test2")
	public ModelAndView test2() {
		return new ModelAndView("test2", "message", null);
	}
}