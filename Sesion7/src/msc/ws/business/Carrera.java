package msc.ws.business;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="Carrera")
@XmlType(propOrder={"nombre","alumnos","generacion"})
public class Carrera {
	private String nombre;
	private int alumnos;
	private int generacion;
	
	@XmlElement(name="nombre")
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@XmlElement(name="alumnos")
	public int getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(int alumnos) {
		this.alumnos = alumnos;
	}

	@XmlElement(name="generacion")
	public int getGeneracion() {
		return generacion;
	}

	public void setGeneracion(int generacion) {
		this.generacion = generacion;
	}

	public Carrera(String nombre, int alumnos, int generacion) {
		super();
		this.nombre = nombre;
		this.alumnos = alumnos;
		this.generacion = generacion;
	}
	
	public Carrera(){
		super();
	}
	
	
}
