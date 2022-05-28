package ar.argentinaprograma.portfolio.services;

import java.sql.Date;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import antlr.StringUtils;
import ar.argentinaprograma.portfolio.controllers.ProfileController;
import ar.argentinaprograma.portfolio.dtos.AuthDto;
import ar.argentinaprograma.portfolio.dtos.ProfileDto;
import ar.argentinaprograma.portfolio.models.Profile;
import ar.argentinaprograma.portfolio.repositories.ProfileRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;


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
	
	public Profile saveProfile(ProfileDto dto) {
		return proRepo.saveAndFlush(new Profile(dto));
	}

	public ProfileDto getProfileById(Long id) {
		
		Optional<Profile> profile = proRepo.findById(id);
		
		if (!profile.isPresent()) {
			throw new RuntimeException("Profile not found");
		}
		
		return new ProfileDto(profile.get());
	}
	
	

	
}
