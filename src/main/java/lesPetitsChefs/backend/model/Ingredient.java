package lesPetitsChefs.backend.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Ingredient {

	@JsonProperty("nom")
	private String nom;
	
	@JsonProperty("quantite")
	private String quantite;
	
	@JsonCreator
	public Ingredient(@JsonProperty("nom")String nom, @JsonProperty("quantite")String quantite) {
		super();
		this.nom = nom;
		this.quantite = quantite;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getQuantite() {
		return quantite;
	}
	public void setQuantite(String quantite) {
		this.quantite = quantite;
	} 
	
	
}
