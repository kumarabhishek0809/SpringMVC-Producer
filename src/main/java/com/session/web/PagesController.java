package com.session.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
@RequestMapping("/perfix")
public class PagesController {
	
	@RequestMapping(value = "/login/", method = RequestMethod.GET)
	public String checkSession(Map<String, Object> model,HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		System.out.println(session.getAttribute("SESSION"));
		return "index";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Map<String, Object> model,HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		session.setAttribute("SESSION", "VALUE");
		
		return "index";
	}
	
	
	@RequestMapping(value="/sign_in", method = RequestMethod.GET)
	public String getSignIn(@RequestParam(value="user")String user ,
	                        @RequestParam(value="pass")String password,
	                        Model model) {
		
		model.addAttribute("Test", "TestModal");
	    return "";
	}

}
