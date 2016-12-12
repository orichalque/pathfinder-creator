package repositories;

import com.mongodb.client.MongoCollection;
import interfaces.GiftRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Vandorallen on 12/12/2016.
 */
public class GiftRepositoryImpl extends AbstractRepository implements GiftRepository{

    @Autowired
    private MongoCollection giftCollection;

    @Override
    public String getGifts() {
        return super.getAllDocuments(giftCollection);
    }

    @Override
    public String getGiftById(String id) {
        return super.getDocumentById(giftCollection, id);
    }
}
