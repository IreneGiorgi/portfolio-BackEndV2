package ar.argentinaprograma.portfolio.dtos;

import java.util.UUID;

import ar.argentinaprograma.portfolio.models.CardSection;
import ar.argentinaprograma.portfolio.models.Section;
import ar.argentinaprograma.portfolio.models.SectionTypeEnum;
import ar.argentinaprograma.portfolio.models.SkillSection;

public class SectionDto {
	
	public String type;
	public String subtype;
	public String name;
	public String location;
	public String description;
	public String startDate;
	public String endDate;
	public String status;
	public String information;
	public String percentage;
	public Long userId;
	public String image;
	public UUID id;
	
	public SectionDto(Section sec) {

		if (sec == null) {
			throw new RuntimeException("Section cannot be null");
		}
		
		if (sec.getType() == SectionTypeEnum.SKILLS) {
			loadBySkillSection( (SkillSection) sec);
		}
		else if (sec.getType() == SectionTypeEnum.CARD) {
			loadByCardSection((CardSection) sec);
		}
		
	}
	
	private void loadBySkillSection(SkillSection sec) {
		this.id = sec.id;
		this.type = sec.type.getName();
		this.percentage = sec.percentage;
		this.subtype = sec.subtype;
		this.userId = sec.userId;
	}
	
	private void loadByCardSection(CardSection sec) {
		this.id = sec.id;
		this.type = sec.type.getName();
		this.subtype = sec.subtype;
		this.userId = sec.userId;
		this.description = sec.description;
		this.endDate = sec.endDate;
		this.image = sec.image;
		this.location = sec.location;
		this.name = sec.name;
		this.startDate = sec.startDate;
		this.status = sec.status;
		this.information = sec.information;		
	}
}
