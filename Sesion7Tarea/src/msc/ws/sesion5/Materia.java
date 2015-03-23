
package msc.ws.sesion5;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for materia complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="materia">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="clave" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="carrera" type="{http://sesion5.ws.msc/}carrera" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "materia", propOrder = {
    "clave",
    "nombre",
    "carrera"
})
public class Materia {

    protected int clave;
    protected String nombre;
    protected Carrera carrera;

    /**
     * Gets the value of the clave property.
     * 
     */
    public int getClave() {
        return clave;
    }

    /**
     * Sets the value of the clave property.
     * 
     */
    public void setClave(int value) {
        this.clave = value;
    }

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
     * Gets the value of the carrera property.
     * 
     * @return
     *     possible object is
     *     {@link Carrera }
     *     
     */
    public Carrera getCarrera() {
        return carrera;
    }

    /**
     * Sets the value of the carrera property.
     * 
     * @param value
     *     allowed object is
     *     {@link Carrera }
     *     
     */
    public void setCarrera(Carrera value) {
        this.carrera = value;
    }

}
