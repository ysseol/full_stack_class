package mongodb;

import java.util.Scanner;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class FindUser {
	
	public static void main(String[] args) {
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		MongoDatabase db = mongoClient.getDatabase("testdb");
		MongoCollection<Document> users = db.getCollection("users");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 이름: ");
		String name = sc.nextLine();
		
		Document user = users.find(Filters.eq("name", name)).first();
		if (user != null) {
			System.out.println("찾은 사용자: " + user.toJson());
		} else {
			System.out.println("해당 이름의 사용자가 없습니다.");
		}
		
		mongoClient.close();
	}
}