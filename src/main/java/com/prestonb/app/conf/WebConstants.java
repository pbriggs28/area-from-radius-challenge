package com.prestonb.app.conf;

public class WebConstants {

	public static final class RequestMappings {
		public static final String HOME = "/";
		public static final String RADIUS = "/radius";		
	}

	public static final class Redirects {
		public static final String RADIUS = "redirect:" + RequestMappings.RADIUS;		
	}

	public static final class Views {
		public static final String RADIUS = "radius";		
	}
	

	public static final class Models {
		public static final String COMMAND = "command";
		public static final String AREA = "area";
		public static final String MESSAGE_SOURCE = "msgSrc";
	}
}
