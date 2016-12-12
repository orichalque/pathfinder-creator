package configuration;

import com.mongodb.client.MongoCollection;
import interfaces.CharacterRepository;
import org.bson.Document;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import repositories.CharacterRepositoryImpl;

/**
 * Created by Vandorallen on 12/12/2016.
 */
@Configuration
public class RepositoryConfiguration {

    @Bean
    public CharacterRepository characterRepository() {
        return new CharacterRepositoryImpl();
    }

    @Bean
    public MongoCollection<Document> characterCollection() {
        //TODO
        return null;
    }

}
