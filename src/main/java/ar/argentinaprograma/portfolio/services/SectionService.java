package ar.argentinaprograma.portfolio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.argentinaprograma.portfolio.dtos.SectionDto;
import ar.argentinaprograma.portfolio.factory.SectionFactory;
import ar.argentinaprograma.portfolio.models.CardSection;
import ar.argentinaprograma.portfolio.models.Section;
import ar.argentinaprograma.portfolio.models.SkillSection;
import ar.argentinaprograma.portfolio.repositories.CardSectionRepository;
import ar.argentinaprograma.portfolio.repositories.SectionRepository;
import ar.argentinaprograma.portfolio.repositories.SkillSectionRepository;
import ar.argentinaprograma.portfolio.selectors.SectionFactorySelector;

@Service
public class SectionService {

	@Autowired
	private SectionFactorySelector selector;
	
	@Autowired
	private CardSectionRepository cRepository;
	
	@Autowired
	private SkillSectionRepository sRepository;
	
	@Autowired
	private SectionRepository sectionRepository;
	
	public List<Section> findAllSections() {
		
		List<CardSection> cardSections = cRepository.findAll();
		List<SkillSection> skillSections = sRepository.findAll();
		
		List<Section> sections = new ArrayList<>();
		
		sections.addAll(cardSections);
		sections.addAll(skillSections);
		
		return sections;
	}
	
	
	public Section saveSection(SectionDto dto) {
		SectionFactory factory = selector.getFactory(dto.type);
		Section nSection = factory.createSection(dto);
		return sectionRepository.save(nSection);
	}

	public void deleteSection(UUID id){
		cRepository.deleteById(id);
		sRepository.deleteById(id);
	}
}
