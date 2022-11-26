/*
 Author: Sandro Lemanski da Silva (sandrogates@gmail.com)
 Version 1.0
 Date: 01/10/2022 
 */

package br.com.dotingjava.springboot.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import br.com.dotingjava.springboot.payload.EmailDTO;

@Service
public class JsonKafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "${spring.kafka.topic-json.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(EmailDTO user){
    	/*
    	 * Here, the processing of the information received is at your discretion.
    	 * Insert into a database, send email, save to text file, etc.
    	 * If you got this far, it means that springbook and kafka integration is working
    	 * Tks. Sandro
    	 */
        LOGGER.info(String.format("The JSON message recieved. You should send an email, etc -> JSON values %s", user.toString()));
    }
}
