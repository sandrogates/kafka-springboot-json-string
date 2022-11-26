/*
 * Author: Sandro Lemanski da Silva (sandrogates@gmail.com)
 * Version 1.0
 * Date: 01/10/2022 
 */

package br.com.dotingjava.springboot.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaCoreTopicConfig {

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    @Value("${spring.kafka.topic-json.name}")
    private String topicJsonName;

    /*
     * Automatically registers the string topic contained in application.properties
     */
    @Bean
    public NewTopic dotingjavaTopic(){
        return TopicBuilder.name(topicName)
                .build();
    }

    /*
     * Automatically registers the JSON topic contained in application.properties
     */
    @Bean
    public NewTopic dotingjavaJsonTopic(){
        return TopicBuilder.name(topicJsonName)
                .build();
    }
}
