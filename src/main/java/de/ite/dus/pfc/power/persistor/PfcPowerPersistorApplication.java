package de.ite.dus.pfc.power.persistor;


import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

import static org.springframework.messaging.simp.stomp.StompHeaders.HOST;

@SpringBootApplication
public class PfcPowerPersistorApplication {

    @Value("${mongo.user}")
    private String user;

    @Value("${mongo.password}")
    private String password;

    @Value("${mongo.database}")
    private String database;

    @Autowired
    private MongoClient mongo;

    public static void main(String[] args) {

        SpringApplication.run(PfcPowerPersistorApplication.class, args);
    }
}
