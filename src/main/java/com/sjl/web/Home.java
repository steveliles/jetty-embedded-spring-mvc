package com.sjl.web;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
public class Home {

	@RequestMapping("/")
	public ModelAndView home()
	{
		return new ModelAndView("index");
	}
	
}
