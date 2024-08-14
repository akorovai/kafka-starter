package dev.akorovai.kafka.config;

import org.springframework.beans.factory.annotation.Value;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

	@Value("${kafka.topic-name}")
	private String topicName;

	@Bean
	public NewTopic myTopic() {
		return TopicBuilder.name(topicName)
				       .partitions(5)
				       .build();
	}
}
