package lesPetitsChefs.backend.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Instruction {
	
	@JsonProperty("texte")
	private String texte;

	@JsonCreator
	public Instruction(@JsonProperty("texte")String texte) {
		super();
		this.texte = texte;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}
	
	

}
