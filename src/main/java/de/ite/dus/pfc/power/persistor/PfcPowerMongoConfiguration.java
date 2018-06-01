package de.ite.dus.pfc.power.persistor;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class PfcPowerMongoConfiguration {

    @Value("${mongo.dbName}")
    private String databaseName;

    @Bean
    public MongoClient mongo() {
        return new MongoClient("127.0.0.1", 27017);
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongo(), databaseName);
    }
}
