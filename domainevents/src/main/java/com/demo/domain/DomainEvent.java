package com.demo.domain;

public enum DomainEvent {
	EmployeeCreatedEvent("empCreated"),
	EmployeeTransferredEvent("empTransferred"),
	EmployeeFiredEvent("empFired");

	 private String event;

	DomainEvent(String event) {
	        this.event = event;
	    }

	    public String event() {
	        return event;
	    }
}
