package ar.argentinaprograma.portfolio.models;

import java.util.Optional;

public enum SectionTypeEnum {

	SKILLS("skills"),
	CARD("card");
	
	String name;
	
	private SectionTypeEnum(String name) {
		this.name = name;
		
		// Ia vengo
	}
	
	
	public static Optional<SectionTypeEnum> findByName(String name) {
		
		if (name == null) {
			return Optional.empty();
		}
		
		SectionTypeEnum e = null;
		
		for (SectionTypeEnum se : values()) {
			
			if(name.equalsIgnoreCase(se.getName())) {
				e = se;
				break;
			}
			
		}
		
		return Optional.ofNullable(e);
	}


	public String getName() {
		return name;
	}
	
}
