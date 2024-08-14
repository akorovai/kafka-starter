package dev.akorovai.kafka.producer;

import dev.akorovai.kafka.payload.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class KafkaJsonProducer {
	@Value("${kafka.topic-name}")
	private String topicName;

	private final KafkaTemplate<String, Student> kafkaTemplate;

	public void sendStudent( Student student ) {
		log.info("Sending student: {}", student);
		Message<Student> message = MessageBuilder.withPayload(student).setHeader(KafkaHeaders.TOPIC, topicName).build();
		kafkaTemplate.send(message);
	}
}
