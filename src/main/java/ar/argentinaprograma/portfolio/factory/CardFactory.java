package ar.argentinaprograma.portfolio.factory;

import org.springframework.stereotype.Component;

import ar.argentinaprograma.portfolio.dtos.SectionDto;
import ar.argentinaprograma.portfolio.models.CardSection;
import ar.argentinaprograma.portfolio.models.Section;

@Component
public class CardFactory implements SectionFactory {

	@Override
	public Section createSection(SectionDto dto) {
		return new CardSection(dto);
	}

}
