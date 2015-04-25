package ws.msc.promotionsBusiness;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.jws.WebService;

import ws.msc.promotionsServer.EndUserCatalogInterface;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;

import msc.cassandra.operations.CassandraConnector;
import ws.msc.promotionsBusiness.EndUser;
import ws.msc.promotionsBusiness.Wish;

@WebService(endpointInterface = "ws.msc.promotionsServer.EndUserCatalogInterface", portName = "EndUserPort", serviceName = "EndUserService")
public class EndUserCatalogImpl implements EndUserCatalogInterface {

	CassandraConnector connector = new CassandraConnector();
	HashMap<Double, EndUser> activeUsers = new HashMap<Double, EndUser>();

	String path;

	public EndUserCatalogImpl() {
		
		connector.connect();
		
	}

	@Override
	public void insertNewUser(EndUser user) {

		// TODO logic to verify if the user is already in db
		String query = "INSERT INTO users (id, userName, password, isMale, longitude, latitude, yearOfBirth) VALUES (";

		query += user.getId() + ", ";
		query += "'" + user.getUserName() + "', ";
		query += "'" + user.getPassword() + "', ";
		query += user.getIsMale() + ", ";
		query += user.getLatitude() + ",";
		query += user.getLongitude() + ",";
		query += user.getYearOfBirth() + ");";

		System.out.println(query);

		connector.execute(query);

		activeUsers.put(user.getId(), user);
	}

	@Override
	public boolean insertWish(double userId, Wish theWish) {
		if (activeUsers.containsKey(userId)) {
			// INSERT INTO wishes (id, userId, expireDate, wishName);
			String query = "INSERT INTO wishes (id, userId, expireDate, wishName) VALUES (";

			query += theWish.getId() + ",";
			query += userId + ",";
			query += theWish.getExpireDate().getTime() + ",";
			query += "'" + theWish.getWishName() + "');";

			System.out.println(query);

			connector.execute(query);

			return true;
		} else {
			return false;
		}
	}

	@Override
	public EndUser signIn(String name, String pass) {

		// SELECT password FROM users WHERE username='ngarcia';
		String query = "SELECT * FROM users WHERE username='";

		query += name + "';";

		System.out.println(query);

		ResultSet rs = connector.execute(query);
		Row row = rs.one();
		if (row == null)
			return null;

		String password = row.getString("password");

		if (password.equals(pass)) {
			EndUser user = new EndUser();
			user.setId(row.getDouble("id"));

			if (!activeUsers.containsKey((user.getId()))) {
				user.setIsMale(row.getBool("isMale"));
				user.setLatitude(row.getDouble("latitude"));
				user.setLongitude(row.getDouble("longitude"));
				user.setPassword(row.getString("password"));
				user.setUserName(row.getString("username"));
				user.setYearOfBirth(row.getInt("yearofbirth"));
				activeUsers.put(user.getId(), user);
				return user;
			} else {
				return activeUsers.get(user.getId());
			}
		} else
			return null;
	}

	@Override
	public List<Wish> getUserWishList(double userId) {
		// TODO Auto-generated method stub
		if (activeUsers.containsKey(userId)) {
			List<Wish> wishes = new ArrayList<Wish>();
			String query = "SELECT * FROM wishes WHERE userId=";
			query += userId + ";";

			System.out.println(query);

			ResultSet rs = connector.execute(query);
			Iterator<Row> results = rs.iterator();

			while (results.hasNext()) {
				Row r = results.next();
				wishes.add(new Wish(r.getDouble("id"), r.getDate("expireDate"),
						r.getString("wishName")));
			}

			return wishes;
		} else {
			System.out.println(userId + " IS NOT AN ACTIVE USER");
			return null;
		}
	}

	@Override
	public void signOut(double userId) {

		if (activeUsers.containsKey(userId))
			activeUsers.remove(userId);

		return;
	}

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
