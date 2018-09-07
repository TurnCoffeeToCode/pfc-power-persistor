package de.ite.dus.pfc.power.persistor;

import com.mongodb.*;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Arrays;
import java.util.Map;

@Configuration
public class PfcPowerMongoConfiguration {

    @Value("${mongo.user}")
    private String user;

    @Value("${mongo.password}")
    private String password;

    @Value("${mongo.database}")
    private String database;

    @Bean
    public MongoClient mongo() {
        MongoClient mongoClient = new MongoClient(new ServerAddress("127.0.0.1", 27017), Arrays.asList(mongoCredential()));
        createMongoDbUser(mongoClient);
        return mongoClient;
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        MongoTemplate mongoTemplate = new MongoTemplate(mongo(), database);
        return mongoTemplate;
    }

    public MongoCredential mongoCredential() {
        return MongoCredential.createCredential(user, database, password.toCharArray());
    }

    private void createMongoDbUser(MongoClient mongoClient) {
        MongoDatabase db =  mongoClient.getDatabase(database);

        Map<String, Object> commandArguments = new BasicDBObject();
        commandArguments.put("createUser", user);
        commandArguments.put("pwd", password);
        String[] roles = { "readWrite" };
        commandArguments.put("roles", roles);
        BasicDBObject command = new BasicDBObject(commandArguments);
        db.runCommand(command);
    }
}
