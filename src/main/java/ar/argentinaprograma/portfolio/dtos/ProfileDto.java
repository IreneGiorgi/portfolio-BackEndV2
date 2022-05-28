package ar.argentinaprograma.portfolio.dtos;


import ar.argentinaprograma.portfolio.models.Profile;

public class ProfileDto {

	public Long id;
	public String fotoBannerPerfil;
	public String fotoPerfil;
	public String nombrePerfil;
	public String tituloPerfil;
	public String acercaPerfil;

	
	public ProfileDto(Profile prof) {
		this.id = prof.id;
		this.fotoBannerPerfil = prof.bannerURL;
		this.fotoPerfil = prof.profileURL;
		this.nombrePerfil = prof.name;
		this.tituloPerfil = prof.title;
		this.acercaPerfil = prof.about;
	}
	
}
