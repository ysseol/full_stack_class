package recipe;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import config.MongoConfig;

public class RecipeDAO {
    private MongoCollection<Document> collection;

    public RecipeDAO() {
        MongoClient mongoClient = MongoConfig.getConn();
        MongoDatabase db = mongoClient.getDatabase("recipe");
        collection = db.getCollection("recipes");
    }

    public List<RecipeDTO> getAllRecipes() {
        List<RecipeDTO> list = new ArrayList<>();
        for (Document doc : collection.find()) {
            list.add(toRecipe(doc));
        }
        return list;
    }
    
    public RecipeDTO getRecipeById(String id) {
    	Document doc = collection.find(new Document("_id", new ObjectId(id))).first();
    	return toRecipe(doc);
    }
    
    public void insertRecipe(RecipeDTO recipe) {
    	Document doc = new Document("title" , recipe.getTitle()).append("ingredients", recipe.getIngredients()).append("steps", recipe.getSteps()).append("createdAt", new Date());
        collection.insertOne(doc);
    }
    
    public void updateRecipe(RecipeDTO recipe) {
        Document query = new Document("_id", new ObjectId(recipe.getId()));
        Document update = new Document("$set", new Document("title", recipe.getTitle())
            .append("ingredients", recipe.getIngredients())
            .append("steps", recipe.getSteps()));
        collection.updateOne(query, update);
    }

    public void deleteRecipe(String id) {
        collection.deleteOne(new Document("_id", new ObjectId(id)));
    }

    private RecipeDTO toRecipe(Document doc) {
        RecipeDTO recipe = new RecipeDTO();
        recipe.setId(doc.getObjectId("_id").toHexString());
        recipe.setTitle(doc.getString("title"));
        recipe.setIngredients(doc.getString("ingredients"));
        recipe.setSteps(doc.getString("steps"));
        return recipe;
    }
}
