package com.Messenger.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.Messenger.database.Database;
import com.Messenger.model.Message;
import com.Messenger.service.MessageService;

@Path("/messages")
public class MessageResource {

	MessageService msgService = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessage() {
		return msgService.getMessages();
	}
	
	@GET
	@Path("/{year}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessagesForYear(@PathParam("year") int year){
		return msgService.getAllMessagesForYear(year);
	}
	
	
	@GET
	@Path("/message/{messageId}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") long messageId) {
		return msgService.getMessage(messageId);
		
	}
	
	@DELETE
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message deleteMessage(@PathParam("messageId") long id) {
		return msgService.deleteMessage(id);
	}
	
}
