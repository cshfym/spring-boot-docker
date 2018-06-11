package com.cshfym.server.models

import org.apache.kafka.common.serialization.Serializer

class PayloadSerializer implements Serializer {

    byte[] serialize(String s, Object o) {

        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream()
            ObjectOutputStream oos = new ObjectOutputStream(baos)
            oos.writeObject(o)
            oos.close()
            byte[] b = baos.toByteArray()
            b
        } catch (IOException e) {
            new byte[0]
        }
    }

    void configure(Map map, boolean b) { }

    void close() { }
}