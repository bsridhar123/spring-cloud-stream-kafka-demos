package demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.config.EventPublisher;
import com.demo.domain.EmployeeCreatedEvent;
import com.demo.domain.EmployeeTransferredEvent;

@RestController
public class SourceController {
	
	private static Logger logger = LoggerFactory.getLogger(SourceController.class);
	
	@Autowired
	EventPublisher eventPublisher;

	@GetMapping("/create/{message}")
	public void sendCreatedEvent(@PathVariable(value = "message") String message) {
		logger.info("Entering");
		EmployeeCreatedEvent empCreatedEvent = new EmployeeCreatedEvent();
		empCreatedEvent.setPayload(message);
		eventPublisher.publishEvent(empCreatedEvent);
		logger.info("Publishing Employee Created Event: " + empCreatedEvent);
		logger.info("Leaving");
	}

	@GetMapping("/transfer/{message}")
	public void sendTransferredEvent(@PathVariable(value = "message") String message) {
		logger.info("Entering");
		EmployeeTransferredEvent empTransferredEvent = new EmployeeTransferredEvent();
		empTransferredEvent.setPayload(message);
		eventPublisher.publishEvent(empTransferredEvent);
		logger.info("Publishing Employee Transferred Event: " + empTransferredEvent);
		logger.info("Leaving");
	}
}
