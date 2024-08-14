package dev.akorovai.kafka.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class KafkaProducer {
	@Value("${kafka.topic-name}")
	private String topicName;

	// <String, String> because of key-value-types in YML file
	private final KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage( String message ) {

		log.info(String.format("Sending message: %s", message));

		kafkaTemplate.send(topicName, message);
	}
}
