package com.demo.stream;

import java.io.InputStream;
import java.util.Properties;

import java.io.IOException;

public class KafkaProperties {
    
    public static Properties getKafkaProperties() {
        Properties properties = new Properties();

        
        try (InputStream inputStream = KafkaProperties.class.getClassLoader().getResourceAsStream("kafka.properties")) {
            properties.load(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties; 
    }
}
