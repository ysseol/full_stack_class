package mongodb;

import java.util.Scanner;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class AddUser {
	public static void main(String[] args) {
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		MongoDatabase db = mongoClient.getDatabase("testdb");
		MongoCollection<Document> users = db.getCollection("users");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("이름: ");
		String name = sc.nextLine();
		System.out.print("나이: ");
		int age = Integer.parseInt(sc.nextLine());
		
		Document user = new Document("name", name).append("age", age);
		users.insertOne(user);
		System.out.println("사용자 추가 완료.");
		
		FindIterable<Document> docs = users.find();
		for (Document d : docs) {
			System.out.println(String.format("이름: %s | 나이: %d | 이메일: %s",
					d.getString("name"),
					d.getInteger("age", 0),
					d.getString("email")));
		}
		
		mongoClient.close();
	}
}
