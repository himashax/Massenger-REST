package com.Messenger.service;

import java.util.ArrayList;
import java.util.List;

import com.Messenger.model.Message;

public class MessageService {
	
	public List<Message> getAllMessages(){
		
		Message m1 = new Message(1L, "Hello World", "Himasha");
		Message m2 = new Message(2L, "Hello REST", "Lochana");
		Message m3 = new Message(3L, "Hello Jersey", "Mandakini");
		
		List<Message> list = new ArrayList<Message>();
		list.add(m1);
		list.add(m2);
		list.add(m3);
		
		return list;
		
	}

}
