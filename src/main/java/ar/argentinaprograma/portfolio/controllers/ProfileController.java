package ar.argentinaprograma.portfolio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.argentinaprograma.portfolio.dtos.ProfileDto;
import ar.argentinaprograma.portfolio.models.Profile;
import ar.argentinaprograma.portfolio.services.ProfileService;

@RestController
@RequestMapping("/api/v1")
public class ProfileController {


	private ProfileService pService;
	
	
	@Autowired
	public ProfileController(ProfileService pService) {
		this.pService = pService;
	}
	

	

	
	@GetMapping ("/profile/")
	public List<ProfileDto> getProfiles() {
		return pService.getAllProfiles();
	}
	
	
	@GetMapping ("/profile/{id}")
	public ProfileDto getProfileById(@PathVariable Long id) {
		return pService.getProfileById(id);
	}
	
	@GetMapping ("/profile/add")
	public Profile insertNewProfile() {
		return pService.saveProfile();
	}
	
}
