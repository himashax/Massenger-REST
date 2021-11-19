package com.Messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.Messenger.database.Database;
import com.Messenger.model.Message;

public class MessageService {
	
private Map<Long, Message> messages = Database.getMessages();
	

	public MessageService() {
		Message m1 = new Message(1L, "Hello World", "Himasha");
		Message m2 = new Message(2L, "Hello REST", "Lochana");
		Message m3 = new Message(3L, "Hello Jersey", "Mandakini");
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
