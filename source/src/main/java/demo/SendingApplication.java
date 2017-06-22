package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SendingApplication {

	@Autowired
	CustomMessageSource customMessageSource;
	
	/*@Autowired
	EventPublisher eventPublisher;*/
	
	public static void main(String[] args) {
		SpringApplication.run(SendingApplication.class, args);
	}
	
	@GetMapping("/{message}/{eventType}")
	public  void getMessage(
				@PathVariable(value="message")    String message,
				@PathVariable(value="eventType")  String eventType
	){
		System.out.println("Received Message: " + message);
		System.out.println("Received eventType: " + eventType);
		System.out.println("Sending Message With header...");
		customMessageSource.sendMessage(message,eventType);
	}


}
