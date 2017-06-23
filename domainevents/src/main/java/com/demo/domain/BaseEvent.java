package com.demo.domain;

public class BaseEvent implements Event {
	
	String eventType;
	
	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	@Override
	public String toString() {
		return "BaseEvent [eventType=" + eventType + "]";
	}

	public String getPayload() {
		return null;
	}

}
