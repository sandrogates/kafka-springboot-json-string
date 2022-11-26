/*

 Author: Sandro Lemanski da Silva (sandrogates@gmail.com)
 Version 1.0
 Date: 01/10/2022 

 Here is springboot's JSON API processing.
 
 
 to run via Browser
 	obviously, this request has parts in json and, via directly the browser's URL, this is not viable
 	
 	The "StringMessageController" it is possible, see example in that class.
 
 to run via curl Linux/Windows/etc
 
 $ curl -H "Accept: application/json" -H "Content-type: application/json" -X POST -d "{\"from\":\"Sandro Lemanski da Silva\",\"subject\":\"Springbook+kafka\",\"to\":\"sandrogates@gmail.com\",\"message\":\"Hi, this works\"}" http://localhost:8080/api/dotingjava/kafka/publish_json
 
*/

package br.com.dotingjava.springboot.controller;

import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.dotingjava.springboot.kafka.JsonKafkaProducer;
import br.com.dotingjava.springboot.payload.EmailDTO;

@RestController
@RequestMapping("/api/dotingjava/kafka")
public class JsonMessageController {

    private JsonKafkaProducer kafkaProducer;

    public JsonMessageController(JsonKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @RequestMapping(
    	    value = "/publish_json", 
    	    method = RequestMethod.POST,
    	    consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity publish_v1(@RequestBody String payload) throws Exception {
    	System.out.println("I Received/Recebi - Original string json - SpringBoot:" + payload);
    	
    	/*
    	 * see documentation above the requirements for operation
    	 * 
    	 * I could even have used lombok (https://projectlombok.org/) .build(), etc, but to simplify, I made the standard get and set methods
    	 * 
    	 */
    	
    	JSONObject jsonObject = new JSONObject(payload);      	
        EmailDTO emailDTO = new EmailDTO();
        emailDTO.setFromEmail(jsonObject.getString("from"));
        emailDTO.setToEmail(jsonObject.getString("to"));
        emailDTO.setMessage(jsonObject.getString("message"));
        emailDTO.setSubject(jsonObject.getString("subject"));
        kafkaProducer.sendMessage(emailDTO);
        return ResponseEntity.ok("JSON message sent - kafka topic - " + kafkaProducer.getTopicJsonName() + " Data" + jsonObject.toString());
    }    
    
}
