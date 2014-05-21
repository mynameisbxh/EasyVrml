package com.bxh.easyvrml.node.extend;

import com.bxh.easyvrml.impl.Event;

public class EventIn implements Event {
	private String eventIn;		//事件的名称
	
	private String 	  type;		//返回值类型

	
	public String getEventIn() {
		return eventIn;
	}

	public void setEventIn(String eventIn) {
		this.eventIn = eventIn;
	}

	public EventIn(String eventIn,String type) {
		this.eventIn = eventIn;
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
