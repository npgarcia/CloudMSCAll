package msc.ws.cliente;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import msc.ws.sesion5.CatalogoMaterias;
import msc.ws.sesion5.CatalogoMateriasInterface;

public class CatalogoCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		try {
			URL url = new URL("http://localhost:1235/MateriasCatalogo?wsdl");
			QName qname = new QName("http://sesion5.ws.msc/","CatalogoITESOService");
			
			Service service = Service.create(url,qname);
			CatalogoMateriasInterface catalogo = service.getPort(CatalogoMateriasInterface.class);
			
			Iterator<String> i = catalogo.obtenerMateriasPorCategoria("Ciencia basica").iterator();
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
