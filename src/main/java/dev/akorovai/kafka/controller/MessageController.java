package dev.akorovai.kafka.controller;

import dev.akorovai.kafka.payload.Student;
import dev.akorovai.kafka.producer.KafkaJsonProducer;
import dev.akorovai.kafka.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MessageController {
	private final KafkaProducer kafkaProducer;
	private final KafkaJsonProducer kafkaJsonProducer;

	@PostMapping
	public ResponseEntity<String> sendMessage( @RequestBody String message ) {
		kafkaProducer.sendMessage(message);
		return ResponseEntity.ok("Message queued successfully");
	}

	@PostMapping("/student")
	public ResponseEntity<String> sendStudent( @RequestBody Student student ) {
		kafkaJsonProducer.sendStudent(student);
		return ResponseEntity.ok("Message queued successfully");
	}
}
