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

    @Value("${mongo.collection.skills}")
    private String skillCollection;

    @Value("${mongo.collection.gifts}")
    private String giftCollection;

    @Value("${mongo.collection.characters}")
    private String characterCollection;

    @Value("${mongo.collection.equipments}")
    private String equipmentCollection;

    @Value("${mongo.collection.species}")
    private String speciesCollection;

    @Value("${mongo.collection.classes}")
    private String classCollection;

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

    @DependsOn(MONGO_CLIENT)
    @Bean
    public MongoCollection<Document> giftCollection() {
        return mongoClient().getDatabase(mongoDbName).getCollection(giftCollection);
    }

    @DependsOn(MONGO_CLIENT)
    @Bean
    public MongoCollection<Document> speciesCollection() {
        return mongoClient().getDatabase(mongoDbName).getCollection(speciesCollection);
    }

    @DependsOn(MONGO_CLIENT)
    @Bean
    public MongoCollection<Document> classCollection() {
        return mongoClient().getDatabase(mongoDbName).getCollection(classCollection);
    }

    @DependsOn(MONGO_CLIENT)
    @Bean
    public MongoCollection<Document> equipmentCollection() {
        return mongoClient().getDatabase(mongoDbName).getCollection(equipmentCollection);
    }

    @DependsOn(MONGO_CLIENT)
    @Bean
    public MongoCollection<Document> skillCollection() {
        return mongoClient().getDatabase(mongoDbName).getCollection(skillCollection);
    }
}
