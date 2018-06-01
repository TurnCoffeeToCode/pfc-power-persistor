package de.ite.dus.pfc.power.persistor;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PfcConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(PfcConsumer.class);

    @KafkaListener(topics = "${kafka.topic.pfc.power.import}")
    public void receive(ConsumerRecord<?, ?> consumerRecord) {
        LOGGER.info("received record='{}'", consumerRecord.toString());
    }
}
