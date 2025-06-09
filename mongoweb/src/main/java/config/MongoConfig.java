package config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class MongoConfig {

	private static MongoClient mongoClient = null;
	
	static {
		try {
			mongoClient = MongoClients.create("mongodb://user:1234@localhost:27017/recipe?authSource=recipe");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static MongoClient getConn() {
		return mongoClient;
	}
}
