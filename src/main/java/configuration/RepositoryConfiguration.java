package configuration;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import interfaces.CharacterRepository;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import repositories.CharacterRepositoryImpl;

/**
 * Created by Vandorallen on 12/12/2016.
 */
public class RepositoryConfiguration {

    private static final String MONGO_CLIENT = "mongoClient";

    @Value("${mongo.url}")
    private String mongoUri;

    @Value("${mongo.database}")
    private String mongoDbName;

    @Value("${mongo.collection.character}")
    private String characterCollection;

    @Bean
    public CharacterRepository characterRepository() {
        return new CharacterRepositoryImpl();
    }

    @Bean(name = MONGO_CLIENT)
    public MongoClient mongoClient() {
        MongoClientURI mongoClientURI = new MongoClientURI(String.format("%s/%s", mongoUri, mongoDbName));
        return new MongoClient(mongoClientURI);
    }

    @DependsOn(MONGO_CLIENT)
    @Bean
    public MongoCollection<Document> characterCollection() {
        return mongoClient().getDatabase(mongoDbName).getCollection(characterCollection);
    }
}
