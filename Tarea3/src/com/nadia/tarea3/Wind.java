package com.nadia.tarea3;

import org.w3c.dom.NamedNodeMap;

public class Wind {
	@SuppressWarnings("unused")
	private String speed_name = "not set", direction_code = "not set",
			direction_name = "not set";
	@SuppressWarnings("unused")
	private double speed_value, direction_value;

	public String toString() {
		return speed_name + ", " + direction_code;
	}
	
	public void setSpeed(NamedNodeMap n){
		speed_name = n.getNamedItem("name").getNodeValue();
		speed_value = Double.parseDouble(n.getNamedItem("value").getNodeValue());
	}
	
	public void setDirection(NamedNodeMap n){
		direction_code = n.getNamedItem("code").getNodeValue();
		direction_name = n.getNamedItem("name").getNodeValue();
		direction_value = Double.parseDouble(n.getNamedItem("value").getNodeValue());
	}

}
