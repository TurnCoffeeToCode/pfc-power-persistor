package de.ite.dus.pfc.power.persistor.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.bson.json.JsonReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PfcConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(PfcConsumer.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    @KafkaListener(topics = "${kafka.topic.pfc.power.import}")
    public void receive(ConsumerRecord<String, String> consumerRecord) {
        LOGGER.info("received record='{}'", consumerRecord.toString());

        mongoTemplate.save(new JsonReader(consumerRecord.value()), "pfcPower");
    }
}
