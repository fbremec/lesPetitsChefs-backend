package lesPetitsChefs.backend.mongoDB;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoConnect {
	
	public final static MongoClientURI uri  = new MongoClientURI("mongodb://user1:root@ds145148.mlab.com:45148/lespetitschefs"); 
	public final static MongoClient client = new MongoClient(uri);
	public final static MongoDatabase db = client.getDatabase(uri.getDatabase());
	public final static MongoCollection<Document> collectionRecette = db.getCollection("recettes");

}
