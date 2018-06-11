package com.cshfym.services

import com.cshfym.services.kafka.KafkaConfiguration
import com.cshfym.services.kafka.KafkaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration
import org.springframework.context.annotation.Import
import org.springframework.context.annotation.PropertySource
import org.springframework.context.annotation.PropertySources
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@PropertySources([
    @PropertySource(value = "classpath:application.properties"),
    @PropertySource(value = "file:/usr/local/conf/spring-boot-docker/application.properties", ignoreResourceNotFound = true)
])
@SpringBootApplication
@RestController
@EnableAutoConfiguration(exclude = FlywayAutoConfiguration.class)
@Import([
    KafkaConfiguration.class
])

class Application {

    @Autowired
    KafkaService kafkaService

    @RequestMapping("/kafka")
    String sendMessage() {
        kafkaService.send("Message @ [${new Date()}]")
    }

    static void main(String[] args) {
        SpringApplication.run(Application.class, args)
    }

}