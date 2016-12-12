package repositories;

import com.mongodb.client.MongoCollection;
import interfaces.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Vandorallen on 12/12/2016.
 */
public class SpeciesRepositoryImpl extends AbstractRepository implements SpeciesRepository{

    @Autowired
    private MongoCollection speciesCollection;

    @Override
    public String getSpecies() {
        return super.getAllDocuments(speciesCollection);
    }

    @Override
    public String getSpeciesById(String id) {
        return super.getDocumentById(speciesCollection, id);
    }
}
