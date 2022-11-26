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
import org.springframework.stereotype.Service;

@Service
public class StringKafkaProducer {

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    private static final Logger LOGGER = LoggerFactory.getLogger(StringKafkaProducer.class);

    private KafkaTemplate<String, String> kafkaTemplate;

    public String getTopicName() {
    	return topicName;
    }
    
    public StringKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message){
        LOGGER.info(String.format("String message sent do Kafka topic " + topicName + " -> %s", message.toString()));
        kafkaTemplate.send(topicName, message);
    }
}
