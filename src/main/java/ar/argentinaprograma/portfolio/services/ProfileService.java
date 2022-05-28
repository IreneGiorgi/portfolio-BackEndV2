package ar.argentinaprograma.portfolio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.argentinaprograma.portfolio.dtos.ProfileDto;
import ar.argentinaprograma.portfolio.models.Profile;
import ar.argentinaprograma.portfolio.repositories.ProfileRepository;

@Service
public class ProfileService {

	@Autowired
	private ProfileRepository proRepo;
	
	public List<ProfileDto> getAllProfiles() {
		
		List<ProfileDto> dtos = new ArrayList<>();
		
		for(Profile actProfile : proRepo.findAll()) {
			dtos.add(new ProfileDto(actProfile));
		}
		return dtos;
	}
	
	public Profile saveProfile() {
		return proRepo.saveAndFlush(new Profile());
	}

	public ProfileDto getProfileById(Long id) {
		
		Optional<Profile> profile = proRepo.findById(id);
		
		if (!profile.isPresent()) {
			throw new RuntimeException("Profile not found");
		}
		
		return new ProfileDto(profile.get());
	}
}
