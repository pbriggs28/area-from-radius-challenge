package com.prestonb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RadiusController {
	private Logger log = LoggerFactory.getLogger(getClass());

	@RequestMapping("/radius")
	public String radiusPage(ModelMap model) {
		double radius = 2.33;
		double area = Math.PI * radius * radius;
		model.addAttribute("area", area);
		
		return "radius";
	}
}
