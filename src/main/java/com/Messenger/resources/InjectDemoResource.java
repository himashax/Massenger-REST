package com.Messenger.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {

	@GET
	@Path("annotations")
	public String injectUsingAnnotations(@MatrixParam("param") String matrixParam,
										 @HeaderParam("customHeaderValue") String header,
										 @CookieParam("name") String cookie) {
		return "Matrix param; " + matrixParam + " Header Value " + header + " Cookie "+cookie;
	}
	
	//Suitable for authentication and logins of users
	//session id and value for header parameter
	
	
}
