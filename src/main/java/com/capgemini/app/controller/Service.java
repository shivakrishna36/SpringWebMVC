package com.capgemini.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Service {

	@RequestMapping("/")
	public String home()
	{
		return "index";
	}
	
	@RequestMapping("/savings")
	public String savingsMenu()
	{
		return "home";
	}
	
	@RequestMapping("/current")
	public String currentMenu()
	{
		return "currentMenu";
	}
}
