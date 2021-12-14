package com.Messenger.resources;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.Messenger.database.Database;
import com.Messenger.model.Message;
import com.Messenger.resources.bean.MessageFilterBean;
import com.Messenger.service.MessageService;

@Path("/messages")
public class MessageResource {

	MessageService msgService = new MessageService();
	
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<Message> getMessage(@QueryParam("year") int year, 
//									@QueryParam("start") int start, 
//									@QueryParam("end") int size) {
//		if(year > 0) {
//			return msgService.getAllMessagesForYear(year);
//		}
//		if(start >= 0 && size >= 0) {
//			return msgService.getAllMessagesPaginated(start, size);
//		}
//		return msgService.getMessages();
//	}
	
	//There are so many parameters in the method. So, can use a bean parameter indicating all the parameters we need
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessage(@BeanParam MessageFilterBean filterBean) {
		if(filterBean.getYear() > 0) {
			return msgService.getAllMessagesForYear(filterBean.getYear());
		}
		if(filterBean.getStart() >= 0 && filterBean.getSize() >= 0) {
			return msgService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
		}
		return msgService.getMessages();
	}
	
	@GET
	@Path("/message/{messageId}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") long messageId, @Context UriInfo uriInfo) {
		Message message = msgService.getMessage(messageId);	
		message.addLink(getUriForSelf(uriInfo, message), "self");
		return message;
	}

	private String getUriForSelf(UriInfo uriInfo, Message message) {
		//contains the complete uri
		String uri = uriInfo.getBaseUriBuilder()
		.path(MessageResource.class)
		.path(Long.toString(message.getId()))
		.build()
		.toString();
		return uri;
	}
	
	@DELETE
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message deleteMessage(@PathParam("messageId") long id) {
		return msgService.deleteMessage(id);
	}
	
	//A method that is going to look for the comment resource and returns the resource with the methods
	//inside of it
	@Path("/{messageId}/`")
	public CommentResource getCommentResourceInstance() {
		return new CommentResource();
	}
	
}
