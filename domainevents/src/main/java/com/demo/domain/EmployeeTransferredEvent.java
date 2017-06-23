package com.demo.domain;

public class EmployeeTransferredEvent extends BaseEvent {

	public static final String EVENT_TYPE="employeeTransferred";
	String payload;

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	@Override
	public String toString() {
		return "EmployeeTransferredEvent [payload=" + payload + "]";
	}
	
	
}
