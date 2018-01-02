package com.dxc.dummy_demo;

import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
public class ApplicationConfig
        extends
        Application {

	@Override
	public Set<Class<?>> getClasses() {
		return getRestResourceClasses();
	}

	private Set<Class<?>> getRestResourceClasses() {
		System.out.println("REST configuration starting: getClasses()"); 
		Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
		resources.add(WebPath.class);
		return resources;
	}
}