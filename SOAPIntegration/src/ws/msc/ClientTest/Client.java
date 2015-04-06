package ws.msc.ClientTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import ws.msc.promotionsBusiness.EndUser;
import ws.msc.promotionsBusiness.Wish;
import ws.msc.promotionsServer.EndUserCatalogInterface;

public class Client {
	public static void main(String[] args) {
		try {
			URL url = new URL("http://192.168.0.13:1234/EndUserCatalog?wsdl");
			QName qname = new QName("http://promotionsBusiness.msc.ws/",
					"EndUserService");

			Service service = Service.create(url, qname);
			EndUserCatalogInterface catalogo = service
					.getPort(EndUserCatalogInterface.class);

			/*
			 * TEST NEW USER INSERT EndUser user = new
			 * EndUser((double)1234.0,"ngarcia","1234pass",false,
			 * (double)13234.123,(double)12345.09,1985);
			 * catalogo.insertNewUser(user);
			 */

			/*
			 * TEST IF A USER CAN BE FOUND AND INSERT WISHES EndUser user =
			 * catalogo.signIn("ngarcia", "1234pass"); if(user!= null)
			 * System.out.println(user.toString()); else
			 * System.out.println("user/password mismatch");
			 * 
			 * SimpleDateFormat sdf = new
			 * SimpleDateFormat("dd-M-yyyy hh:mm:ss");
			 * 
			 * try { catalogo.insertWish(user.getId(), new Wish(new
			 * Date().getTime
			 * (),sdf.parse("31-08-1982 10:20:56"),"this is my wish"));
			 * 
			 * } catch (ParseException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */

			/*
			 * TEST IF A USER CAN BE FOUND AND INSERT WISHES
			 */
			EndUser user = catalogo.signIn("ngarcia", "1234pass");
			if (user != null)
				System.out.println(user.toString());
			else
				System.out.println("user/password mismatch");
			
			List<Wish> myWishes = catalogo.getUserWishList(user.getId());
			
			for(Wish w:myWishes){
				System.out.println(w.toString());
			}

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
