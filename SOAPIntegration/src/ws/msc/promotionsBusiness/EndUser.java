package ws.msc.promotionsBusiness;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="EndUser")
@XmlType(propOrder={"id","userName","password","isMale","longitude","latitude","yearOfBirth"})
public class EndUser {

	private double id;
	private String userName;
	private String password;
	private boolean isMale;
	private double longitude;
	private double latitude;
	private int yearOfBirth;
	
	
	public EndUser(){
		super();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String user = id +"\t"+ userName+"\t"+password+"\t";
		if(isMale)
			user += "male\t";
		else
			user += "female\t";
		
		user+= longitude+"\t"+latitude+"\t"+yearOfBirth;
		
		return user;
	}
	
	public EndUser(double id, String userName, String password, boolean isMale,
			double longitude, double latitude, int yearOfBirth) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.isMale = isMale;
		this.longitude = longitude;
		this.latitude = latitude;
		this.yearOfBirth = yearOfBirth;
	}
	
	@XmlElement(name="id")
	public double getId() {
		return id;
	}

	public void setId(double id) {
		this.id = id;
	}

	@XmlElement(name="userName")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@XmlElement(name="password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@XmlElement(name="isMale")
	public boolean getIsMale() {
		return isMale;
	}

	public void setIsMale(boolean isMale) {
		this.isMale = isMale;
	}

	@XmlElement(name="longitude")
	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	@XmlElement(name="latitude")
	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	@XmlElement(name="yearOfBirth")
	public int getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	

}
