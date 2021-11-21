package com.Messenger.database;

import java.util.HashMap;
import java.util.Map;

import com.Messenger.model.Message;
import com.Messenger.model.Profile;

public class Database {

	private static Map<Long, Message> messages = new HashMap<>();
	//key -> profile name , value -> profile instance
	private static Map<String, Profile> profiles = new HashMap<>();
	
	public static Map<Long, Message> getMessages(){
		return messages;
	}
	
	public static Map<String, Profile> getProfiles(){
		return profiles;
	}
}
