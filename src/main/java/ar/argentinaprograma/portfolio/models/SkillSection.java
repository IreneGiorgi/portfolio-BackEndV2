package ar.argentinaprograma.portfolio.models;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import ar.argentinaprograma.portfolio.dtos.SectionDto;

@Entity
public class SkillSection implements Section{

	@Id 
	@GeneratedValue (generator = "UUID")	
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", updatable = false, nullable = false)
	
	public UUID id;
	public SectionTypeEnum type = SectionTypeEnum.SKILLS;
	public String subtype;
	public String name;
	public String percentage;
	public Long userId;

	

	public SkillSection(SectionDto dto) {
		this.id = dto.id;
		this.subtype = dto.subtype;
		this.name = dto.name;
		this.percentage = dto.percentage;
		this.userId = dto.userId;
		
	}



	@Override
	public SectionTypeEnum getType() {
		return this.type;
	}
}


