/*
 Author: Sandro Lemanski da Silva (sandrogates@gmail.com)
 Version 1.0
 Date: 01/10/2022 
 */

package br.com.dotingjava.springboot.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import br.com.dotingjava.springboot.payload.EmailDTO;

@Service
public class JsonKafkaProducer {

    @Value("${spring.kafka.topic-json.name}")
    private String topicJsonName;

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

    private KafkaTemplate<String, EmailDTO> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, EmailDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    
    public String getTopicJsonName() {
    	return topicJsonName;
    }

    public void sendMessage(EmailDTO data){

        LOGGER.info(String.format("JSON message sent do Kafka topic " + topicJsonName + " -> %s", data.toString()));

        Message<EmailDTO> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, topicJsonName)
                .build();

        kafkaTemplate.send(message);
    }
}
