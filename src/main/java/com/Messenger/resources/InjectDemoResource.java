package com.Messenger.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {

	//Suitable for authentication and logins of users
	//session id and value for header parameter
	@GET
	@Path("annotations")
	public String injectUsingAnnotations(@MatrixParam("param") String matrixParam,
										 @HeaderParam("customHeaderValue") String header,
										 @CookieParam("name") String cookie) {
		return "Matrix param; " + matrixParam + " Header Value " + header + " Cookie "+cookie;
	}
	
	//context -> uri info, http headers
	//UriInfo - needs uri info to be injected  
	//uriInfo.getQueryParameters() - when you don't know which query param to access. loop through the map
	//HTTP header gives the information of the headers/http
	@GET
	@Path("context")
	public String getParamUsingContext(@Context UriInfo uriInfo,
									   @Context HttpHeaders httpHeaders) {
		String path = uriInfo.getAbsolutePath().toString();
		String cookies = httpHeaders.getCookies().toString();
		return "Path is : " + path+ " Cookies: " + cookies;
	}
}
