package com.nadia.tarea3;

import java.util.Collection;
import java.util.Iterator;

public class Tarea3 {
	public static void main(String[] args) {

		WeatherLikeCity test = new WeatherLikeCity();
		String city = "Guadalajara";
		String units = WeatherLikeCity.UNITS_METRIC;
		
		Collection<Item> weather = test.getWeather(city, units);
		Iterator<Item> iterator = weather.iterator();
		
		while(iterator.hasNext()){
			System.out.println(iterator.next().toString());
		}
	}
}
