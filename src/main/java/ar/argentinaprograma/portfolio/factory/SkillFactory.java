package ar.argentinaprograma.portfolio.factory;

import org.springframework.stereotype.Component;

import ar.argentinaprograma.portfolio.dtos.SectionDto;
import ar.argentinaprograma.portfolio.models.Section;
import ar.argentinaprograma.portfolio.models.SkillSection;

@Component
public class SkillFactory implements SectionFactory {

	@Override
	public Section createSection(SectionDto dto) {
		return new SkillSection(dto);
	}

	
	
}
