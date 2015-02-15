package com.nadia.tarea3;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.w3c.dom.DOMException;
import org.w3c.dom.NamedNodeMap;

public class Item {
	private City city;
	private double humidity;
	private String humidity_unit = "not set", pressure_unit = "not set",
			clouds_name = "not set";
	private double pressure;
	private double clouds;
	private String precipitation = "not set";
	private Temperature temp;
	private Weather weather;
	@SuppressWarnings("unused")
	private Date lastUpdateS = new Date(0), lastUpdateU = new Date(0);
	private Wind wind = new Wind();

	public void setCity(City c) {
		city = c;
	}

	public City getCity() {
		return city;
	}

	public void setHumidity(NamedNodeMap e) {
		humidity = Double.parseDouble(e.getNamedItem("value").getNodeValue());
		humidity_unit = e.getNamedItem("unit").getNodeValue();
	}

	public String getHumidity() {
		return humidity + " " + humidity_unit;
	}

	public void setPressure(NamedNodeMap e) {
		pressure = Double.parseDouble(e.getNamedItem("value").getNodeValue());
		pressure_unit = e.getNamedItem("unit").getNodeValue();
	}

	public String getPressure() {
		return pressure + " " + pressure_unit;
	}

	public void setClouds(NamedNodeMap e) {
		clouds = Double.parseDouble(e.getNamedItem("value").getNodeValue());
		clouds_name = e.getNamedItem("name").getNodeValue();
	}

	public String getClouds() {
		return clouds_name;
	}

	public double getCloudsNumber() {
		return clouds;
	}

	public void setTemperature(Temperature t) {
		temp = t;
	}

	public Temperature getTemperature() {
		return temp;
	}

	public void setPrecipitation(NamedNodeMap e) {
		precipitation = e.getNamedItem("mode").getNodeValue();
	}

	public String getPrecipitation() {
		return precipitation;
	}

	public void setWeather(Weather w) {
		weather = w;
	}

	public Weather getWeather() {
		return weather;
	}

	public void setLastUpdate(NamedNodeMap e) {
		try {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			long miliseconds = Long.parseLong(e.getNamedItem("unix")
					.getNodeValue()) * 1000L;
			lastUpdateU = new Date(miliseconds);

			lastUpdateS = df.parse(e.getNamedItem("value").getNodeValue());
		} catch (DOMException | ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public String getLastUpdate(){ 
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm z");
		df.setTimeZone(Calendar.getInstance().getTimeZone());
		
		return df.format(lastUpdateU);
	}

	public void setWind(Wind w){
		wind = w;
	}
	
	public Wind getWind(){
		return wind;
	}

	public String toString() {
		String item_string = city.toString();
		item_string += "\tHumidity: " + getHumidity() + "\n";
		item_string += "\tTemperature: " + temp.toString();
		item_string += "\tPressure: " + getPressure() + "\n";
		item_string += "\tWind: " + wind.toString() + "\n";
		item_string += "\tClouds: " + getClouds() + "\n";
		item_string += "\tPrecipitation: " + getPrecipitation() + "\n";
		item_string += "\tWeather: " + weather.toString() + "\n";
		item_string += "LastUpdate: " + getLastUpdate() + "\n";

		return item_string;
	}

}
