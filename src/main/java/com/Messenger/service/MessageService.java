package com.Messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.Messenger.database.Database;
import com.Messenger.model.Message;

public class MessageService {
	
private Map<Long, Message> messages = Database.getMessages();
	

	public MessageService() {
		messages.put(1L, new Message(1, "Hello World!", "Himasha"));
		messages.put(2L, new Message(2, "Hello Rest!", "Mandakini"));
	}

	public List<Message> getMessages(){
		return new ArrayList<Message>(messages.values());
	}
	
	public Message getMessage(Long id) {
		return messages.get(id);
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	
	public Message updateMessage(Message message) {
		if(message.getId() <= 0) {
			return null;
		}else {
			messages.put(message.getId(), message);
			return message;
		}
	}
	
	public Message deleteMessage(long id) {
		return messages.remove(id);
	}
	
	 

}
