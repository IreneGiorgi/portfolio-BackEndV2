package ar.argentinaprograma.portfolio.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ar.argentinaprograma.portfolio.dtos.SectionDto;
import ar.argentinaprograma.portfolio.models.Section;
import ar.argentinaprograma.portfolio.services.SectionService;

@RestController
@RequestMapping("/api/v1")
public class SectionController {
	
	@Autowired
	private SectionService ss;
	
	@GetMapping("/seccion")
	public List<SectionDto> getAllSections(){
		List<Section> allSections = ss.findAllSections();
				
		List<SectionDto> dtos = new ArrayList<>();
		for (Section actualSection : allSections) {
			SectionDto newDto = new SectionDto(actualSection);
			dtos.add(newDto);
		}	
		return dtos;
	}
	
	@RequestMapping(value = "/seccion/**", method = { RequestMethod.GET, RequestMethod.POST}) 
	public SectionDto saveSection(@RequestBody SectionDto req) {
		Section section = ss.saveSection(req);
		return new SectionDto(section);
	}
	
	@RequestMapping(value = "/seccion/{id}", method = RequestMethod.DELETE) 
	public void deleteSection(@PathVariable UUID id) {
	}
	
}


