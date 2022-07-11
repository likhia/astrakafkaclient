This application is built using Apache Kafka version 3.2.0.   Edit the /src/main/resources/kafka.properties for the properties to connect to Kafka / Astra Streaming Tenant. 

# To compile the project
mvn clean compile

# To run as Publisher
mvn compile exec:java -Dexec.mainClass="com.demo.stream.Publisher"  -Dexec.args="key value"

# To run as Consumer
mvn exec:java -Dexec.mainClass="com.demo.stream.Consumer"