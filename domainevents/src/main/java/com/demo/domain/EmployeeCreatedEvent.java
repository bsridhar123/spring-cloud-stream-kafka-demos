package com.demo.domain;

public class EmployeeCreatedEvent extends BaseEvent {
	
	public static final String EVENT_TYPE="employeeCreated";
	
	String payload;

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	@Override
	public String toString() {
		return "EmployeeCreatedEvent [payload=" + payload + "]";
	}
	
}
