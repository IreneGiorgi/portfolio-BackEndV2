package ar.argentinaprograma.portfolio.models;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import ar.argentinaprograma.portfolio.dtos.SectionDto;

@Entity
public class CardSection implements Section{

	@Id 
	@GeneratedValue (generator = "UUID")	
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", updatable = false, nullable = false)
	
	public UUID id;
	public SectionTypeEnum type = SectionTypeEnum.CARD;
	public String subtype; 
	public String name;
	public String location;
	public String description;
	public String startDate;
	public String endDate;
	public String status;
	public String information;
	public Long userId;
	public String image;
	
	public CardSection(SectionDto dto) {
		this.id = dto.id;
		this.subtype = dto.subtype;
		this.name = dto.name;
		this.location = dto.location;
		this.description = dto.description;
		this.startDate = dto.startDate;
		this.endDate = dto.endDate;
		this.status = dto.status;
		this.information = dto.information;
		this.userId = dto.userId;
		this.image = dto.image;
		
	}

	@Override
	public SectionTypeEnum getType() {
		return this.type;
	}

}
