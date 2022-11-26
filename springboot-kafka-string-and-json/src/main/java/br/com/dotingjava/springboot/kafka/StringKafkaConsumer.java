/*
 Author: Sandro Lemanski da Silva (sandrogates@gmail.com)
 Version 1.0
 Date: 01/10/2022 
 */

package br.com.dotingjava.springboot.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class StringKafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(StringKafkaConsumer.class);

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String message){
    	/*
    	 * Here, the processing of the information received is at your discretion.
    	 * If you got this far, it means that springbook and kafka integration is working
    	 * Tks. Sandro
    	 */
        LOGGER.info(String.format("The String message received OK. Work with the information -> %s", message));
    }
}
