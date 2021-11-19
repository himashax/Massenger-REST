package com.Messenger.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.Messenger.database.Database;
import com.Messenger.model.Message;
import com.Messenger.service.MessageService;

@Path("/messages")
public class MessageResource {

	MessageService msgService = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessage() {
		return msgService.getMessages();
	}
	
}
