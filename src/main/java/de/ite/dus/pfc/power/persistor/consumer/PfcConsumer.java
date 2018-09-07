package de.ite.dus.pfc.power.persistor.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.kafka.annotation.KafkaListener;

@Slf4j
public class PfcConsumer {

    @Autowired
    private MongoTemplate mongoTemplate;

    @KafkaListener(topics = "${kafka.topic.pfc.power.import}")
    public void receive(ConsumerRecord<String, String> consumerRecord) {
        log.info("received record='{}'", consumerRecord.value());

        mongoTemplate.save(consumerRecord.value(), "pfcPower");
    }
}
