package com.prestonb.model;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class RadiusForm {

	@NotNull(message = "Radius must be provided")
	@Min(value = 1, message = "Radius must be between 1 and 100")
	@DecimalMax(value = "100.00", message = "Radius must be between 1 and 100")
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
