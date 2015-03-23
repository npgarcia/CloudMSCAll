
package msc.ws.sesion5;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for carrera complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="carrera">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="alumnos" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="generacion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "carrera", propOrder = {
    "nombre",
    "alumnos",
    "generacion"
})
public class Carrera {

    protected String nombre;
    protected int alumnos;
    protected int generacion;

    /**
     * Gets the value of the nombre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets the value of the nombre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Gets the value of the alumnos property.
     * 
     */
    public int getAlumnos() {
        return alumnos;
    }

    /**
     * Sets the value of the alumnos property.
     * 
     */
    public void setAlumnos(int value) {
        this.alumnos = value;
    }

    /**
     * Gets the value of the generacion property.
     * 
     */
    public int getGeneracion() {
        return generacion;
    }

    /**
     * Sets the value of the generacion property.
     * 
     */
    public void setGeneracion(int value) {
        this.generacion = value;
    }

}
