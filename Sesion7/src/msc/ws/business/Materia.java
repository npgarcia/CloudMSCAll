package msc.ws.business;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="Materia")
@XmlType(propOrder={"clave","nombre","carrera"})
public class Materia {
	private int clave;
	private String nombre;
	private Carrera carrera;
	
	public Materia() {
		super();
	}
	public Materia(int clave, String nombre, Carrera carrera) {
		super();
		this.clave = clave;
		this.nombre = nombre;
		this.carrera = carrera;
	}
	
	@XmlElement(name="clave")
	public int getClave() {
		return clave;
	}
	public void setClave(int clave) {
		this.clave = clave;
	}
	
	@XmlElement(name="nombre")
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@XmlElement(name="carrera")
	public Carrera getCarrera() {
		return carrera;
	}
	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}
	
}
