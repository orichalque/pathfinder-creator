package repositories;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.mongodb.client.MongoCollection;
import com.mongodb.util.JSON;
import interfaces.CharacterRepository;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Vandorallen on 12/12/2016.
 */
public class CharacterRepositoryImpl implements CharacterRepository {

    @Autowired
    private MongoCollection characterCollection;

    @Override
    public String getCharacters() {
        List<Document> list = Lists.newArrayList(characterCollection.find());
        list.forEach(document -> document.remove("_id"));
        return JSON.serialize(list);
    }

    @Override
    public String getCharacterById(String id) {
        return null;
    }
}
