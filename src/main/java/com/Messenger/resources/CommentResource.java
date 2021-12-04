package com.Messenger.resources;

import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.Messenger.database.Database;
import com.Messenger.model.Message;

@Path("/")
//Sub resource of the Parent Resource of Messenger
public class CommentResource {

	private Map<Long, Message> messages = Database.getMessages();
	
	
	//access messageId parameter, which is in the parent resource
	@GET
	@Path("/{commentId}")
	public String getComment(@PathParam("messageId") Long messageId,
							 @PathParam("commentId") Long commentId) {
		return "comment id: " + commentId+ " Message Id : "+ messageId;
	}
	
	

	
}
