

# Kafka Starter

## Overview

**Kafka Starter** is a Spring Boot application designed to integrate with Apache Kafka. It features both Kafka producer and consumer components, as well as RESTful endpoints for message transmission. This project serves as a robust foundation for developing event-driven applications using Kafka.

## Configuration

Configuration settings are specified in the `application.yml` file. Below are the key configurations:

### Kafka Consumer

```yaml
spring:
  kafka:
    consumer:
      bootstrap-servers: localhost:9092
      group-id: myGroup
      auto-offset-reset: earliest
      key-deserializer: org.apache.kafka.common.serialization.StringDeserializer
      value-deserializer: org.springframework.kafka.support.serializer.JsonDeserializer
      properties:
        spring.json.trusted.packages: '*'
```

- **`bootstrap-servers`**: Kafka broker addresses.
- **`group-id`**: Consumer group ID.
- **`auto-offset-reset`**: Offset reset policy for new consumers.
- **`key-deserializer`**: Deserializer for Kafka keys.
- **`value-deserializer`**: Deserializer for Kafka values (supports JSON).

### Kafka Producer

```yaml
spring:
  kafka:
    producer:
      bootstrap-servers: localhost:9092
      key-serializer: org.apache.kafka.common.serialization.StringSerializer
      value-serializer: org.springframework.kafka.support.serializer.JsonSerializer
```

- **`bootstrap-servers`**: Kafka broker addresses.
- **`key-serializer`**: Serializer for Kafka keys.
- **`value-serializer`**: Serializer for Kafka values (supports JSON).

### Server

```yaml
server:
  port: 1234
```

- **`port`**: The port on which the application will run.

### API Documentation

```yaml
springdoc:
  api-docs:
    path: /doc-api
```

- **`path`**: Endpoint for accessing API documentation.

## Project Structure

### Configuration

- **`KafkaTopicConfig.java`**: Configures Kafka topics based on properties defined in `application.yml`.

### Consumer

- **`KafkaConsumer.java`**: Handles message consumption:
  - `consumeMessage(String message)`: Logs plain text messages.
  - `consumeStudent(Student student)`: Logs messages containing `Student` objects.

### Controller

- **`MessageController.java`**: Provides REST endpoints for message submission:
  - `POST /api/v1/messages`: Endpoint to send plain text messages to Kafka.
  - `POST /api/v1/messages/student`: Endpoint to send `Student` objects to Kafka.

### Producer

- **`KafkaJsonProducer.java`**: Produces `Student` messages to Kafka.
- **`KafkaProducer.java`**: Produces plain text messages to Kafka.

### Payload

- **`Student.java`**: Represents the `Student` payload with fields `id`, `firstName`, and `lastName`.

## Dependencies

This project includes the following dependencies:

- `spring-boot-starter-web`
- `spring-kafka`
- `spring-boot-devtools`
- `lombok`
- `spring-boot-starter-test`
- `springdoc-openapi-starter-webmvc-ui`

## Build and Run

To build and run the application:

1. **Build**:
   ```bash
   mvn clean install
   ```

2. **Run**:
   ```bash
   mvn spring-boot:run
   ```

## API Documentation

API documentation is available at: `/doc-api`

