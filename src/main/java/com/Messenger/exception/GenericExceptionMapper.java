package com.Messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import com.Messenger.model.ErrorMessage;

public class GenericExceptionMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), "500", "http://localhost:8081/Messenger");
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(errorMessage).build();
	}

	 
	
}
