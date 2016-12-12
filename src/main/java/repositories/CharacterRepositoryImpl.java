package repositories;

import com.mongodb.client.MongoCollection;
import interfaces.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Vandorallen on 12/12/2016.
 */
public class CharacterRepositoryImpl extends AbstractRepository implements CharacterRepository {

    @Autowired
    private MongoCollection characterCollection;

    @Override
    public String getCharacters() {
        return super.getAllDocuments(characterCollection);
    }

    @Override
    public String getCharacterById(String id) {
        return super.getDocumentById(characterCollection, id);
    }
}
