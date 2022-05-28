package ar.argentinaprograma.portfolio.factory;

import ar.argentinaprograma.portfolio.dtos.SectionDto;
import ar.argentinaprograma.portfolio.models.Section;

public interface SectionFactory {

	public Section createSection(SectionDto dto);
}
