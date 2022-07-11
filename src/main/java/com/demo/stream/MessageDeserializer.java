package com.demo.stream;

import java.io.IOException;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import org.apache.kafka.common.errors.SerializationException;

public class MessageDeserializer implements Deserializer<Message> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Message deserialize(String topic, byte[] data) {
        try {
            return objectMapper.readValue(data, Message.class);
        } catch (IOException e) {
            throw new SerializationException(e);
        }
    }
}