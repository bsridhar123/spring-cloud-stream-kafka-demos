package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Source.class)
public class CustomMessageSource {
	@Autowired
	private Source source;                


	public void  sendMessage(String payload,String eventType) {
        System.out.println("Received payload...:" + payload);
        System.out.println("Received eventType...:" + eventType);
        System.out.println("Constructing Message: ");
		Message<String> myMessage = MessageBuilder.withPayload(payload)
                .setHeader("eventType", eventType)
                .build();
		System.out.println("Sending Message...");
        source.output().send(myMessage);
	 }

}
