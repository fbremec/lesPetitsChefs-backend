package lesPetisChefs.backend.rest.controller;

import java.util.Iterator;
import java.util.List;

import org.bson.BSON;
import org.bson.BSONObject;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;



import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/apperitifs", produces = { APPLICATION_JSON_VALUE })
public class ApperitifController {
	
		private MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
		private DB db = mongoClient.getDB( "lesPetitsChefs" );
		private DBCollection collectionRecette= db.getCollection("Recette");
	
		@RequestMapping(value="/{login1}/{login2}",method = RequestMethod.GET, produces = {"application/json" })
		private ResponseEntity<?> getMessagesBetweenContacts(@PathVariable String login1,@PathVariable String login2){
				DBObject myDoc = collectionRecette.findOne();
				System.out.println(myDoc);
				System.out.println("login1 : "+login1+" login2 : "+login2);
				return null;
		}
		
		@RequestMapping(value="/",method = RequestMethod.POST, produces = {"application/json" })
		private ResponseEntity<?> postAppertifs(@RequestBody String request){
								
				BasicDBObject doc = new BasicDBObject();
				
			    JSONObject jsonObj = new JSONObject(request);

			    Iterator<?> keys = jsonObj.keys();

			    while( keys.hasNext() ) {
			        String key = (String)keys.next();
			        System.out.println(jsonObj.get(key) );
			       doc.append(key, jsonObj.get(key));
			    }
			    collectionRecette.insert(doc);
				return null;
		}
		
		

}
