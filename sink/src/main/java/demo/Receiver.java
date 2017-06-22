package demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;


@EnableBinding(Sink.class)
public class Receiver {

	private static Logger logger = LoggerFactory.getLogger(Receiver.class);

	 
	@StreamListener(target = Sink.INPUT, condition = "headers['eventType']=='EmployeeCreatedEvent'")
	public void handleEmployeeCreatedEvent(@Payload String payload) {
		logger.info("Received QuoteCreatedEvent: " + payload);
	}
	
	@StreamListener(target = Sink.INPUT, condition = "headers['eventType']=='EmployeeTransferredEvent'")
	public void handleEmployeeTransferredEvent(@Payload String payload) {
		logger.info("Received EmployeeTransferredEvent: " + payload);
	}
	
	@StreamListener(target = Sink.INPUT)
	public void handleDefaultEvent(@Payload String payload,@Header("eventType") String eventType) {
		logger.info("Received payload: " + payload);
		logger.info("Received event: " + eventType);
	}
	
	/*@StreamListener(target = Sink.INPUT)
	public void handleDefaultEvent(Message<String> message) {
		String payload=(String) message.getPayload();
		MessageHeaders headers=message.getHeaders();
		logger.info("Received message: " + message);
		logger.info("Received payload: " + payload);
		logger.info("Received headers: " + headers);
		logger.info("Received headers: " + headers.toString());
		logger.info("Received eventType header: " + headers.get("eventType"));
	}*/

	
	

}
