package ws.msc.ClientTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import ws.msc.promotionsBusiness.EndUser;
import ws.msc.promotionsBusiness.Wish;
import ws.msc.promotionsServer.EndUserCatalogInterface;

public class Client {
	public static void main(String[] args) {
		try {
			Properties prop = new Properties();
			InputStream input = null;
			String ip;
			String serviceName;

			input = new FileInputStream("config.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			ip = prop.getProperty("service.ip") + ":"
					+ prop.getProperty("service.port");
			serviceName = prop.getProperty("service.name");

			URL url = new URL("http://" + ip + "/" + serviceName + "?wsdl");
			QName qname = new QName("http://promotionsBusiness.msc.ws/",
					"EndUserService");

			Service service = Service.create(url, qname);
			EndUserCatalogInterface catalogo = service
					.getPort(EndUserCatalogInterface.class);

			/*
			 * TEST NEW USER INSERT
			 */
//			EndUser user = new EndUser(new Date().getTime(), "newUser1", "th1s1s,yp4ssw0rd",
//					false, (double) 13234.123, (double) 12345.09, 1985);
//			catalogo.insertNewUser(user);

			/*
			 * TEST IF A USER CAN BE FOUND AND INSERT WISHES
			 */
//			 EndUser user = catalogo.signIn("ngarcia", "1234pass");
//			 if (user != null)
//			 System.out.println(user.toString());
//			 else
//			 System.out.println("user/password mismatch");
//			
//			 SimpleDateFormat sdf = new
//			 SimpleDateFormat("dd-M-yyyy hh:mm:ss");
//			
//			 try {
//			 catalogo.insertWish(user.getId(), new Wish(
//			 new Date().getTime(), sdf.parse("31-08-1982 10:20:56"),
//			 "this is my wish so I can test from AWS!"));
//			
//			 } catch (Exception e) { // TODO Auto-generated catch block
//			 e.printStackTrace();
//			 }

			/*
			 * TEST IF A USER CAN BE FOUND AND GET WISHES
			 */
			 EndUser user = catalogo.signIn("ngarcia", "1234pass");
			 if (user != null)
			 System.out.println(user.toString());
			 else
			 System.out.println("user/password mismatch");
			
			 List<Wish> myWishes = catalogo.getUserWishList(1234.0);
			 System.out.println("Wishes: "+myWishes.size());
			
			 for (Wish w : myWishes) {
			 System.out.println(w.toString());
			 }

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
