package com.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafka.KafkaProducer;

@RestController
@RequestMapping("/api/kafka")
public class MessageController {
	
	private KafkaProducer kafkaproducer;

	public MessageController(KafkaProducer kafkaproducer) {
		super();
		this.kafkaproducer = kafkaproducer;
	}

	//create rest api endpoint 
	
	@GetMapping("/publish")
	public ResponseEntity<String> publish(@RequestParam("message") String message)
	{
		//calling kafka producer to send the message
		kafkaproducer.sendMessage(message);
		//to give as a message to user that message hasa sent to the topic
		return ResponseEntity.ok("Message sent to the topic");
		
	}
	
	

}
