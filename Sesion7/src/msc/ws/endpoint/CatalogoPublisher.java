package msc.ws.endpoint;

import javax.xml.ws.Endpoint;

import msc.ws.sesion5.CatalogoMaterias;

public class CatalogoPublisher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Endpoint.publish("http://localhost:1234/MateriasCatalogo", new CatalogoMaterias());
	}

}
