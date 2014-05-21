package com.bxh.easyvrml.node.extend;

import com.bxh.easyvrml.impl.Event;

public class EventOut implements Event {
	private String eventOut;

	private String type;
	
	public EventOut(String eventOut,String type) {
		this.eventOut = eventOut;
		this.type = type;
	}

	public String getEventOut() {
		return eventOut;
	}

	public void setEventOut(String eventOut) {
		this.eventOut = eventOut;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
