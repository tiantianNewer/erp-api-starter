package nxu.it.api.service.mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

public class MongoDbFactory {
    @ApplicationScoped
    @Produces
    public MongoDatabase getDatabase(MongoClient mongoClient){
        return mongoClient.getDatabase("erp_api");
    }
}
