package demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Payload;


@EnableBinding(Sink.class)
public class Receiver {

	private static Logger logger = LoggerFactory.getLogger(Receiver.class);

	 
	@StreamListener(target = Sink.INPUT, condition = "headers['eventType']=='QuoteCreatedEvent'")
	public void handleQuoteCreatedEvent(@Payload String payload) {
		logger.info("Received QuoteCreatedEvent: " + payload);
	}
	
	@StreamListener(target = Sink.INPUT, condition = "headers['eventType']=='QuoteCancelledEvent'")
	public void handleQuoteCancelledEvent(@Payload String payload) {
		logger.info("Received QuoteCreatedEvent: " + payload);
	}
	
	@StreamListener(target = Sink.INPUT)
	public void handleDefaultEvent(@Payload String payload) {
		logger.info("Received defaultEvent: " + payload);
	}
	

	
	

}
