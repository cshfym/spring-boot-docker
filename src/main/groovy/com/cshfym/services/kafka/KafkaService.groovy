package com.cshfym.services.kafka

import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class KafkaService {

    @Autowired
    KafkaProducer<String,String> kafkaProducer

    void send(String message) {

        def producerRecord = new ProducerRecord<String,String>("TestTopic", message)

        kafkaProducer.send(producerRecord)
    }

}
