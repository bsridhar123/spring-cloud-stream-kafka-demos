package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import demo.domain.Event;

@Component
@EnableBinding(Source.class)
public class EventPublisher {
	@Autowired
	private Source source;                


	public void  publishEvent(Event event) {
        System.out.println("Received event...:" + event);
        System.out.println("Constructing Message: ");
        Message<Event> myMessage = MessageBuilder.withPayload(event).build();
        System.out.println("Publishing Event...:" + event);
        source.output().send(myMessage);
	 }

}
