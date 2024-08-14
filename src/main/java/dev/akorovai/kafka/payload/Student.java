package dev.akorovai.kafka.payload;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
	private int id;
	private String firstName;
	private String lastName;
}
