package repositories;

import com.mongodb.client.MongoCollection;
import interfaces.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Vandorallen on 12/12/2016.
 */
public class EquipmentRepositoryImpl extends AbstractRepository implements EquipmentRepository {
    @Autowired
    private MongoCollection equipmentCollection;

    @Override
    public String getEquipments() {
        return super.getAllDocuments(equipmentCollection);
    }

    @Override
    public String getEquipmentById(String id) {
        return super.getDocumentById(equipmentCollection, id);
    }
}
