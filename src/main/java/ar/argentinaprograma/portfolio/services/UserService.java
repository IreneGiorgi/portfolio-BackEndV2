package ar.argentinaprograma.portfolio.services;

import java.security.Key;
import java.sql.Date;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.List;

import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.argentinaprograma.portfolio.dtos.AuthDto;
import ar.argentinaprograma.portfolio.models.User;
import ar.argentinaprograma.portfolio.repositories.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class UserService {

	@Autowired
	private UserRepository uRepo;
	
	private final Logger log = LoggerFactory.getLogger(ProfileService.class);

	
	private static final String SECRET = "asdfSFS34wfsdfsdfSDSD32dfsddDDerQSNCK34SOWEK5354fdgdf4";

	
	private final String PREFIX = "Bearer ";

	public AuthDto login(String username, String password) {
		
		List<User> users = uRepo.findByUser(username);
		
		if (users.isEmpty() || users.size() > 1) {
			throw new RuntimeException("Username not found or cannot be assured");
		}
		
		User user = users.get(0);
		
		
		if (!user.password.equals(password)) {
			throw new RuntimeException("Username not found or cannot be assured");
		}
		
		AuthDto auth = new AuthDto();
		
		
		
		Key hmacKey = new SecretKeySpec(Base64.getDecoder().decode(SECRET), 
		                            SignatureAlgorithm.HS256.getJcaName());
		
		Instant now = Instant.now();
		
		String jwtToken = Jwts.builder()
		        .claim("id", user.id)
		        .setSubject(user.user)
		        .setId(String.valueOf(user.id))
		        .setIssuedAt(Date.from(now ))
		        .setExpiration(Date.from(now.plus(5l, ChronoUnit.HOURS)))
		        .signWith(hmacKey)
		        .compact();
		
		auth.expiresIn = now.plus(5l, ChronoUnit.HOURS).getEpochSecond();
		auth.idToken = jwtToken;
		
		return auth;
	}
	
	
	public void validateToken(String jwtString) {
		
		if (jwtString == null || jwtString.isBlank() || jwtString.isEmpty()) {
			throw new RuntimeException("Not authorized");
		}
		
		log.info("JWT Token received: {}", jwtString);
		
		if (!hasValidToken(jwtString.replace(PREFIX, ""))) {
			throw new RuntimeException("Not authorized");
		}
		
	}
	
	
	private Boolean hasValidToken(String jwtString) {
		

	    Key hmacKey = new SecretKeySpec(Base64.getDecoder().decode(SECRET), 
	                                    SignatureAlgorithm.HS256.getJcaName());

	    Jwts.parserBuilder()
	            .setSigningKey(hmacKey)
	            .build()
	            .parseClaimsJws(jwtString);
		
			    
		return true;
	}
}
