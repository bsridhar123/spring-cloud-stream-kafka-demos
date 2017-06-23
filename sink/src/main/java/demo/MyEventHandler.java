package demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Payload;

import demo.annotation.EventHandler;
import demo.domain.EmployeeCreatedEvent;
import demo.domain.EmployeeTransferredEvent;
import demo.domain.Event;


@EnableBinding(Sink.class)
class MyEventHandler{
	
	private static Logger logger = LoggerFactory.getLogger(MyEventHandler.class);

    
	@EventHandler(eventType = EmployeeCreatedEvent.EVENT_TYPE)
    public void handleEmployeeCreatedEvent(@Payload Event event) {
    	logger.info("Received EmployeeCreatedEvent: " + event);
     }
 
	@EventHandler(eventType = EmployeeTransferredEvent.EVENT_TYPE)
    public void handleEmployeeTransferredEvent(@Payload Event event) {
    	logger.info("Received EmployeeTransferredEvent: " + event);
     }
}
