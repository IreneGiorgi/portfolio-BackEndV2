package ar.argentinaprograma.portfolio.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import ar.argentinaprograma.portfolio.dtos.ProfileDto;
import lombok.Getter;
import lombok.Setter;


@Entity
public class Profile {

	public Profile() {
	}
	
	public Profile(ProfileDto dto) {
		this.id = dto.id;
		this.name = dto.nombrePerfil;
		this.bannerURL = dto.fotoBannerPerfil;
		this.profileURL = dto.fotoPerfil;
		this.about = dto.acercaPerfil;
		this.title = dto.tituloPerfil;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	public Long id;
	
	public String name = "Irene Giorgi";
	
	@Lob
	public String bannerURL = "";
	@Lob
	public String profileURL = "";
	
	@Lob
	public String about = "";
	public String title = "";
	
	
	
}
