package demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Profile;
import org.springframework.messaging.handler.annotation.Payload;

import demo.domain.Event;


@Profile("Dummy")
@EnableBinding(Sink.class)
public class Receiver {

	private static Logger logger = LoggerFactory.getLogger(Receiver.class);

	 
	//@StreamListener(target = Sink.INPUT, condition = "headers['eventType']=='EmployeeCreatedEvent'")
	@StreamListener(target = Sink.INPUT, condition = "payload.eventType=='EmployeeCreatedEvent'")
	public void handleEmployeeCreatedEvent(@Payload Event event) {
		logger.info("Received EmployeeCreatedEvent: " + event);
	}
	
	//@StreamListener(target = Sink.INPUT, condition = "headers['eventType']=='EmployeeTransferredEvent'")
	@StreamListener(target = Sink.INPUT, condition = "payload.eventType=='EmployeeTransferredEvent'")
	public void handleEmployeeTransferredEvent(@Payload Event event) {
		logger.info("Received EmployeeTransferredEvent: " + event);
	}
	
	/*@StreamListener(target = Sink.INPUT)
	public void handleDefaultEvent(@Payload String payload,@Header("eventType") String eventType) {
		logger.info("Received payload: " + payload);
		logger.info("Received event: " + eventType);
	}*/
	
	/*@StreamListener(target = Sink.INPUT)
	public void handleDefaultEvent(Message<String> message) {
		String payload=(String) message.getPayload();
		MessageHeaders headers=message.getHeaders();
		logger.info("Received message: " + message);
		logger.info("Received payload: " + payload);
		logger.info("Received headers: " + headers);
		logger.info("Received headers: " + headers.toString());
		logger.info("Received eventType header: " + headers.get("eventType"));
	}
*/
	
	

}
