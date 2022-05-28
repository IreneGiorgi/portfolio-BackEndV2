package ar.argentinaprograma.portfolio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.argentinaprograma.portfolio.dtos.AuthDto;
import ar.argentinaprograma.portfolio.dtos.UserDto;
import ar.argentinaprograma.portfolio.services.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
	public UserService uService;
	
	
	@PostMapping("/login")
	public AuthDto login(@RequestBody UserDto dto) {
		
		if (dto == null || dto.user == null) {
			throw new RuntimeException("Username cannot be null");
		}
		
	
		return uService.login(dto.user, dto.password);
	}
	
}
