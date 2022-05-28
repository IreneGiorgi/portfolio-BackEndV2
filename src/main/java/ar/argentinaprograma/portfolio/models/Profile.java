package ar.argentinaprograma.portfolio.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.Getter;
import lombok.Setter;


@Entity
public class Profile {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	public Long id;
	
	public String name = "Irene Giorgi";
	public String bannerURL = "";
	public String profileURL = "";
	public String about = "";
	public String title = "";
	
	
}
