package de.ite.dus.pfc.power.persistor.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Slf4j
public class PfcConsumer {

    @Autowired
    private Consumer consumer;

    @Autowired
    private MongoTemplate mongoTemplate;

    @PostConstruct
    public void listen() {
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.of(100, ChronoUnit.MILLIS));
            for (ConsumerRecord<String, String> consumerRecord : records) {
                log.info("received record='{}' with offset='{}' and key='{}", consumerRecord.value(), consumerRecord.offset(), consumerRecord.key());
                mongoTemplate.save(consumerRecord.value(), "pfcPower");
            }

        }
    }
}
