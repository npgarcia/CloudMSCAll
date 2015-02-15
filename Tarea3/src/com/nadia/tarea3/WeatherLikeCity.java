package com.nadia.tarea3;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class WeatherLikeCity {

	public static final String UNITS_IMPERIAL = "&units=imperial";
	public static final String UNITS_METRIC = "&units=metric";
	public static final String UNITS_INTERNAL = "";

	private City getCity(Node city) {
		City child_city = new City(city.getAttributes());
		NodeList city_content = city.getChildNodes();
		int count = city_content.getLength();
		for (int i = 0; i < count; i++) {
			Node child = city_content.item(i);
			if (child.getNodeType() == Node.ELEMENT_NODE) {
				/*
				 * coord country sun
				 */
				switch (child.getNodeName()) {
				case "coord":
					child_city.setCoordenates(child.getAttributes());
					break;
				case "country":
					child_city.setCountry(child.getTextContent());
					break;
				case "sun":
					child_city.setSun(child.getAttributes());
					break;
				default:
					break;
				}
			}
		}

		return child_city;
	}

	private Wind getWind(Node n) {
		Wind the_wind = new Wind();

		NodeList wind_content = n.getChildNodes();
		int count = wind_content.getLength();

		for (int i = 0; i < count; i++) {
			Node child = wind_content.item(i);
			if (child.getNodeType() == Node.ELEMENT_NODE) {
				/*
				 * speed direction
				 */
				switch (child.getNodeName()) {
				case "speed":
					the_wind.setSpeed(child.getAttributes());
					break;
				case "direction":
					the_wind.setDirection(child.getAttributes());
					break;
				}
			}
		}

		return the_wind;
	}

	private Item getItem(NodeList items) {
		int countContent = items.getLength();
		Item xmlItem = new Item();

		for (int i = 0; i < countContent; i++) {
			Node child = items.item(i);
			if (child.getNodeType() == Node.ELEMENT_NODE) {
				/*
				 * city temperature humidity pressure wind clouds precipitation
				 * weather lastupdate
				 */
				switch (child.getNodeName()) {
				case "city":
					xmlItem.setCity(getCity(child));
					break;
				case "temperature":
					xmlItem.setTemperature(new Temperature(child
							.getAttributes()));
					break;
				case "humidity":
					xmlItem.setHumidity(child.getAttributes());
					break;
				case "pressure":
					xmlItem.setPressure(child.getAttributes());
					break;
				case "wind":
					xmlItem.setWind(getWind(child));
					break;
				case "clouds":
					xmlItem.setClouds(child.getAttributes());
					break;
				case "precipitation":
					xmlItem.setPrecipitation(child.getAttributes());
					break;
				case "weather":
					xmlItem.setWeather(new Weather(child.getAttributes()));
					break;
				case "lastupdate":
					xmlItem.setLastUpdate(child.getAttributes());
					break;
				}
			}
		}

		return xmlItem;
	}

	public Collection<Item> getWeather(String city, String units) {
		if (city.equals("")) {
			System.out.println("El parametro city no debe estar vacío");
			return null;
		}

		String url = "http://api.openweathermap.org/data/2.5/find?type=like&mode=xml&"
				+ "q=" + city;

		switch (units) {
		case UNITS_IMPERIAL:
		case UNITS_METRIC:
		case UNITS_INTERNAL:
			url += units;
			break;
		default:
			System.out.println("El parametro units no existe");
			return null;
		}

		Collection<Item> items = new ArrayList<Item>();

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;

		System.out.println(url + "\n");
		try {
			db = dbf.newDocumentBuilder();
			Document doc = db.parse(new URL(url).openStream());

			Element cities = doc.getDocumentElement();
			NodeList list = cities.getElementsByTagName("item");
			int countCities = list.getLength();

			for (int i = 0; i < countCities; i++) {
				Node item = list.item(i);
				NodeList item_content = item.getChildNodes();
				items.add(getItem(item_content));
			}

		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			items = null;
		}

		return items;

	}
}
