package com.demo.stream;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import org.apache.kafka.common.serialization.StringSerializer;


public class Publisher {

    public static void main(String[] args) {       
        
        Message message = new Message(args[0], args[1]);
    
        String topicName = "MessageTopic";

        Properties properties = KafkaProperties.getKafkaProperties();
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, MessageSerializer.class.getName());

        KafkaProducer<String, Message> producer = new KafkaProducer<String, Message>(properties);
        
        ProducerRecord<String, Message> record=new ProducerRecord<String, Message>(topicName,  message);

        producer.send(record);
        producer.flush();
        producer.close();
    }
}
