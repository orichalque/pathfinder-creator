package repositories;

import com.mongodb.client.MongoCollection;
import interfaces.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Vandorallen on 12/12/2016.
 */
public class ClassRepositoryImpl extends AbstractRepository implements ClassRepository{

    @Autowired
    private MongoCollection classCollection;

    @Override
    public String getClasses() {
        return super.getAllDocuments(classCollection);
    }

    @Override
    public String getClassById(String id) {
        return super.getDocumentById(classCollection, id);
    }
}
