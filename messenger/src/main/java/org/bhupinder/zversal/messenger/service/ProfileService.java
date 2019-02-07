package org.bhupinder.zversal.messenger.service;


	
	

	import java.util.ArrayList;
	import java.util.List;
	import java.util.Map;

import org.bhupinder.zversal.messenger.database.DatabaseClass;
import org.bhupinder.zversal.messenger.model.Profile;

	public class ProfileService {

	private Map<String, Profile> profiles= DatabaseClass.getProfiles();
		
		public ProfileService() {
			profiles.put("Bhupi",new Profile(1L,"Bhupi","Bhupinder","Singh"));
			profiles.put("Bhupi2",new Profile(2L,"Bhupi2","Navi","Singh")  );
		}
		public List<Profile> getAllProfiles(){
			return new ArrayList<Profile>(profiles.values());
		}

		public Profile getprofile(String profilename) {
			return profiles.get(profilename);
		}
		public Profile addProfiles(Profile profile) {
			profile.setId(profiles.size() + 1);
			profiles.put( profile.getProfilename(),profile);
			return profile;
		}
		public Profile updateProfile(Profile profile) {
			if(profile.getProfilename().isEmpty()) {
				return null;
				
			}
			profiles.put(profile.getProfilename(), profile);
			return profile;
		}
		public Profile removeprofile(String profilename) {
			return profiles.remove(profilename);
		}
		
	}



