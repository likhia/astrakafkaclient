package com.demo.stream;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;

import org.apache.kafka.common.serialization.StringDeserializer;

public class Consumer {
    
    private Consumer() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {    
        
        String topicName = "MessageTopic";
        String grp_id = "app";
        
        Properties properties = KafkaProperties.getKafkaProperties();
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, MessageDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG,grp_id);  


        KafkaConsumer<String, Message> consumer = new KafkaConsumer<String, Message>(properties);
        
        consumer.subscribe(Arrays.asList(topicName));  
        
        //polling  
        while(true){  
            ConsumerRecords<String,Message> records=consumer.poll(Duration.ofMillis(1000));  
        
            for(ConsumerRecord<String,Message> record: records){  
                Message message = record.value();
                System.out.println("Key: "+ message.getKey() + ", Value:" +message.getValue());  
            }
        }  
    }
}
