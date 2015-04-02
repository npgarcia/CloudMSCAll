package msc.ws.repositoryClient;

import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import msc.ws.repositoryServer.RepositoryInterface;

public class RepositoryClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			URL url = new URL("http://localhost:1235/Repository?wsdl");
			QName queue = new QName("http://repositoryServer.ws.msc/","Repository");
			
			Service service = Service.create(url,queue);
			RepositoryInterface repo = service.getPort(RepositoryInterface.class);
			
			//*******************************************************
			Image imagen = repo.getImage("test.png");
			
			JFrame ventana = new JFrame();
			ventana.setSize(400, 400);
			JLabel imagenLabel = new JLabel(new ImageIcon(imagen));
			ventana.add(imagenLabel);
			ventana.setVisible(true);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
