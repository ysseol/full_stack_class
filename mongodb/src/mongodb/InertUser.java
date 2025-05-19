package mongodb;

import java.util.Arrays;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class InertUser {
	public static void main(String[] args) {
		MongoClient client = MongoClients.create("mongodb://localhost:27017");
		MongoDatabase db = client.getDatabase("testdb");
		MongoCollection<Document> users = db.getCollection("users");
		
		users.deleteMany(new Document());
		System.out.println("기존 사용자 데이터 삭제 완료");
		
		List<Document> sampleUsers = Arrays.asList(
				new Document("name", "홍길동").append("age", 25).append("email", "hong@example.com"), 
				new Document("name", "김영희").append("age", 30).append("email", "kim@example.com"), 
				new Document("name", "이철수").append("age", 22).append("email", "lee@example.com"),
				new Document("name", "박민수").append("age", 28).append("email", "park@example.com"),
				new Document("name", "최지우").append("age", 35).append("email", "choi@example.com"));
		
		users.insertMany(sampleUsers);
		System.out.println("샘플 사용자 추가 완료.");
		
		FindIterable<Document> docs = users.find();
		for (Document d : docs) {
			System.out.println(d);
		}
		
		for (Document d : docs) {
			System.out.println(String.format("이름: %s | 나이: %d | 이메일: %s",
					d.getString("name"),
					d.getInteger("age", 0),
					d.getString("email")));
		}
		
		client.close();
	}
}
