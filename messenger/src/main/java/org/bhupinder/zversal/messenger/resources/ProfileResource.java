package org.bhupinder.zversal.messenger.resources;


	

	import java.util.List;

	import javax.ws.rs.Consumes;
	import javax.ws.rs.DELETE;
	import javax.ws.rs.GET;
	import javax.ws.rs.POST;
	import javax.ws.rs.PUT;
	import javax.ws.rs.Path;
	import javax.ws.rs.PathParam;
	import javax.ws.rs.Produces;
	import javax.ws.rs.core.MediaType;

import org.bhupinder.zversal.messenger.model.Profile;
import org.bhupinder.zversal.messenger.service.ProfileService;
    @Path("profiles")
	public class ProfileResource {
		

	    ProfileService profileservice = new ProfileService();
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public List<Profile> myprofile() {
			return profileservice.getAllProfiles();
		}
	    
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public Profile addprofiles(Profile profile) {
		      return profileservice.addProfiles(profile);
			  
		}
		
		@PUT
		@Path("/{profilename}")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public Profile updateProfiles(@PathParam("profilename") String Profilename ,Profile profile) {
			profile.setProfilename(Profilename);
			return profileservice.updateProfile(profile);
		}
		
		
		@Path("/{profilename}")
		@DELETE
		@Produces(MediaType.APPLICATION_JSON)
		public String delprofile(@PathParam("profilename") String Profilename) {
			return "Given Data is deleted"+ profileservice.removeprofile(Profilename);
		}

		
		
		
		@Path("/{profilename}")
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		
		public Profile removeprofile(@PathParam("profilename") String Profilename) {
			return profileservice.getprofile(Profilename);
		}

	}




