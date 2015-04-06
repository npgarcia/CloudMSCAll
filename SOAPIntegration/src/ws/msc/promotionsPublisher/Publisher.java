package ws.msc.promotionsPublisher;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.xml.ws.Endpoint;

import ws.msc.promotionsBusiness.EndUserCatalogImpl;


public class Publisher {

	public static void main(String[] args) {
		
		Properties prop = new Properties();
		InputStream input = null;
		String ip;
		String port;
		String service;

		try {

			input = new FileInputStream("config.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			ip = prop.getProperty("service.ip");
			port = prop.getProperty("service.port");
			service = prop.getProperty("service.name");


			Endpoint.publish("http://"+ip+":"+port+"/"+service, new EndUserCatalogImpl());

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
