package com.cshfym.services

import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import org.springframework.stereotype.Service

@Service
class KafkaService {

    Properties properties = new Properties()
    KafkaProducer<String,String> kafkaProducer

    KafkaService() {

        properties.put("bootstrap.servers", "159.65.72.42:9092")
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

        kafkaProducer = new KafkaProducer<String,String>(properties)
    }

    void send(String message) {

        def producerRecord = new ProducerRecord<String,String>("TestTopic", message)

        kafkaProducer.send(producerRecord)
    }

}
