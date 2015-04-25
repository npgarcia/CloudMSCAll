package RestExample.infov3;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Cliente {
	public String edad;
	public String name;

	public Cliente(String edad, String name) {
		this.edad = edad;
		this.name = name;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name +" edad: "+this.edad;
	}

}
