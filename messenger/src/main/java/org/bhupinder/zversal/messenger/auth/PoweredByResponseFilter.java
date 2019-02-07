package org.bhupinder.zversal.messenger.auth;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public  class PoweredByResponseFilter implements ContainerResponseFilter {
	
	public void filter(ContainerResponseContext responseContext, ContainerRequestFilter requestContext) throws IOException{
		
	}

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		// TODO Auto-generated method stub
		responseContext.getHeaders().add("X-powered by","Bhupinder");
	}

}
