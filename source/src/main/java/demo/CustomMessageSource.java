	package demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.beans.factory.annotation.Autowired;

@Component
@EnableBinding(Source.class)
public class CustomMessageSource {
	@Autowired
	private Source source;                

	public void  timerMessageSource(String message) {
                 System.out.println("Writing Message...");
		 source.output().send(MessageBuilder.withPayload(message).build());
	 }

}
