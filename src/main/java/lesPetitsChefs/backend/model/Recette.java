package lesPetitsChefs.backend.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Recette {
	
	private String nom;
	private String type;
	private String typeSecondaire;
	private List<Ingredient> listeIngredient;
	private List<Instruction> listeInstruction;
	private String tempsCuissons;
	private String tempsPreparation;
		
	@JsonCreator
	public Recette(@JsonProperty("nom")String nom, @JsonProperty("type")String type, @JsonProperty("typeSecondaire")String typeSecondaire,@JsonProperty("listeIngredient") List<Ingredient> listeIngredients,
			@JsonProperty("listeInstruction")List<Instruction> listeInstruction, @JsonProperty("tempsCuissons")String tempsCuissons, @JsonProperty("tempsPreparation")String tempsPreparation) {
		super();
		this.nom = nom;
		this.type = type;
		this.typeSecondaire = typeSecondaire;
		this.listeIngredient = listeIngredients;
		this.listeInstruction = listeInstruction;
		this.tempsCuissons = tempsCuissons;
		this.tempsPreparation = tempsPreparation;
	}
	
	public Recette(String nom,String type, String typeSecondaire, String tempsCuissons, String tempsPreparation) {
		super();
		this.nom = nom;
		this.type = type;
		this.typeSecondaire = typeSecondaire;
		this.listeIngredient = listeIngredient;
		this.listeInstruction = listeInstruction;
		this.tempsCuissons = tempsCuissons;
		this.tempsPreparation = tempsPreparation;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getTypeSecondaire() {
		return typeSecondaire;
	}

	public void setTypeSecondaire(String typeSecondaire) {
		this.typeSecondaire = typeSecondaire;
	}

	public List<Ingredient> getListeIngredient() {
		return listeIngredient;
	}

	public void setListeIngredient(List<Ingredient> listeIngredients) {
		this.listeIngredient = listeIngredients;
	}

	public List<Instruction> getListeInstruction() {
		return listeInstruction;
	}

	public void setListeInstruction(List<Instruction> listeInstruction) {
		this.listeInstruction = listeInstruction;
	}

	public String getTempsCuissons() {
		return tempsCuissons;
	}

	public void setTempsCuissons(String tempsCuissons) {
		this.tempsCuissons = tempsCuissons;
	}

	public String getTempsPreparation() {
		return tempsPreparation;
	}

	public void setTempsPreparation(String tempsPreparation) {
		this.tempsPreparation = tempsPreparation;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	

}
