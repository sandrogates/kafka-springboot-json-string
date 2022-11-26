/*
 Author: Sandro Lemanski da Silva (sandrogates@gmail.com)
 Version 1.0
 Date: 01/10/2022 

 Here is springboot's STRING API processing.

 
 to run via Browser
 
 http://localhost:8080/api/dotingjava/kafka/publish_string?message=TESTE_DOTING_JAVA
 
 to run via curl
 
 $ curl -X GET http://localhost:8080/api/dotingjava/kafka/publish_string?message=TESTE_DOTING_JAVA
 
 */

package br.com.dotingjava.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.dotingjava.springboot.kafka.StringKafkaProducer;

@RestController
@RequestMapping("/api/dotingjava/kafka")
public class StringMessageController {

    private StringKafkaProducer kafkaProducer;

    public StringMessageController(StringKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }
    
    /*
     * see documentation above the requirements for operation
     */
    @GetMapping("/publish_string")
    public ResponseEntity<String> publish(@RequestParam("message") String message){
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent - the topic " + kafkaProducer.getTopicName() +" Data " + message);
    }
    
}
