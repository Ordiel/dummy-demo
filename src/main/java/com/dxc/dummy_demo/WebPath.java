package com.dxc.dummy_demo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.ext.Provider;

@Path("/wpr")
@Provider
public class WebPath {

	@GET
	public String sayHtmlHello() {
		return "<html> "
		        + "<title>"
		        + "Hello Jersey"
		        + "</title>"
		        + "<body><h1>"
		        + "Hello Jersey"
		        + "</body></h1>"
		        + "</html> ";
	}
}
