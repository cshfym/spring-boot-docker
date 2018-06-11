package com.cshfym.server.services

import com.cshfym.server.models.SimpleMessage
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class KafkaService {

    @Autowired
    KafkaProducer<String,SimpleMessage> kafkaProducer

    void send(SimpleMessage simpleMessage) {

        def producerRecord = new ProducerRecord<String,SimpleMessage>("TestTopic", simpleMessage)

        kafkaProducer.send(producerRecord)
    }

}
