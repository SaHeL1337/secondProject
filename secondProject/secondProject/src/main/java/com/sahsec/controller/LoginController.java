package com.sahsec.controller;


 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class LoginController {
 
	@RequestMapping("/somespecific")
	public ModelAndView loginPage() {
		String message = "";
		return new ModelAndView("login", "message", message);
	}
	
	@RequestMapping("/home")
	public ModelAndView homePage() {
		String message = "";
		
		List<String> allTiles = new ArrayList<>();
		
		for(int i = 0; i < 5; i++) {
			allTiles.add(String.valueOf(i));
		}
		
		return new ModelAndView("home", "allTiles", allTiles);
	}
	
	@RequestMapping("/upload")
	public ModelAndView uploadPage() {
		
		return new ModelAndView("upload", "", null);
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ModelAndView test2(String username, String password) {
		String message ="";

		if(username == null || !username.equals("adolf")) {
			message = "Incorrect username or password";
			return new ModelAndView("login", "message", message);
		}else {
			message = "Thank you for loggin in @" + username + password;
			return new ModelAndView("upload", "message", message);
		}
		
	}
	
	@RequestMapping(value="/getMap", method = RequestMethod.GET)
	public @ResponseBody String getMap(String posX, String posY) {
		
		JSONObject data = new JSONObject();
		HashMap<String, Integer> tile;
		int id = 0;
		
		for(int i = -24; Math.abs(i) < 35; i++) {
			for(int k = -24; Math.abs(k) < 25; k++) {
				Random rand = new Random();
				tile = new HashMap<String, Integer>();
				tile.put("type", rand.nextInt(2));
				tile.put("posX", i + Integer.valueOf(posX));
				tile.put("posY", k + Integer.valueOf(posY));
				data.put(id, tile);
				id++;
			}
		}
		
		System.out.println("loading map data");
		return data.toJSONString();

	} 

	
	
}