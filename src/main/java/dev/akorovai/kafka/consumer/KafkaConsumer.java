package dev.akorovai.kafka.consumer;

import dev.akorovai.kafka.payload.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.KafkaListeners;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer {
//	@KafkaListener(topics = "my-topic", groupId = "myGroup")
	public void consumeMessage( String message ) {
		log.info("Consuming message::" + message);
	}

	@KafkaListener(topics = "my-topic", groupId = "myGroup")
	public void consumeStudent( Student student) {
		log.info("Consuming student::" + student.toString());
	}
}
