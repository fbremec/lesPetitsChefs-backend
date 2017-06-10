package lesPetisChefs.backend.rest.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.BSON;
import org.bson.BSONObject;
import org.bson.Document;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;



import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;

import lesPetitsChefs.backend.dao.RecetteDao;
import lesPetitsChefs.backend.model.Recette;
import lesPetitsChefs.backend.mongoDB.MongoConnect;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/recettes", produces = { APPLICATION_JSON_VALUE })
public class RecetteController {
	
		private final RecetteDao recetteDao = new RecetteDao();
		
		@RequestMapping(value={"", "/{typePrincipal}","/{typePrincipal}/{typeSecondaire}"},method = RequestMethod.GET, produces = {"application/json" })
		private ResponseEntity<?> getRecetteByTypePrincipalAndTypeSecondaire(@PathVariable(value="typePrincipal",required=false) String typePrincipal,
				@PathVariable(value = "typeSecondaire", required=false) String typeSecondaire){
			List<Recette> liste = this.recetteDao.getRecetteByTypePrincipalAndTypeSecondaire(typePrincipal, typeSecondaire);
			return new ResponseEntity<List<Recette>> (liste, HttpStatus.OK);
		}
		
		@RequestMapping(value="",method = RequestMethod.POST, produces = {"application/json" })
		private ResponseEntity<?> postAppertifs(@RequestBody Recette recetteRequest){
				this.recetteDao.addRecette(recetteRequest);
				return new ResponseEntity (HttpStatus.OK);
		}
		
		

}
