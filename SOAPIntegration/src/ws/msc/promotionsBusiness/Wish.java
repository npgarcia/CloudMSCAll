package ws.msc.promotionsBusiness;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Wish")
@XmlType(propOrder = { "id", "expireDate", "wishName" })
public class Wish {

	private double id;
	private Date expireDate;
	private String wishName;

	public Wish() {
		super();
	}

	public Wish(double id, Date expireDate, String wishName) {
		super();
		this.id = id;
		this.expireDate = expireDate;
		this.wishName = wishName;
	}
	
	public String toString(){
		String wish = id +"\t"+ expireDate.toString() +"\t"+ wishName;
		return wish;
	}

	@XmlElement(name = "id")
	public double getId() {
		return id;
	}

	public void setId(double id) {
		this.id = id;
	}

	@XmlElement(name = "expireDate")
	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	@XmlElement(name = "wishName")
	public String getWishName() {
		return wishName;
	}

	public void setWishName(String wishName) {
		this.wishName = wishName;
	}

}
