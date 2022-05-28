package ar.argentinaprograma.portfolio.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.argentinaprograma.portfolio.dtos.AuthDto;
import ar.argentinaprograma.portfolio.dtos.ProfileDto;
import ar.argentinaprograma.portfolio.dtos.UserDto;
import ar.argentinaprograma.portfolio.models.Profile;
import ar.argentinaprograma.portfolio.services.ProfileService;
import ar.argentinaprograma.portfolio.services.UserService;

@RestController
@RequestMapping("/api/v1")
public class ProfileController {

	private final Logger log = LoggerFactory.getLogger(ProfileController.class);


	private ProfileService pService;
	private UserService uService;
	
	@Autowired
	public ProfileController(ProfileService pService, UserService uService) {
		this.pService = pService;
		this.uService = uService;
	}
	
	
	@GetMapping ("/profile/")
	public List<ProfileDto> getProfiles() {
		return pService.getAllProfiles();
	}
	
	
	@GetMapping ("/profile/{id}")
	public ProfileDto getProfileById(@PathVariable Long id) {
		log.info("Received request profile for id: {}", id);
		return pService.getProfileById(id);
	}
	
	@PutMapping ("/profile/**")
	public ProfileDto updateProfile(
			@RequestHeader("Authorization") String jwtToken, 
			@RequestBody ProfileDto dto
			) {
		
		uService.validateToken(jwtToken);
		
		return new ProfileDto(pService.saveProfile(dto));
	}
		
}
