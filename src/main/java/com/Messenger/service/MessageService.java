package com.Messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.Messenger.database.Database;
import com.Messenger.exception.DataNotFoundException;
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
	
	
	public List<Message> getAllMessagesForYear(int year){
		List<Message> messagesForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for(Message msg : messages.values()) {
			cal.setTime(msg.getCreatedDate());
			if(cal.get(Calendar.YEAR) == year) {
				messagesForYear.add(msg);
			}
		}
		return messagesForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size){
		ArrayList<Message> list = new ArrayList<Message>(messages.values());
		if(start + size > list.size())
			return new ArrayList<Message>();
		return list.subList(start, size);
	}
	
	public Message getMessage(Long id) {
		Message msg = messages.get(id);
		
		if(msg == null) {
			throw new DataNotFoundException("Message for the "+id+" not found");
		}
		return msg;
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
