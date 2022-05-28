package ar.argentinaprograma.portfolio.selectors;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.argentinaprograma.portfolio.factory.CardFactory;
import ar.argentinaprograma.portfolio.factory.SectionFactory;
import ar.argentinaprograma.portfolio.factory.SkillFactory;
import ar.argentinaprograma.portfolio.models.SectionTypeEnum;

@Component
public class SectionFactorySelector {

	@Autowired
	private CardFactory cFactory;
	@Autowired
	private SkillFactory sFactory;
	
	public SectionFactory getFactory(String type) {
		SectionFactory factory;
		
		Optional<SectionTypeEnum> sectionType = SectionTypeEnum.findByName(type);
		
		if (!sectionType.isPresent()) {
			throw new RuntimeException("Cannot find section type: "+ type);
		}
		
		switch (sectionType.get()) {
		case CARD:
			factory = this.cFactory;
			break;
			
		case SKILLS:
			factory = this.sFactory;
			break;
			
		default:
			throw new RuntimeException("Cannot find section type: "+ type);
		}
		
		return factory;
	}
	
}
