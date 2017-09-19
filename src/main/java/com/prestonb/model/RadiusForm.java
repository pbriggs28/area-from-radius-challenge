package com.prestonb.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class RadiusForm {

	@NotNull
	@Min(value = 1)
	@Max(value = 100)
	private Double radius;

	public Double getRadius() {
		return radius;
	}

	public void setRadius(Double radius) {
		this.radius = radius;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RadiusForm [radius=").append(radius).append("]");
		return builder.toString();
	}
	
}
