package com.nadia.tarea3;

import org.w3c.dom.NamedNodeMap;

public class Temperature {
	private String unit = "not set";
	@SuppressWarnings("unused")
	private double value, min, max;
	
	public Temperature(NamedNodeMap e){
		unit = e.getNamedItem("unit").getNodeValue();
		value = Double.parseDouble(e.getNamedItem("value").getNodeValue());
		max = Double.parseDouble(e.getNamedItem("max").getNodeValue());
		min = Double.parseDouble(e.getNamedItem("min").getNodeValue());
	}
	
	public String toString(){
		return value + " " + unit + "\n";
	}
}
