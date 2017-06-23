package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import demo.domain.EmployeeCreatedEvent;
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
		
		
		EmployeeCreatedEvent employeeCreatedEvent=new EmployeeCreatedEvent();
		employeeCreatedEvent.setPayload("Welcome");
		System.out.println("Publishing Event: " + employeeCreatedEvent);
		eventPublisher.publishEvent(employeeCreatedEvent);
	}


}
