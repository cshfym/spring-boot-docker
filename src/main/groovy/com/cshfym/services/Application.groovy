package com.cshfym.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
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