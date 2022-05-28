package ar.argentinaprograma.portfolio.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ar.argentinaprograma.portfolio.dtos.SectionDto;
import ar.argentinaprograma.portfolio.models.Section;
import ar.argentinaprograma.portfolio.services.ProfileService;
import ar.argentinaprograma.portfolio.services.SectionService;
import ar.argentinaprograma.portfolio.services.UserService;

@RestController
@RequestMapping("/api/v1")
public class SectionController {

	@Autowired
	private UserService uService;

	
	private final Logger log = LoggerFactory.getLogger(SectionController.class);

	
	@Autowired
	private SectionService ss;
	
	@GetMapping("/seccion")
	public List<SectionDto> getAllSections(){
		List<Section> allSections = ss.findAllSections();
				
		log.info("Searching all sections...");
		
		List<SectionDto> dtos = new ArrayList<>();
		for (Section actualSection : allSections) {
			SectionDto newDto = new SectionDto(actualSection);
			
			log.info("Converted from: {}, to dto: {}", actualSection, newDto);
			dtos.add(newDto);
		}	
		return dtos;
	}
	
	@RequestMapping(value = "/seccion/**", method = { RequestMethod.PUT, RequestMethod.POST, RequestMethod.PATCH}) 
	public SectionDto saveSection(
			@RequestHeader("Authorization") String jwtToken, 
			@RequestBody SectionDto req
			) {
		
		uService.validateToken(jwtToken);
		
		
		log.info("Sending to input req: {}", req);
		
		Section section = ss.saveSection(req);
		
		log.info("Returning response: {}", section);
		
		return new SectionDto(section);
	}
	
	@RequestMapping(value = "/seccion/skills/{id}", method = RequestMethod.DELETE) 
	public void deleteSkillSection(
			@RequestHeader("Authorization") String jwtToken, 
			@PathVariable Long id
			) {
		
		uService.validateToken(jwtToken);

		log.info("Sending to delete req: {}", id);

		ss.deleteSkillSection(id);
	}
	
	@RequestMapping(value = "/seccion/card/{id}", method = RequestMethod.DELETE) 
	public void deleteCardSection(
			@RequestHeader("Authorization") String jwtToken, 
			@PathVariable Long id
			) {
		
		uService.validateToken(jwtToken);

		
		log.info("Sending to delete req: {}", id);

		ss.deleteCardSection(id);
	}
	
}


