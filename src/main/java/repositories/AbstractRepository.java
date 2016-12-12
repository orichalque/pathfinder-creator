package repositories;

import com.google.common.collect.Lists;
import com.mongodb.client.MongoCollection;
import com.mongodb.util.JSON;
import org.bson.Document;

import java.util.List;

import static com.mongodb.client.model.Filters.eq;

/**
 * Created by Vandorallen on 12/12/2016.
 */
public abstract class AbstractRepository {

    protected String getAllDocuments(MongoCollection mongoCollection) {
        List<Document> list = Lists.newArrayList(mongoCollection.find());
        list.forEach(document -> document.remove("_id"));
        return JSON.serialize(list);
    }

    protected String getDocumentById(MongoCollection mongoCollection, String id) {
        Document document = (Document) mongoCollection.find(eq("id", id)).first();
        document.remove("_id");
        return JSON.serialize(document);
    }
}
