package com.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.demo.domain.Event;

@Component
@EnableBinding(Source.class)
public class EventPublisher {
	
	private static Logger logger = LoggerFactory.getLogger(EventPublisher.class);
	
	@Autowired
	private Source source;                


	public void  publishEvent(Event event) {
		logger.info("Received event...:" + event);
		logger.info("Constructing Message: ");
        Message<Event> myMessage = MessageBuilder.withPayload(event).build();
        logger.info("Publishing Event...:" + event);
        source.output().send(myMessage);
	 }

}
