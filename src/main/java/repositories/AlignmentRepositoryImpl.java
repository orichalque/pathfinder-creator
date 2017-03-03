package repositories;

import com.mongodb.client.MongoCollection;
import interfaces.AlignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Vandorallen on 12/12/2016.
 */
public class AlignmentRepositoryImpl extends AbstractRepository implements AlignmentRepository {

    @Autowired
    private MongoCollection alignmentCollection;

    @Override
    public String getAlignments() {
        return super.getAllDocuments(alignmentCollection);
    }

    @Override
    public String getAlignmentsById(String id) {
        return super.getDocumentById(alignmentCollection, id);
    }
}
