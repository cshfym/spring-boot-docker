package com.cshfym.server.config

import com.cshfym.server.models.SimpleMessage
import org.apache.kafka.clients.producer.KafkaProducer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class KafkaConfiguration {

    @Value('${bootstrap.servers}')
    String BOOTSTRAP_SERVERS

    final static String STRING_SERIALIZER = "org.apache.kafka.common.serialization.StringSerializer"
    final static String PAYLOAD_SERIALIZER = "com.cshfym.server.models.PayloadSerializer"

    @Bean
    KafkaProducer<String,SimpleMessage> kafkaProducer() {

        Properties properties = new Properties()

        properties.put("bootstrap.servers", BOOTSTRAP_SERVERS)
        properties.put("key.serializer", STRING_SERIALIZER)
        properties.put("value.serializer", PAYLOAD_SERIALIZER)

        new KafkaProducer<String,SimpleMessage>(properties)
    }
}
