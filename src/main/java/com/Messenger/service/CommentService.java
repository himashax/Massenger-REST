package com.Messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.Messenger.database.Database;
import com.Messenger.model.Comment;
import com.Messenger.model.Message;

public class CommentService {

	private Map<Long, Message> messages = Database.getMessages();
	
	public List<Comment> getAllComments(long messageId){
		Map<Long,Comment> comments = messages.get(messageId).getComments();
		return new ArrayList<Comment>(comments.values());
	}
	
	public Comment getComment(long messageId, long commentId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.get(commentId);
	}
	
	public Comment addComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		comment.setId(comments.size() + 1);
		return comments.put(comment.getId(), comment);
	}
	
}
