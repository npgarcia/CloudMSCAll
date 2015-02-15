package com.nadia.tarea3;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.w3c.dom.NamedNodeMap;

public class City {

	String id;
	String name;
	float coord_lon, coord_lat;
	String country;
	Date sunrise, sunset;

	public String toString() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss 'Local time'");

		String city_string = "ID: " + id + " " + name + ", " + country + "\n";
		city_string += "\tCoordenates: " + coord_lon + ", " + coord_lat + "\n";
		city_string += "\tSunrise: " + df.format(sunrise) + "\n";
		city_string += "\tSunset: " + df.format(sunset) + "\n";

		return city_string;
	}

	public City(NamedNodeMap e) {
		id = e.getNamedItem("id").getNodeValue();
		name = e.getNamedItem("name").getNodeValue();
	}

	public void setCoordenates(NamedNodeMap e) {
		coord_lon = Float.parseFloat(e.getNamedItem("lon").getNodeValue());
		coord_lat = Float.parseFloat(e.getNamedItem("lat").getNodeValue());
	}

	public void setCountry(String e) {
		country = e;
	}

	public void setSun(NamedNodeMap e) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		try {
			sunrise = df.parse(e.getNamedItem("rise").getNodeValue());
			sunset = df.parse(e.getNamedItem("set").getNodeValue());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
