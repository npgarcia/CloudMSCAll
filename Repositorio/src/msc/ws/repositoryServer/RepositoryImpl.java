package msc.ws.repositoryServer;

import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.jws.WebService;

@WebService(endpointInterface = "msc.ws.repositoryServer.RepositoryInterface", serviceName = "Repository")
public class RepositoryImpl implements RepositoryInterface {

	final static String path = "/Users/ngarcia/Documents/ITESO/Maestria/Cloud/Imagenes/";

	@Override
	public Image getImage(String name) {
		try {
			System.out.println("Solicitud de la imagen " + name);
			File image = new File(path + name);
			System.out.println("\tPath: " + image.getPath());
			System.out.println("\tName: " + image.getName());

			return ImageIO.read(image);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
