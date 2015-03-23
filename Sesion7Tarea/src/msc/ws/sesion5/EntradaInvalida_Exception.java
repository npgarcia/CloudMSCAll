
package msc.ws.sesion5;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "EntradaInvalida", targetNamespace = "http://sesion5.ws.msc/")
public class EntradaInvalida_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private EntradaInvalida faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public EntradaInvalida_Exception(String message, EntradaInvalida faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public EntradaInvalida_Exception(String message, EntradaInvalida faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: msc.ws.sesion5.EntradaInvalida
     */
    public EntradaInvalida getFaultInfo() {
        return faultInfo;
    }

}
