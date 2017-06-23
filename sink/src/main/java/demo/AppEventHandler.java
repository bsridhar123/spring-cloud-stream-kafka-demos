package demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Payload;

import com.demo.annotation.EventHandler;
import com.demo.domain.EmployeeCreatedEvent;
import com.demo.domain.EmployeeTransferredEvent;
import com.demo.domain.Event;


@EnableBinding(Sink.class)
class AppEventHandler{
	
	private static Logger logger = LoggerFactory.getLogger(AppEventHandler.class);

    
	@EventHandler(eventType = EmployeeCreatedEvent.EVENT_TYPE)
    public void handleEmployeeCreatedEvent(@Payload Event event) {
    	logger.info("Received EmployeeCreatedEvent: " + event);
     }
 
	@EventHandler(eventType = EmployeeTransferredEvent.EVENT_TYPE)
    public void handleEmployeeTransferredEvent(@Payload Event event) {
    	logger.info("Received EmployeeTransferredEvent: " + event);
     }
	
}
