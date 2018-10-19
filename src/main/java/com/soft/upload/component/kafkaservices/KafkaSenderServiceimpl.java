package com.soft.upload.component.kafkaservices;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaSenderServiceimpl {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaSenderServiceimpl.class);

	@Autowired
	private KafkaTemplate<String, HashMap<String, Object>> kafkaTemplate;
	@Value("${app.topic.foo}")
	private String topic;

	public void sendkafkaMsg(HashMap<String, Object> msgmap) {
		try {
			kafkaTemplate.send(topic, msgmap);
			System.out.println("sending message=" + msgmap + "to topic=" + topic + "");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
