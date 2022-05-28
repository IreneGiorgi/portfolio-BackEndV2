package ar.argentinaprograma.portfolio.models;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.GenericGenerator;

import ar.argentinaprograma.portfolio.dtos.SectionDto;

@Entity
public class CardSection implements Section{

	@Override
	public String toString() {
		return "CardSection [id=" + id + ", type=" + type + ", subtype=" + subtype + ", name=" + name + ", location="
				+ location + ", description=" + description + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", status=" + status + ", information=" + information + ", userId=" + userId + ", image=" + image
				+ "]";
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	public Long id;
	
	public SectionTypeEnum type = SectionTypeEnum.CARD;
	public String subtype; 
	public String name;
	public String location;
	
	@Lob
	public String description;
	
	public String startDate;
	public String endDate;
	public String status;
	public String information;
	public Long userId;
	
	@Lob
	public String image;
	
	public CardSection() {
	}
	
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
