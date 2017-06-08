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

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/apperitifs", produces = { APPLICATION_JSON_VALUE })
public class ApperitifController {
	
		 MongoClientURI uri  = new MongoClientURI("mongodb://user1:root@ds145148.mlab.com:45148/lespetitschefs"); 
	     MongoClient client = new MongoClient(uri);
	     MongoDatabase db = client.getDatabase(uri.getDatabase());
	     MongoCollection<Document> coll = db.getCollection("recettes");
	
		@RequestMapping(value="/soupes",method = RequestMethod.GET, produces = {"application/json" })
		private ResponseEntity<?> getMessagesBetweenContacts(){
			
			Document findQuery = new Document("typeSecondaire", "soupe");

	        MongoCursor<Document> cursor = coll.find(findQuery).iterator();
			ArrayList<Document> listeSoupe = new ArrayList<Document>();
			try {
				while(cursor.hasNext()) {

					listeSoupe.add(cursor.next());
				 }
			} finally {
			   cursor.close();
			}
			return new ResponseEntity<ArrayList<Document>> (listeSoupe, HttpStatus.OK);

		}
		
		/*@RequestMapping(value="/",method = RequestMethod.POST, produces = {"application/json" })
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
		}*/
		
		

}
