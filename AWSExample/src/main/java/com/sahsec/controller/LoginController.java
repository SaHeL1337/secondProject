package com.sahsec.controller;


 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.json.simple.JSONObject;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.sahsec.service.Patch;
import com.sahsec.service.PatchHistory;
 
@Controller
public class LoginController {
	
	PatchHistory patchHistory;
 
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver multipartResolver() {
	    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
	    multipartResolver.setMaxUploadSize(100000);
	    return multipartResolver;
	}
	
	@RequestMapping("/")
	public ModelAndView loginPage() {
		String message = "";
		return new ModelAndView("login", "message", message);
	}
	
	@RequestMapping("/upload")
	public ModelAndView uploadPage() {
		
		return new ModelAndView("upload", "patchHistory", patchHistory);
	}
	
	@RequestMapping("/applyPatch/{id}")
	public ModelAndView applyPatch(@PathVariable("id") int id) {
		Patch l_patch = patchHistory.getPatchById(id);
		if(l_patch.getStatus()==Patch.PatchStatus.READY) {
			l_patch.applyPatch();
		}
		return new ModelAndView("redirect:/upload", "patchHistory", patchHistory);
	}
	
	@RequestMapping("/rollbackPatch/{id}")
	public ModelAndView rollbackPatch(@PathVariable("id") int id) {
		Patch l_patch = patchHistory.getPatchById(id);
		if(l_patch.getStatus()==Patch.PatchStatus.PATCHED) {
			l_patch.rollback();
		}
		return new ModelAndView("redirect:/upload", "patchHistory", patchHistory);
	}
	
	@RequestMapping(value = "/uploadPatch", method = RequestMethod.POST)
	public ModelAndView submit(@RequestParam("file") MultipartFile file,@RequestParam("patchName") String patchName, ModelMap modelMap) {
	    Patch p_patch = new Patch(patchName, file, patchHistory.getHistory().size());
	    
	    patchHistory.addPatchToHistory(p_patch);
	    
	    return new ModelAndView("redirect:/upload", "patchHistory", patchHistory);
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ModelAndView test2(String username, String password) {
		String message ="";

		if(username == null || !username.equals("admin")) {
			message = "Incorrect username or password";
			return new ModelAndView("login", "message", message);
		}else {
			message = "Thank you for loggin in @" + username + password;
			return new ModelAndView("upload", "message", message);
		}
		
	}
	
	@PostConstruct
	public void init() {
	   patchHistory = PatchHistory.getInstance();
	}
	
}