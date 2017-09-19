package com.prestonb.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.prestonb.app.conf.WebConstants.Models;
import com.prestonb.app.conf.WebConstants.Redirects;
import com.prestonb.app.conf.WebConstants.RequestMappings;
import com.prestonb.app.conf.WebConstants.Views;
import com.prestonb.model.RadiusForm;
import com.prestonb.service.RadiusService;

@Controller
public class RadiusController {
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired private RadiusService radiusService;
	@Autowired private MessageSource msgSrc;

	@ModelAttribute(name = Models.MESSAGE_SOURCE)
	public MessageSource msgSourceBean() {
		return msgSrc;
	}
	
	@RequestMapping(value = RequestMappings.HOME)
	public String homePage(ModelMap model) {
		
		return Redirects.RADIUS;
	}

	@RequestMapping(value = RequestMappings.RADIUS, method = RequestMethod.GET)
	public String radiusPage(ModelMap model) {
		model.addAttribute(Models.COMMAND, new RadiusForm());
		
		return Views.RADIUS;
	}

	@RequestMapping(value = RequestMappings.RADIUS, method = RequestMethod.POST)
	public String radiusPagePost(ModelMap model, 
			@ModelAttribute(value = Models.COMMAND ) @Valid RadiusForm form, BindingResult errors) {
		
		if(errors.hasErrors())
			return Views.RADIUS;

		model.addAttribute(Models.AREA, radiusService.calculateArea(form.getRadius()));
		
		return Views.RADIUS;
	}
}
