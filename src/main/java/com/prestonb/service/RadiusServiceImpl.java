package com.prestonb.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class RadiusServiceImpl implements RadiusService {
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Override
	public double calculateArea(double radius) {
		Assert.notNull(radius, "radius cannot be null.");
		Assert.isTrue(radius > 0, "radius must be positive.");
		
		return Math.PI * radius * radius;
	}
}
