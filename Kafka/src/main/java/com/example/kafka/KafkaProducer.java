package com.example.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(KafkaProducer.class);
	
	
	//inject kafka template to create producer
	private KafkaTemplate<String,String> kafkaTemplate;

	//constructer based injection
	public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}
	
	//to send message to topic
	public void sendMessage(String message)
	{
		//to log msg in the console using logger
		LOGGER.info(String.format("Message sent %s",message));
		
		
		
		kafkaTemplate.send("practice", message);  //(topic name , data)
		
	}
	
	
	

}
