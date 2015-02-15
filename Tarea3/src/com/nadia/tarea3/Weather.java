package com.nadia.tarea3;

import org.w3c.dom.NamedNodeMap;

public class Weather {
	@SuppressWarnings("unused")
	private int number;
	private String value = "not set";
	@SuppressWarnings("unused")
	private String icon = "not set";
	
	public Weather(NamedNodeMap e){
		number = Integer.parseInt(e.getNamedItem("number").getNodeValue());
		value = e.getNamedItem("value").getNodeValue();
		icon = e.getNamedItem("icon").getNodeValue();
	}
	
	public String toString(){
		return value;
	}
}
