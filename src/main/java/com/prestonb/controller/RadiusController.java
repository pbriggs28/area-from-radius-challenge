package com.prestonb.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.prestonb.model.RadiusForm;
import com.prestonb.service.RadiusService;

@Controller
public class RadiusController {
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired private RadiusService radiusService;

	@RequestMapping(value = "/radius", method = RequestMethod.GET)
	public String radiusPage(ModelMap model) {
		model.addAttribute("command", new RadiusForm());
		
		return "radius";
	}

	@RequestMapping(value = "/radius", method = RequestMethod.POST)
	public String radiusPagePost(ModelMap model, @ModelAttribute("command") @Valid RadiusForm form,	BindingResult errors) {
		
		if(errors.hasErrors()) {
			model.addAttribute("error", errors.getFieldError().getDefaultMessage());
			return "radius";
		} else {
			model.addAttribute("area", radiusService.calculateArea(form.getRadius()));
		}
		
		return "radius";
	}
}
