package com.nadia.tarea4;

import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class RequestParser {

	public static void getProductPrice(String name, int size) {
		System.out.println(name + " " + size);
	}

	public static void GetProductPriceRequest(NodeList parameters) {
		String productName = "not set";
		int size = -1;

		for (int i = 0; i < parameters.getLength(); i++) {
			Node p = parameters.item(i);

			switch (p.getNodeName()) {
			case "m:productName":
				productName = p.getTextContent();
				break;
			case "m:size":
				size = Integer.parseInt(p.getTextContent());
				break;
			}
		}

		getProductPrice(productName, size);

	}

	public static void main(String[] args) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;

		try {
			db = dbf.newDocumentBuilder();
			String path = System.getProperty("user.dir");
			System.out.println(path + "/xml/request.xml");
			Document doc = db.parse(new FileInputStream(path
					+ "/xml/request.xml"));

			NodeList message = doc.getElementsByTagName("soap:Body");

			for (int b = 0; b < message.getLength(); b++) {
				Node body = message.item(b);
				NodeList functions = body.getChildNodes();

				for (int i = 0; i < functions.getLength(); i++) {
					Node function = functions.item(i);

					switch (function.getNodeName()) {
					case "m:GetProductPriceRequest":
						NodeList parameters = function.getChildNodes();
						GetProductPriceRequest(parameters);
						break;
					}
				}

			}

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
