package repositories;

import com.mongodb.client.MongoCollection;
import interfaces.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Vandorallen on 12/12/2016.
 */
public class SkillRepositoryImpl extends AbstractRepository implements SkillRepository{

    @Autowired
    private MongoCollection skillCollection;

    @Override
    public String getSkills() {
        return super.getAllDocuments(skillCollection);
    }

    @Override
    public String getSkillById(String id) {
        return super.getDocumentById(skillCollection, id);
    }
}
