package ar.argentinaprograma.portfolio.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.argentinaprograma.portfolio.models.CardSection;
import ar.argentinaprograma.portfolio.models.Section;
import ar.argentinaprograma.portfolio.models.SkillSection;

@Component
public class SectionRepository {

	@Autowired
	private CardSectionRepository cRepository;
	
	@Autowired
	private SkillSectionRepository sRepository;
	
	public Section save(Section sec) {
		Section savedSection;
		
		switch (sec.getType()) {
		case CARD:
			savedSection = cRepository.saveAndFlush((CardSection)sec);
			break;

		case SKILLS:
			savedSection = sRepository.saveAndFlush((SkillSection)sec);
			break;
		default:
			throw new RuntimeException("Type of section not supported");
		}
		
		return savedSection;
	}
	
}
