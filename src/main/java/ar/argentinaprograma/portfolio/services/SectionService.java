package ar.argentinaprograma.portfolio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;

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

	public void deleteSkillSection(Long id) {
		
		if (!sRepository.existsById(id)) {
			throw new RuntimeException("Entity does not exists in database with id: "+ id);
		}
		
		sRepository.deleteById(id);
		sRepository.flush();
	}
	
	public void deleteCardSection(Long id) {
		if (!cRepository.existsById(id)) {
			throw new RuntimeException("Entity does not exists in database with id: "+ id);
		}
		
		cRepository.deleteById(id);
		cRepository.flush();
	}

}
