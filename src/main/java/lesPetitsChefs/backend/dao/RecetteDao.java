package lesPetitsChefs.backend.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoCursor;

import lesPetitsChefs.backend.model.Ingredient;
import lesPetitsChefs.backend.model.Instruction;
import lesPetitsChefs.backend.model.Recette;
import lesPetitsChefs.backend.mongoDB.MongoConnect;

public class RecetteDao {
	
	public void addRecette(Recette r){
		ObjectMapper mapper = new ObjectMapper();
		String json;
		try {
			json = mapper.writeValueAsString(r);
			MongoConnect.collectionRecette.insertOne(Document.parse(json));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public Recette getRecetteByTypePrincipal(String typePrincipal){
		
		
		return null;
	}
	
	public List<Recette> getRecetteByTypePrincipalAndTypeSecondaire(String typePrincipal, String typeSecondaire){
		
		Document findQuery = new Document("type",typePrincipal).append("typeSecondaire", typeSecondaire);
		System.out.println(findQuery);
		ArrayList<Recette> listeRecette = new ArrayList<Recette>();
		List<Document> recettes = (List<Document>) MongoConnect.collectionRecette.find(findQuery).into(
				new ArrayList<Document>());
		for (Document recette : recettes) {
			
			Recette r = new Recette(recette.getString("nom"),recette.getString("type"), recette.getString("typeSecondaire")
					,recette.getString("tempsCuissons"),recette.getString("tempsPreparation"));
			
			//récupère la liste des ingredients
			List<Ingredient> listeIngredient = new ArrayList<Ingredient>();
			List<Document> ingredientsDocument = (List<Document>) recette.get("listeIngredient");
			if(ingredientsDocument != null){
				for (Document ingredientDocument : ingredientsDocument) {
					Ingredient i = new Ingredient(ingredientDocument.getString("nom"),ingredientDocument.getString("quantite"));
					listeIngredient.add(i);
				}
				r.setListeIngredient(listeIngredient);
			}
			
			//récupère la liste des instructions
			List<Instruction> listeInstruction = new ArrayList<Instruction>();
			List<Document> instructionsDocument = (List<Document>) recette.get("listeInstruction");
			if(instructionsDocument != null){
				for (Document instructionDocument : instructionsDocument) {
					Instruction i = new Instruction(instructionDocument.getString("texte"));
					listeInstruction.add(i);
				}
				r.setListeInstruction(listeInstruction);
			}
			
			listeRecette.add(r);
 
		}
				
		return listeRecette;
	}

}
