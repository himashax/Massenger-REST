package com.Messenger.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.*;

import com.Messenger.model.Profile;
import com.Messenger.service.ProfileService;

@Path("/profiles")
public class ProfileResource {

	ProfileService profileService = new ProfileService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profile> listProfiles(){
		return profileService.getAllProfiles();
	}
}
