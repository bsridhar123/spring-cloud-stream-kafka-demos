package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import demo.domain.EmployeeCreatedEvent;
import demo.domain.EmployeeTransferredEvent;
import demo.domain.Event;

@SpringBootApplication
@RestController
public class SendingApplication {

	@Autowired
	EventPublisher eventPublisher;
	
		
	public static void main(String[] args) {
		SpringApplication.run(SendingApplication.class, args);
	}
	
	@GetMapping("/{message}/{eventType}")
	public  void getMessage(
				@PathVariable(value="message")    String message,
				@PathVariable(value="eventType")  String eventType
	){
		
		Event event;
		if("1".equalsIgnoreCase(eventType)){
			EmployeeCreatedEvent empCreatedEvent=new EmployeeCreatedEvent();
			empCreatedEvent.setPayload("Created");
			eventPublisher.publishEvent(empCreatedEvent);
			System.out.println("Publishing Event: " + empCreatedEvent);
		}else{
			EmployeeTransferredEvent empTransferredEvent=new EmployeeTransferredEvent();
			empTransferredEvent.setPayload("Transferred");
			eventPublisher.publishEvent(empTransferredEvent);
			System.out.println("Publishing Event: " + empTransferredEvent);
		}
		
		
	}


}
