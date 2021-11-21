package com.Messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.Messenger.database.Database;
import com.Messenger.model.Profile;

public class ProfileService {
	
	private Map<String, Profile> profiles = Database.getProfiles();
	
	public ProfileService() {
		profiles.put("Himasha.M", new Profile(1, "Himasha.M", "Himasha", "Mandakini"));
	}
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String name) {
		return profiles.get(name);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if(profile.getProfileName().isEmpty()) {
			return null;
		}else {
			profiles.put(profile.getProfileName(), profile);
			return profile;
		}
	}
	
	public Profile deleteProfile(String name) {
		return profiles.remove(name);
	}
	
	

}
